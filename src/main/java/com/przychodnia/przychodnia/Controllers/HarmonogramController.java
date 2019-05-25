package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
import com.przychodnia.przychodnia.config.ActUser;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;


@Controller
public class HarmonogramController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private CheckBox mondayCheckBox;

    @FXML
    private CheckBox tuesdayCheckBox;

    @FXML
    private CheckBox wednesdayCheckBox;

    @FXML
    private CheckBox thursdayCheckBox;

    @FXML
    private CheckBox fridayCheckBox;

    @FXML
    private CheckBox saturdayCheckBox;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.checkDoctorDays();
    }

    private void checkDoctorDays() {
        Doctor doctor = ActUser.getDoctor();

        this.mondayCheckBox.setSelected(doctor.getMonday());
        this.tuesdayCheckBox.setSelected(doctor.getTuesday());
        this.wednesdayCheckBox.setSelected(doctor.getWednesday());
        this.thursdayCheckBox.setSelected(doctor.getThursday());
        this.fridayCheckBox.setSelected(doctor.getFriday());
        this.saturdayCheckBox.setSelected(doctor.getSaturday());
    }

    @FXML
    public void anuluj(){
        stageManager.switchScene(FxmlView.DOCTOR);
    }

    @FXML
    public void aktualizuj(){
        Doctor doctor = ActUser.getDoctor();

        doctor.setMonday(this.mondayCheckBox.isSelected());
        doctor.setTuesday(this.tuesdayCheckBox.isSelected());
        doctor.setWednesday(this.wednesdayCheckBox.isSelected());
        doctor.setThursday(this.thursdayCheckBox.isSelected());
        doctor.setFriday(this.fridayCheckBox.isSelected());
        doctor.setSaturday(this.saturdayCheckBox.isSelected());

        doctorRepository.save(doctor);

        stageManager.switchScene(FxmlView.DOCTOR);
    }
}
