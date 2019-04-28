/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pz_2019_lab2_gr3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class PatientController implements Initializable {
    @FXML
    private Color x2;
    @FXML
    private Font x1;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    
    @FXML
    private AnchorPane contentPane;
    @FXML
    private Color x21;
    
    @FXML
    public void loadUserData(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/patientData.fxml"));
        contentPane.getChildren().setAll(pane);
    }
    
    @FXML
    public void loadHistory(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/treatmentHistory.fxml"));
        contentPane.getChildren().setAll(pane);
    }
    
        @FXML
    public void loadVisits(ActionEvent event) throws IOException{      
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/visits.fxml"));
        contentPane.getChildren().setAll(pane);       
    }
    
    @FXML
    public void loadPrescriptions(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/prescriptions.fxml"));
        contentPane.getChildren().setAll(pane);
    }
    
        @FXML
    public void loadNews(ActionEvent event) throws IOException{   
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/news.fxml"));
        contentPane.getChildren().setAll(pane);         
    }
    
    @FXML
    public void newVisit(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/newVisit.fxml"));
        contentPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
