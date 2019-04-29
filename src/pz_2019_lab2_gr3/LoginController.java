/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pz_2019_lab2_gr3;


import connectivity.ConnectionClass;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Account;
import models.User;

/**
 *
 * @author damia
 */
public class LoginController implements Initializable {
    
    @FXML
     public void changeWindowByButton(ActionEvent event, String window) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource(window));
        Scene mainScene = new Scene(mainWindow);

        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.show();
    }
        
    @FXML
    private TextField email_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Label loginError;

    public static int accountId;
    public static String accountLogin;
    public static String accountType;
    private static Account account;
    private static User user;
    
    @FXML
    private int connect(ActionEvent actionEvent) throws IOException, SQLException{
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
      
        String query = "select * from konta where login = '"+ email_field.getText() +"' and haslo = '"+password_field.getText()+"';";
        
        Statement stmt;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);        
        
        if(rs.next()){
            
            accountId = rs.getInt(1);
            accountLogin = rs.getString("login");
            accountType = rs.getString("rodzaj_konta");
            switch(accountType){
                case "pacjenci":{
                    changeWindowByButton(actionEvent, "/views/Patient.fxml");
                    break;
                }
                case "lekarze":{
                    changeWindowByButton(actionEvent, "/views/Doctor.fxml");
                    break;
                }
                default:{
                    changeWindowByButton(actionEvent, "/views/Receptionist.fxml");
                    break;
                }
            }            
        }else{
                loginError.setText("Nieprawidłowy login lub hasło!");
        }
        return accountId;
    }   
    
    @FXML
    private void goRegister(MouseEvent event) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/views/Registration.fxml"));
        Scene mainScene = new Scene(mainWindow);

        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.show();
    }
    
    @FXML
    private void test(){
        System.out.println("test polaczenia");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
