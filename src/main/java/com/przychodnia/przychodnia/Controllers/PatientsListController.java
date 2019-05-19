package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.Repository.PatientRepository;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class PatientsListController implements Initializable {

    @FXML
    TextField filterTextField;

    @FXML
    TableView<Patient> patientTable;

    @FXML
    TableColumn<Patient,String> columnImie;

    @FXML
    TableColumn<Patient,String> columnNazwisko;

    @FXML
    TableColumn<Patient,String> columnPesel;

    @Autowired
    PatientRepository patientRepository;

    @Lazy
    @Autowired
    private StageManager stageManager;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadPatientsToTable();
    }

    @FXML
    public void filter(){
        String filter = this.filterTextField.getText();
        List<Patient> patients = this.patientRepository.findByFirstNameLastNamePesel(filter,filter,filter);
        this.refreshTable(patients);
    }


    @FXML
    public void wstecz(){
        stageManager.switchScene(FxmlView.DOCTOR);
    }

    private void loadPatientsToTable() {
        List<Patient> patients = patientRepository.findAll();
        this.refreshTable(patients);
    }

    private void refreshTable(List<Patient> patients){



        this.patientTable.getColumns().clear();

        final ObservableList<Patient> data = FXCollections.observableArrayList();
        data.addAll(patients);

        columnImie.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        columnNazwisko.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );
        columnPesel.setCellValueFactory(
                new PropertyValueFactory<>("pesel")
        );

        this.patientTable.setItems(data);

        this.patientTable.getColumns().addAll(columnImie, columnNazwisko, columnPesel);
    }

    @FXML
    public void addPatient(){

    }


}

