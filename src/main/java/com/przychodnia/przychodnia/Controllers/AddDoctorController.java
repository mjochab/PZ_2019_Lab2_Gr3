package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
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
public class AddDoctorController implements Initializable {

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
    private DoctorRepository doctorRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void anuluj(){
        stageManager.switchScene(FxmlView.LISTA_DOKTOROW);
    }

    @FXML
    public void dodajLekarza(){
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();

        Doctor doctor = new Doctor(login,password);
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);

        doctorRepository.save(doctor);

        stageManager.switchScene(FxmlView.LISTA_DOKTOROW);
    }
}
