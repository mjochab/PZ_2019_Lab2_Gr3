package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Repository.PatientRepository;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
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

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

        Patient patient = new Patient(login,password);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);

        patientRepository.save(patient);

        stageManager.switchScene(FxmlView.PATIENT_LIST_WITH_ADD_PATIENT);
    }
}
