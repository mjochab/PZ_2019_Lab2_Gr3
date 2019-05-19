package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Entity.Receptionist;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
import com.przychodnia.przychodnia.Repository.PatientRepository;
import com.przychodnia.przychodnia.Repository.ReceptionistRepository;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

@Controller
public class RegistrationController implements Initializable {

    @FXML
    TextField nameField;

    @FXML
    TextField surnameField;

    @FXML
    TextField emailField;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    TextField peselField;

    @FXML
    ComboBox<String> comboBoxRola;

    @FXML
    Label labelInfo;

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadRolesToComboBox();
    }

    @FXML
    public void cofnij(){
        stageManager.switchScene(FxmlView.LOGIN);
    }

    @FXML
    public void rejestruj(){
        String selectedRole = this.comboBoxRola.getSelectionModel().getSelectedItem();

        System.out.println("selectedRole: "+selectedRole);

        if(selectedRole == "pacjent"){
            this.registerNewPacjent();
            stageManager.switchScene(FxmlView.LOGIN);
        }
        if(selectedRole == "lekarz"){
            this.registerNewLekarz();
            stageManager.switchScene(FxmlView.LOGIN);
        }
        if(selectedRole == "recepsjonista"){
            this.registerNewRecepsjonista();
            stageManager.switchScene(FxmlView.LOGIN);
        }
        else if(selectedRole == null){
            this.labelInfo.setText("wybierz role");
        }

    }

    private void registerNewPacjent() {
        Patient patient = new Patient();
        patient.setFirstName(this.nameField.getText());
        patient.setLastName(this.surnameField.getText());
        patient.setPesel(this.peselField.getText());
        patient.setLogin(this.loginField.getText());
        patient.setPassword(this.passwordField.getText());
        patient.setEmail(this.emailField.getText());

        patientRepository.save(patient);
    }

    private void registerNewRecepsjonista() {
        Receptionist receptionist = new Receptionist();
        receptionist.setFirstName(this.nameField.getText());
        receptionist.setLastName(this.surnameField.getText());
        receptionist.setPesel(this.peselField.getText());
        receptionist.setLogin(this.loginField.getText());
        receptionist.setPassword(this.passwordField.getText());
        receptionist.setEmail(this.emailField.getText());

        receptionistRepository.save(receptionist);
    }

    private void registerNewLekarz() {
        Doctor doctor = new Doctor();
        doctor.setFirstName(this.nameField.getText());
        doctor.setLastName(this.surnameField.getText());
        doctor.setPesel(this.peselField.getText());
        doctor.setLogin(this.loginField.getText());
        doctor.setPassword(this.passwordField.getText());
        doctor.setEmail(this.emailField.getText());

        doctorRepository.save(doctor);
    }

    private void loadRolesToComboBox() {

        ArrayList<String> rolesList= new ArrayList<String>() {{
            add("lekarz");
            add("recepsjonista");
            add("pacjent");
        }};

        ObservableList<String> observableList = FXCollections.observableArrayList();

        observableList.addAll(rolesList);

        this.comboBoxRola.setItems(observableList);
//        this.comboBoxRola.getSelectionModel().selectLast();
    }
}
