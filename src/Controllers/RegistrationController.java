/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import connectivity.ConnectionClass;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class RegistrationController implements Initializable {
    
    @FXML
     public void goLogin(ActionEvent event) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        Scene mainScene = new Scene(mainWindow);

        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.show();
    }
    
     
     @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField repeatPasswordField;
    private String accountType = "pacjent";
    
     
    @FXML
    private Boolean isUnique(String login) throws SQLException{       
        ConnectionClass connectionClass = new ConnectionClass();
        ResultSet rs = null;
        try (Connection connection = connectionClass.getConnection()) {
            String query = "select login from konta where login = '"+ login +"';";
            Statement stmt;
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            return !rs.first();
        }catch(Exception e){
            return !rs.first();
        }
    }
    
    @FXML
    public Boolean isFormFilled(){
        return !"".equals(nameField.getText()) && !"".equals(surnameField.getText()) && !"".equals(emailField.getText())
                && !"".equals(loginField.getText())&& !"".equals(passwordField.getText()) 
                && !"".equals(repeatPasswordField.getText());             
    }
    
    @FXML
    public Boolean checkPassword(){
        return passwordField.getText().equals(repeatPasswordField.getText());
    }
    
    @FXML
    public void registerUser() throws SQLException{
        if(isFormFilled() && checkPassword()&& isUnique(loginField.getText())){
            System.out.println("formularz poprawny");
            
            ConnectionClass connectionClass = new ConnectionClass();
            ResultSet rs = null;
            try (Connection connection = connectionClass.getConnection()) {
            String insertIntoAccountsQuerry = "insert into konta values (null, '"+loginField.getText() +"','"+passwordField.getText()+"','"+accountType+"');";
            //String insertIntoPatientsQuerry = "insert into pacjenci values (null, '"+nameField.getText() + "', '"+surnameField.getText() + "', '"+emailField.getText()+"',null,null,null,null,null.null,null,null);";
                System.out.println(insertIntoAccountsQuerry);
                //System.out.println(insertIntoPatientsQuerry);
            PreparedStatement stmt= connection.prepareStatement(insertIntoAccountsQuerry);
            //PreparedStatement stmt2= connection.prepareStatement(insertIntoPatientsQuerry);
            stmt.execute();
            //stmt2.execute();
            }catch(Exception e){
                System.out.println("Nie udało się polaczyc z baza");
            }
        }else{
            
            System.out.println("error");
            
        }
        
    }
    public void setAccountType(String type){
        accountType = type;
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
