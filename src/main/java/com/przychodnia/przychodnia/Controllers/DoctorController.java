/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.News;
import com.przychodnia.przychodnia.Entity.Wizyta;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
import com.przychodnia.przychodnia.Repository.NewsRepository;
import com.przychodnia.przychodnia.Repository.WizytaRepository;
import com.przychodnia.przychodnia.config.ActUser;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * FXML Controller class
 *
 * @author damia
 */
@Controller
public class DoctorController implements Initializable {

    @FXML
    public AnchorPane contentPane;

    @FXML
    private Label label1News;

    @FXML
    private Label description1News;

    @FXML
    private Label label2News;

    @FXML
    private Label description2News;

    @FXML
    private Label kalendarz1Title;

    @FXML
    private Label kalendarz2Title;

    @FXML
    private Label kalendarz3Title;

    @FXML
    private Label kalendarz1content;

    @FXML
    private Label kalendarz2content;

    @FXML
    private Label kalendarz3content;

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private WizytaRepository wizytaRepository;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadNews();
        this.loadKalendarz();
    }

    private void loadKalendarz() {
        List<Wizyta> wizyty = wizytaRepository.findByDoctor(ActUser.getDoctor());
        List<Wizyta> wizytaAfter = wizyty.stream()
                .filter(wizyta1 -> wizyta1.getLocalDateTime()
                        .isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());

        if(wizytaAfter.size()>0){
            this.kalendarz1Title.setText(this.localDateTimetoString(wizytaAfter.get(0).getLocalDateTime()));
            this.kalendarz1content.setText("pacjent: \n"+wizytaAfter.get(0).getKartoteka().getPatient().toString());
        }
        if(wizytaAfter.size()>1){
            this.kalendarz2Title.setText(this.localDateTimetoString(wizytaAfter.get(1).getLocalDateTime()));
            this.kalendarz2content.setText("pacjent: \n"+wizytaAfter.get(1).getKartoteka().getPatient().toString());
        }
        if(wizytaAfter.size()>2){
            this.kalendarz3Title.setText(this.localDateTimetoString(wizytaAfter.get(2).getLocalDateTime()));
            this.kalendarz3content.setText("pacjent: \n"+wizytaAfter.get(2).getKartoteka().getPatient().toString());
        }
    }

    private String localDateTimetoString(LocalDateTime localDateTime){
        if(localDateTime.getMinute()>10) {
            return localDateTime.getDayOfMonth() + "-"
                    + localDateTime.getMonthValue() + "-"
                    + localDateTime.getYear() +
                    "\n" + localDateTime.getHour()
                    + ":" + localDateTime.getMinute();
        }
        else {
            return localDateTime.getDayOfMonth() + "-"
                    + localDateTime.getMonthValue() + "-"
                    + localDateTime.getYear() +
                    "\n" + localDateTime.getHour()
                    + ":0" + localDateTime.getMinute();
        }
    }

    public void loadUserData(ActionEvent event){
         stageManager.switchScene(FxmlView.USER_DATA);
    }
    
    public void loadPatients(ActionEvent event){
        stageManager.switchScene(FxmlView.PATIENT_LIST);
    }
    
    public void loadVisits(ActionEvent event){
        stageManager.switchScene(FxmlView.WIZYTY);
    }
    
    public void loadPrescriptions(ActionEvent event){
        stageManager.switchScene(FxmlView.RECEPTY);
    }
    
    public void loadNews(){
        int newsLength = 2;
        List<News> newsList = newsRepository.randomNews(newsLength);

        if(newsList.size()==newsLength){
            this.label1News.setText(newsList.get(0).getTitle());
            this.description1News.setText(newsList.get(0).getContent());

            this.label2News.setText(newsList.get(1).getTitle());
            this.description2News.setText(newsList.get(1).getContent());
        }
    }

    public void loadHarmonogram(){
        stageManager.switchScene(FxmlView.HARMONOGRAM);
    }

    @FXML
    public void wyloguj(){
        ActUser.setDoctor(null);
        stageManager.switchScene(FxmlView.LOGIN);
    }
    
}
