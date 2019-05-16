/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 *
 * @author damia
 */
public class SaveChangesController {
    
    @FXML
    private Button cancel;
    
    @FXML
    private Button save;
    
    @FXML
    private void cancel(ActionEvent event){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void save(ActionEvent event){
        Stage stage = (Stage) save.getScene().getWindow();
        stage.close();
    }
    
    public void initialize(URL url, ResourceBundle rb) {

    }
}
