package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Receptionist;
import com.przychodnia.przychodnia.Repository.ReceptionistRepository;
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
public class AddReceptionistController implements Initializable {

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
    private ReceptionistRepository receptionistRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void anuluj(){
        stageManager.switchScene(FxmlView.LISTA_RECEPSJONISTOW);
    }

    @FXML
    public void dodajRecepsjoniste(){
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();

        Receptionist receptionist = new Receptionist(login,password);
        receptionist.setFirstName(firstName);
        receptionist.setLastName(lastName);

        receptionistRepository.save(receptionist);

        stageManager.switchScene(FxmlView.LISTA_RECEPSJONISTOW);
    }
}
