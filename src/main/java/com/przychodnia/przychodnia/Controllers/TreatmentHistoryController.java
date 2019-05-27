package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.CreatePdf.CreatePdf;
import com.przychodnia.przychodnia.Entity.Presciption;
import com.przychodnia.przychodnia.Entity.Wizyta;
import com.przychodnia.przychodnia.Repository.PresciptionsRepository;
import com.przychodnia.przychodnia.Repository.WizytaRepository;
import com.przychodnia.przychodnia.config.ActUser;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Controller
public class TreatmentHistoryController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    TableView<Wizyta> tableHistoria;

    @FXML
    TableColumn<Wizyta, LocalDateTime> columnData;

    @FXML
    TableColumn<Wizyta,String> columnLekarz;

    @Autowired
    WizytaRepository wizytaRepository;

    @FXML
    Label infoLabel;

    @FXML
    TextField szukajTextField;

    @Autowired
    private PresciptionsRepository presciptionRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadHistoria();
    }

    @FXML
    public void drukuj(){
        List<Wizyta> wizyty = wizytaRepository.findByKartoteka(ActUser.getPatient().getKartoteka());
        List<Presciption> presciptions= presciptionRepository.findByKartoteka(ActUser.getPatient().getKartoteka());
        String info = CreatePdf.generatePdfKartoteka(ActUser.getPatient().getKartoteka(),wizyty, presciptions);
        if(info == "blad"){
            this.infoLabel.setText("nie udało się utworzyć kartoteki");
        }
        else{
            this.infoLabel.setText("Kartoteka zapisana w lokalizacji: "+info);
        }
    }

    @FXML
    public void szukaj(){
        String filter = this.szukajTextField.getText();

        List<Wizyta> wizyta = wizytaRepository.findByKartoteka(ActUser.getPatient().getKartoteka());
        List<Wizyta> wizytaBefore = wizyta.stream()
                .filter(wizyta1 -> wizyta1.getLocalDateTime()
                        .isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());

        if(filter.equals("")){
            this.refreshTable(wizytaBefore);
        }
        else {
            List<Wizyta> filteredWizyta = wizytaBefore.stream().filter(p -> p.getDoctor().getFirstName().equals(filter) ||
                    p.getDoctor().getLastName().equals(filter)).collect(Collectors.toList());

            this.refreshTable(filteredWizyta);
        }
    }

    private void loadHistoria() {
        List<Wizyta> wizyta = wizytaRepository.findByKartoteka(ActUser.getPatient().getKartoteka());
        List<Wizyta> wizytaBefore = wizyta.stream()
                .filter(wizyta1 -> wizyta1.getLocalDateTime()
                        .isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());

        this.refreshTable(wizytaBefore);
    }

    private void refreshTable(List<Wizyta> wizytaBefore){

        this.tableHistoria.getColumns().clear();

        final ObservableList<Wizyta> data = FXCollections.observableArrayList();
        data.addAll(wizytaBefore);

        columnData.setCellValueFactory(
                new PropertyValueFactory<>("localDateTime")
        );
        columnLekarz.setCellValueFactory(
                new PropertyValueFactory<>("doctor")
        );

        this.tableHistoria.setItems(data);

        this.tableHistoria.getColumns().addAll(columnData, columnLekarz);
    }

    @FXML
    public void wstecz(){
        stageManager.switchScene(FxmlView.PATIENT);
    }
}
