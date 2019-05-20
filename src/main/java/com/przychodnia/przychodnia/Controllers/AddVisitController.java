package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Entity.Wizyta;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
import com.przychodnia.przychodnia.Repository.PatientRepository;
import com.przychodnia.przychodnia.Repository.WizytaRepository;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class AddVisitController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    ComboBox<Patient> pacjentComboBox;

    @FXML
    ComboBox<Doctor> lekarzComboBox;

    @FXML
    DatePicker dataDatePicker;

    @FXML
    Spinner<Integer> godzinaSpinner;

    @FXML
    Spinner<Integer> minutaSpinner;

    @FXML
    Label labelInfo;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    WizytaRepository wizytaRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadPacjentComboBox();
        this.loadLekarzComboBox();
        this.loadSpinnersValues();
    }

    private void loadSpinnersValues() {

        this.dataDatePicker.setValue(LocalDate.now());

        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 15, 8);

        godzinaSpinner.setValueFactory(valueFactory);

        SpinnerValueFactory<Integer> valueFactory2 = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60, 0);

        minutaSpinner.setValueFactory(valueFactory2);
    }

    private void loadPacjentComboBox() {
        List<Patient> userList = patientRepository.findAll();
        ObservableList<Patient> taskObservableList = FXCollections.observableArrayList();
        taskObservableList.addAll(userList);
        this.pacjentComboBox.setItems(taskObservableList);
    }


    private void loadLekarzComboBox() {
        List<Doctor> doctorList= doctorRepository.findAll();
        ObservableList<Doctor> taskObservableList = FXCollections.observableArrayList();
        taskObservableList.addAll(doctorList);
        this.lekarzComboBox.setItems(taskObservableList);
    }


    @FXML
    public void dodajWizyte(){



        Patient selectedPatient = pacjentComboBox.getSelectionModel().getSelectedItem();
        Doctor selectedDoctor = lekarzComboBox.getSelectionModel().getSelectedItem();
        LocalDate localDate = dataDatePicker.getValue();
        int godzina = godzinaSpinner.getValue();
        int minuta = minutaSpinner.getValue();

        LocalDateTime localDateTime = localDate.atTime(godzina,minuta);

        if(this.isNotSunday(localDateTime)) {
            Wizyta wizyta = new Wizyta();
            wizyta.setDoctor(selectedDoctor);
            wizyta.setLocalDateTime(localDateTime);
            wizyta.setKartoteka(selectedPatient.getKartoteka());

            wizytaRepository.save(wizyta);
            stageManager.switchScene(FxmlView.LISTA_WIZYT_PANEL_RECEPSJONISTY);
        }
        else{
            labelInfo.setText("Przychodznia nieczynna w niedzielę");
        }
    }

    private boolean isNotSunday(LocalDateTime localDateTime) {
        if(localDateTime.getDayOfWeek().getValue()==7){
            return false;
        }
        else{
            return true;
        }
    }

    @FXML
    public void anuluj(){
        stageManager.switchScene(FxmlView.LISTA_WIZYT_PANEL_RECEPSJONISTY);
    }
}
