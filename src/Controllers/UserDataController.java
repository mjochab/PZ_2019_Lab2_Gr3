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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.User;
import static Controllers.LoginController.accountId;
import static Controllers.LoginController.accountType;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class UserDataController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField peselField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField buildingField;
    @FXML
    private TextField flatField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField postField;
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button saveChanges;
    
    @FXML
    private int getData() throws IOException, SQLException{
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
      
        String query = "select * from konta where konto_id = 1 ;";
        
        Statement stmt;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query); 
        System.out.println(rs.getString("login"));
        return 1;
    }
    
    @FXML
    private void saveChanges(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/saveChanges.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        
        stage.show();
        
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // tutaj piszesz kod, ktory sie po wczytaniu widoku generuje
        
    }
    
}
