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
 * @author asd
 */
@Controller
public class ReceptionistController implements Initializable {
    
    @FXML
    public AnchorPane contentPane;

    @Lazy
    @Autowired
    private StageManager stageManager;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void wyloguj(){
        ActUser.setReceptionist(null);
        stageManager.switchScene(FxmlView.LOGIN);
    }
    
    public void loadUserData(ActionEvent event) throws IOException{
        stageManager.switchScene(FxmlView.USER_DATA);
    }
    
    public void loadDoctors(ActionEvent event) throws IOException{
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/doctorsList.fxml"));
//        contentPane.getChildren().setAll(pane);
        stageManager.switchScene(FxmlView.LISTA_DOKTOROW);
    }
    
    public void loadPatients(ActionEvent event) throws IOException{
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/patientsList.fxml"));
//        contentPane.getChildren().setAll(pane);
        stageManager.switchScene(FxmlView.PATIENT_LIST_WITH_ADD_PATIENT);
    }
    
    public void loadReceptionists(ActionEvent event) throws IOException{
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/receptionistsList.fxml"));
////        contentPane.getChildren().setAll(pane);
        stageManager.switchScene(FxmlView.LISTA_RECEPSJONISTOW);
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
