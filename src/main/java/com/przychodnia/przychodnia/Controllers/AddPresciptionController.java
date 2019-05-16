package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Kartoteka;
import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Entity.Presciption;
import com.przychodnia.przychodnia.Repository.KartotekaRepository;
import com.przychodnia.przychodnia.Repository.PatientRepository;
import com.przychodnia.przychodnia.Repository.PresciptionsRepository;
import com.przychodnia.przychodnia.config.ActUser;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class AddPresciptionController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    TextArea receptaTextArea;

    @FXML
    ComboBox<Patient> pacjentComboBox;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private KartotekaRepository kartotekaRepository;

    @Autowired
    private PresciptionsRepository presciptionRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadPacjentComboBox();
    }

    private void loadPacjentComboBox() {

        List<Patient> userList = patientRepository.findAll();
        ObservableList<Patient> taskObservableList = FXCollections.observableArrayList();
        taskObservableList.addAll(userList);
        this.pacjentComboBox.setItems(taskObservableList);
    }

    @FXML
    public void anuluj(){
        stageManager.switchScene(FxmlView.RECEPTY);
    }

    @FXML
    public void dodajRecepte(){
        String description = receptaTextArea.getText();
        Patient patient = pacjentComboBox.getSelectionModel().getSelectedItem();
        Kartoteka kartoteka = kartotekaRepository.findByPatient(patient);

        Presciption presciption = new Presciption();
        presciption.setKartoteka(kartoteka);
        presciption.setDoctor(ActUser.getDoctor());
        presciption.setLocalDateTime(LocalDateTime.now());
        presciption.setDescription(description);

        presciptionRepository.save(presciption);

        stageManager.switchScene(FxmlView.RECEPTY);
    }
}
