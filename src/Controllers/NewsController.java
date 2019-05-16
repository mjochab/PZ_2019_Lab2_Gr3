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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import static Controllers.LoginController.accountId;
import static Controllers.LoginController.accountType;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author damia
 */
public class NewsController implements Initializable {
    @FXML
    private Button addNews;
    @FXML
    private Label title1;
    @FXML
    private Label article1;
    @FXML
    private Color x2;
    @FXML
    private Label title2;
    @FXML
    private Label article2;
    @FXML
    private Color x21;
    @FXML
    private Label title3;
    @FXML
    private Label article3;
    @FXML
    public AnchorPane contentPane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (accountType.equals("recepcjonisci")){
            addNews.visibleProperty().setValue(Boolean.TRUE);    
        }
    }    
    
    @FXML
    private void addNews(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/addNews.fxml"));
        contentPane.getChildren().setAll(pane);
        
    }
    
}
