/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author damia
 */
@Controller
public class LoginController implements Initializable {
    @FXML
    private Label login_label;
    @FXML
    private Button cancel;
    @FXML
    private Button save;
    @FXML
    private Label error;

    @FXML
    private TextField login_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Label loginError;

    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ReceptionistRepository receptionistRepository;


    @FXML
    private void connect(){

        String login = login_field.getText();
        String password = password_field.getText();

        List<Doctor> doctors = doctorRepository.findByLoginAndPassword(login, password);

        if(doctors.size()==1){
            ActUser.setDoctor(doctors.get(0));
            ActUser.setUserRole("doctor");
            stageManager.switchScene(FxmlView.DOCTOR);
        }

        List<Patient> patients = patientRepository.findByLoginAndPassword(login,password);

        if(patients.size()==1){
            ActUser.setPatient(patients.get(0));
            ActUser.setUserRole("patient");
            stageManager.switchScene(FxmlView.PATIENT);
        }

        List<Receptionist> receptionists = receptionistRepository.findByLoginAndPassword(login,password);

        if(receptionists.size()==1){
            ActUser.setReceptionist(receptionists.get(0));
            ActUser.setUserRole("receptionist");
            stageManager.switchScene(FxmlView.RECEPTIONIST);
        }

        else{
            loginError.setText("Nieprawidłowy login lub hasło!");
        }
    }

    @FXML
    private void goRegister(){
        stageManager.switchScene(FxmlView.REJESTRACJA);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
