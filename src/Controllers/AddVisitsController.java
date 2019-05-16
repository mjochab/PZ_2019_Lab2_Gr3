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
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author damia
 */
public class AddVisitsController implements Initializable {
    @FXML
    private Label labelPESEL;
    @FXML
    private TextField pesel;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!accountType.equals("pacjenci")){
            labelPESEL.visibleProperty().setValue(Boolean.TRUE);
            pesel.visibleProperty().setValue(Boolean.TRUE);
        }
    }    
    
}
