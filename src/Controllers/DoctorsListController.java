/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import static Controllers.LoginController.accountId;
import static Controllers.LoginController.accountType;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class DoctorsListController implements Initializable {
    @FXML
    private Button addDoctor;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private ChoiceBox filter;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (accountType.equals("recepcjonista")){
            addDoctor.visibleProperty().setValue(Boolean.TRUE);    
        }
        filter.setItems(FXCollections.observableArrayList("Imie","Nazwisko","PESEL"));
    }    
    
    @FXML
    private void addDoctor(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Registration.fxml"));
        AnchorPane pane = loader.load();
        RegistrationController registrationController = loader.getController();
        registrationController.setAccountType("lekarz");
        contentPane.getChildren().setAll(pane);
    }
    
    
    
}
