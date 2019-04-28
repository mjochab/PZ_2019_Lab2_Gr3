/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pz_2019_lab2_gr3;


import connectivity.ConnectionClass;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    private PasswordField password_field;
    
    public String getLogin(){
        return email_field.getText();
    }

    
    @FXML
    private void connect(ActionEvent actionEvent) throws IOException, SQLException{
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String log = getLogin();
//        String pass = getPassword();
        
        String query = "select * from konta where login = '"+ log +"';";
        
        Statement stmt;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        
        if(rs.next()){
            changeWindowByButton(actionEvent, "/views/Patient.fxml");
//            
        }else{
                System.out.println("logowanie nie powiodlo sie");
                //linie testowe

        }
        
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
