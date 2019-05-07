/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asd
 */
public class ReceptionistController implements Initializable {
    
    @FXML
    public AnchorPane contentPane;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void loadUserData(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/userData.fxml"));
        contentPane.getChildren().setAll(pane);
    }
    
    public void loadDoctors(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/doctorsList.fxml"));
        contentPane.getChildren().setAll(pane);
    }
    
    public void loadPatients(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/patientsList.fxml"));
        contentPane.getChildren().setAll(pane);
    }
    
    public void loadReceptionists(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/receptionistsList.fxml"));
        contentPane.getChildren().setAll(pane);
    }
    
    public void loadVisits(ActionEvent event) throws IOException{      
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/visits.fxml"));
        contentPane.getChildren().setAll(pane);       
    }
    
    public void loadNews(ActionEvent event) throws IOException{   
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/news.fxml"));
        contentPane.getChildren().setAll(pane);

    }
    
}
