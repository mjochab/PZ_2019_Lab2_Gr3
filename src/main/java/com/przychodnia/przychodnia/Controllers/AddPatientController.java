package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
import com.przychodnia.przychodnia.Repository.PatientRepository;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class AddPatientController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    TextField loginTextField;
    @FXML
    PasswordField passwordTextField;
    @FXML
    TextField firstNameTextField;
    @FXML
    TextField lastNameTextField;
    @FXML
    ComboBox<Doctor> doctorComboBox;

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadDoctorToComboBox();
    }

    private void loadDoctorToComboBox() {
        List<Doctor> doctorList= doctorRepository.findAll();
        ObservableList<Doctor> taskObservableList = FXCollections.observableArrayList();
        taskObservableList.addAll(doctorList);
        this.doctorComboBox.setItems(taskObservableList);

        this.doctorComboBox.getSelectionModel().select(0);
    }

    @FXML
    public void anuluj(){
        stageManager.switchScene(FxmlView.PATIENT_LIST_WITH_ADD_PATIENT);
    }

    @FXML
    public void dodajPacjenta(){
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        Doctor selectedDoctor = doctorComboBox.getSelectionModel().getSelectedItem();

        Patient patient = new Patient(login,password, selectedDoctor);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);

        patientRepository.save(patient);

        stageManager.switchScene(FxmlView.PATIENT_LIST_WITH_ADD_PATIENT);
    }
}
