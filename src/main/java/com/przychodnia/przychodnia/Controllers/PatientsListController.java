package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Patient;
import com.przychodnia.przychodnia.PersonTableView.PersonTableView;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class PatientsListController implements Initializable {

    @FXML
    TextField filterTextField;

    @FXML
    TableView<PersonTableView> patientTable;

    @FXML
    TableColumn<PersonTableView,String> columnImie;

    @FXML
    TableColumn<PersonTableView,String> columnNazwisko;

    @FXML
    TableColumn<PersonTableView,String> columnPesel;

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

    }

    @FXML
    public void wstecz(){
        stageManager.switchScene(FxmlView.DOCTOR);
    }

    private void loadPatientsToTable() {

        this.patientTable.getColumns().clear();

        List<Patient> patients = patientRepository.findAll();
//        this.patientTable.
        final ObservableList<PersonTableView> data = FXCollections.observableArrayList();
        data.addAll(patientsToPersonTableView(patients));

        System.out.println("userzy "+data.size()+" userzy: "+data);

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
//        this.patientTable.getColumns().setAll()

        this.patientTable.getColumns().addAll(columnImie, columnNazwisko, columnPesel);

    }

    private List<PersonTableView> patientsToPersonTableView(List<Patient> patients) {

        List<PersonTableView> personTableViews = new ArrayList<PersonTableView>();

        for(Patient x : patients){
            PersonTableView personTableView = new PersonTableView(x.getFirstName(),x.getLastName(),x.getPesel());
            personTableViews.add(personTableView);
        }
        return personTableViews;
    }

    @FXML
    public void addPatient(){

    }


}

