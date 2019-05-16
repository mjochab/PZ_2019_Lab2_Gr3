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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
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


    public void changeWindowByButton(ActionEvent event, String window) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource(window));
        Scene mainScene = new Scene(mainWindow);
        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.show();
    }
        

    
    public static String accountType;
    public static int accountId;

    @FXML
    private void connect(){

        String login = login_field.getText();
        String password = password_field.getText();

        List<Doctor> doctors= doctorRepository.findByLoginAndPassword(login, password);

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
    
//    @FXML
//    private void connect(ActionEvent actionEvent) throws IOException, SQLException{
//        ConnectionClass connectionClass = new ConnectionClass();
//        Connection connection = connectionClass.getConnection();
//
//        String query = "select * from konta where login = '"+ email_field.getText() +"' and haslo = '"+password_field.getText()+"';";
//
//        Statement stmt;
//        stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery(query);
//
//
//        if(rs.next()){
//            accountType = rs.getNString(4);
//            accountId = rs.getInt(1);
//            switch(accountType){
//                case "pacjenci":{
//                    changeWindowByButton(actionEvent, "/views/Patient.fxml");
//                    break;
//                }
//                case "lekarze":{
//                    changeWindowByButton(actionEvent, "/views/Doctor.fxml");
//                    break;
//                }
//                default:{
//                    changeWindowByButton(actionEvent, "/views/ReceptionistRepository.fxml");
//                    break;
//                }
//            }
//        }else{
//                loginError.setText("Nieprawidłowy login lub hasło!");
//        }
//
//    }
    @FXML
    private void goRegister(MouseEvent event) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/views/Registration.fxml"));
        Scene mainScene = new Scene(mainWindow);

        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainStage.setScene(mainScene);
        mainStage.show();
    }
    
    private void test(){
        System.out.println("test polaczenia");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
