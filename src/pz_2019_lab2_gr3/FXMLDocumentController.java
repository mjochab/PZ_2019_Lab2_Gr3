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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author damia
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private void zaloguj(ActionEvent event, String window) throws IOException{
        Parent okno_pacjenta = FXMLLoader.load(getClass().getResource(window));
        Scene okno_pacjenta_scene = new Scene(okno_pacjenta);
        
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(okno_pacjenta_scene);
        app_stage.show();
    }
        
    @FXML
    private TextField email_field;
    private PasswordField password_field;
    
    public String getEmail(){
        return email_field.getText();
    }
    
    public String getPassword(){
        
        return password_field.toString();
    }

    
    @FXML
    private void connect(ActionEvent actionEvent) throws IOException, SQLException{
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        
        
        String query = "select login from konta";
        
        Statement stmt;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        String log = getEmail();
        System.out.println("");

        
            if(rs.next() && log.equals(rs.getString(1))){
                zaloguj(actionEvent, "FXMLOknoPacjenta.fxml");

            }else{
                System.out.println("logowanie nie powiodlo sie");
            }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
