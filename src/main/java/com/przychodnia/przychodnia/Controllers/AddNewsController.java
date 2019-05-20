package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.News;
import com.przychodnia.przychodnia.Repository.NewsRepository;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class AddNewsController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    TextArea trescTextArea;

    @FXML
    TextField tytulTextField;

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void dodajAktualnosc(){
        String tytul = tytulTextField.getText();
        String content = trescTextArea.getText();

        News news = new News(tytul,content);

        newsRepository.save(news);
        stageManager.switchScene(FxmlView.RECEPTIONIST);
    }

    @FXML
    public void anuluj(){
        stageManager.switchScene(FxmlView.RECEPTIONIST);
    }


}
