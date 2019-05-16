package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Entity.Receptionist;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
import com.przychodnia.przychodnia.Repository.PatientRepository;
import com.przychodnia.przychodnia.Repository.ReceptionistRepository;
import com.przychodnia.przychodnia.config.ActUser;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class UserDataController implements Initializable {

    @FXML
    TextField nameField;
    @FXML
    TextField surnameField;
    @FXML
    TextField emailField;
    @FXML
    TextField phoneField;
    @FXML
    TextField peselField;
    @FXML
    TextField addressField;

    @FXML
    TextField loginField;
    @FXML
    TextField passwordField;
    @FXML
    TextField postcodeField;

    @FXML
    Button saveChanges;

    @Lazy
    @Autowired
    DoctorRepository doctorRepository;

    @Lazy
    @Autowired
    PatientRepository patientRepository;

    @Lazy
    @Autowired
    ReceptionistRepository receptionistRepository;

    @Lazy
    @Autowired
    StageManager stageManager;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadActualDataToTextFields();
    }

    private void loadActualDataToTextFields() {

        if(ActUser.getUserRole().equals("doctor")) {
            this.nameField.setText(ActUser.getDoctor().getFirstName());
            this.surnameField.setText(ActUser.getDoctor().getLastName());
            this.emailField.setText(ActUser.getDoctor().getEmail());
            this.phoneField.setText(ActUser.getDoctor().getPhone());
            this.peselField.setText(ActUser.getDoctor().getPesel());
            this.addressField.setText(ActUser.getDoctor().getAddress());
            this.loginField.setText(ActUser.getDoctor().getLogin());
            this.passwordField.setText(ActUser.getDoctor().getPassword());
            this.postcodeField.setText(ActUser.getDoctor().getPostcode());
        }
        else if(ActUser.getUserRole().equals("patient")) {
            this.nameField.setText(ActUser.getPatient().getFirstName());
            this.surnameField.setText(ActUser.getPatient().getLastName());
            this.emailField.setText(ActUser.getPatient().getEmail());
            this.phoneField.setText(ActUser.getPatient().getPhone());
            this.peselField.setText(ActUser.getPatient().getPesel());
            this.addressField.setText(ActUser.getPatient().getAddress());
            this.loginField.setText(ActUser.getPatient().getLogin());
            this.passwordField.setText(ActUser.getPatient().getPassword());
            this.postcodeField.setText(ActUser.getPatient().getPostcode());
        }
        else if(ActUser.getUserRole().equals("receptionist")) {
            this.nameField.setText(ActUser.getReceptionist().getFirstName());
            this.surnameField.setText(ActUser.getReceptionist().getLastName());
            this.emailField.setText(ActUser.getReceptionist().getEmail());
            this.phoneField.setText(ActUser.getReceptionist().getPhone());
            this.peselField.setText(ActUser.getReceptionist().getPesel());
            this.addressField.setText(ActUser.getReceptionist().getAddress());
            this.loginField.setText(ActUser.getReceptionist().getLogin());
            this.passwordField.setText(ActUser.getReceptionist().getPassword());
            this.postcodeField.setText(ActUser.getReceptionist().getPostcode());
        }
    }

    @FXML
    public void saveChanges(){
        if(ActUser.getUserRole().equals("doctor")) {
            Doctor doctor = ActUser.getDoctor();
            doctor.setFirstName(this.nameField.getText());
            doctor.setLastName(this.surnameField.getText());
            doctor.setEmail(this.emailField.getText());
            doctor.setPhone(this.phoneField.getText());
            doctor.setPesel(this.peselField.getText());
            doctor.setAddress(this.addressField.getText());
            doctor.setLogin(this.loginField.getText());
            doctor.setPassword(this.passwordField.getText());
            doctor.setPostcode(this.postcodeField.getText());
            doctorRepository.save(doctor);
            stageManager.switchScene(FxmlView.DOCTOR);
        }
        else if(ActUser.getUserRole().equals("patient")){
            Patient patient = ActUser.getPatient();
            patient.setFirstName(this.nameField.getText());
            patient.setLastName(this.surnameField.getText());
            patient.setEmail(this.emailField.getText());
            patient.setPhone(this.phoneField.getText());
            patient.setPesel(this.peselField.getText());
            patient.setAddress(this.addressField.getText());
            patient.setLogin(this.loginField.getText());
            patient.setPassword(this.passwordField.getText());
            patient.setPostcode(this.postcodeField.getText());
            patientRepository.save(patient);
            stageManager.switchScene(FxmlView.PATIENT);
        }

        else if(ActUser.getUserRole().equals("receptionist")){
            Receptionist receptionist = ActUser.getReceptionist();
            receptionist.setFirstName(this.nameField.getText());
            receptionist.setLastName(this.surnameField.getText());
            receptionist.setEmail(this.emailField.getText());
            receptionist.setPhone(this.phoneField.getText());
            receptionist.setPesel(this.peselField.getText());
            receptionist.setAddress(this.addressField.getText());
            receptionist.setLogin(this.loginField.getText());
            receptionist.setPassword(this.passwordField.getText());
            receptionist.setPostcode(this.postcodeField.getText());
            receptionistRepository.save(receptionist);
            stageManager.switchScene(FxmlView.RECEPTIONIST);
        }
    }

    @FXML
    public void anuluj(){
        if(ActUser.getUserRole().equals("doctor")) {
            stageManager.switchScene(FxmlView.DOCTOR);
        }
        else if(ActUser.getUserRole().equals("patient")) {
            stageManager.switchScene(FxmlView.PATIENT);
        }
        else if(ActUser.getUserRole().equals("receptionist")) {
            stageManager.switchScene(FxmlView.RECEPTIONIST);
        }
    }
}
