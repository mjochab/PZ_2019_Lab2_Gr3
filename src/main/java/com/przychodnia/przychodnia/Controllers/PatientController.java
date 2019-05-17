/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.config.ActUser;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author damia
 */
@Controller
public class PatientController implements Initializable {
    
    @FXML
    public AnchorPane contentPane;
    @FXML
    private Label title1;
    @FXML
    private Label article1;

    @Lazy
    @Autowired
    private StageManager stageManager;
    
    public void loadUserData(ActionEvent event) throws IOException{
        stageManager.switchScene(FxmlView.USER_DATA);
    }
    
    public void loadHistory(ActionEvent event) throws IOException{
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/treatmentHistory.fxml"));
//        contentPane.getChildren().setAll(pane);
        stageManager.switchScene(FxmlView.TREATMENT_HISTORY);
    }
    
    public void loadVisits(ActionEvent event) throws IOException{      
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/visits.fxml"));
//        contentPane.getChildren().setAll(pane);
        stageManager.switchScene(FxmlView.WIZYTY_PANEL_PACJENTA);
    }
    
    public void loadPrescriptions(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/prescriptions.fxml"));
        contentPane.getChildren().setAll(pane);
    }
    
    public void loadNews(ActionEvent event) throws IOException{   
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/news.fxml"));
        contentPane.getChildren().setAll(pane);
        title1.setText("artykul1");
        article1.setText("tresc artykulu");
    }

    @FXML
    public void wyloguj(){

        ActUser.setPatient(null);
        stageManager.switchScene(FxmlView.LOGIN);
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
