package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Doctor;
import com.przychodnia.przychodnia.Repository.DoctorRepository;
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
public class DoctorsListController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    TextField filterTextField;

    @FXML
    TableView<Doctor> lekarzeTableView;

    @FXML
    TableColumn<Doctor,String> columnImie;

    @FXML
    TableColumn<Doctor,String> columnNazwisko;

    @FXML
    TableColumn<Doctor,String> columnPesel;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadDoctorToTable();
    }

    @FXML
    public void filter(){
        String filter = this.filterTextField.getText();
        List<Doctor> patients = this.doctorRepository.findByFirstNameLastNamePesel(filter,filter,filter);
        this.refreshTable(patients);
    }

    private void loadDoctorToTable() {
        List<Doctor> doctors = doctorRepository.findAll();
        this.refreshTable(doctors);
    }

    private void refreshTable(List<Doctor> doctors){
        this.lekarzeTableView.getColumns().clear();

        final ObservableList<Doctor> data = FXCollections.observableArrayList();
        data.addAll(doctors);

        columnImie.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        columnNazwisko.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );
        columnPesel.setCellValueFactory(
                new PropertyValueFactory<>("pesel")
        );

        this.lekarzeTableView.setItems(data);

        this.lekarzeTableView.getColumns().addAll(columnImie, columnNazwisko, columnPesel);
    }


    @FXML
    public void wstecz(){
        stageManager.switchScene(FxmlView.RECEPTIONIST);
    }

    @FXML
    public void addDoctor(){
        stageManager.switchScene(FxmlView.DODAJ_LEKARZA);
    }
}
