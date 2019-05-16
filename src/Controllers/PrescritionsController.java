/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static Controllers.LoginController.accountId;
import static Controllers.LoginController.accountType;
/**
 * FXML Controller class
 *
 * @author damia
 */
public class PrescritionsController implements Initializable {
    @FXML
    private Button addPrescription;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (accountType.equals("lekarze")){
            addPrescription.visibleProperty().setValue(Boolean.TRUE);    
        }     
    }    
    
}
