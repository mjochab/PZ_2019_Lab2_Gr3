/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.LoginController.accountType;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class PatientsListController implements Initializable {
    @FXML
    private ChoiceBox filter;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private Button addPatient;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filter.setItems(FXCollections.observableArrayList("Imie","Nazwisko","PESEL"));
        
         if (accountType.equals("recepcjonista")){
            addPatient.visibleProperty().setValue(Boolean.TRUE);    
        }
    }   
    @FXML
    private void addPatient(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Registration.fxml"));
        AnchorPane pane = loader.load();
        RegistrationController registrationController = loader.getController();
        registrationController.setAccountType("pacjent");
        contentPane.getChildren().setAll(pane);
    }
    
}
