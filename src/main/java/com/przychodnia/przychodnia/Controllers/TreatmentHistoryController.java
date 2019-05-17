package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Wizyta;
import com.przychodnia.przychodnia.Repository.WizytaRepository;
import com.przychodnia.przychodnia.config.ActUser;
import com.przychodnia.przychodnia.config.FxmlView;
import com.przychodnia.przychodnia.config.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadHistoria();
    }

    private void loadHistoria() {

        this.tableHistoria.getColumns().clear();

        List<Wizyta> wizyta = wizytaRepository.findByKartoteka(ActUser.getPatient().getKartoteka());
        List<Wizyta> wizytaBefore = wizyta.stream()
                .filter(wizyta1 -> wizyta1.getLocalDateTime()
                        .isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
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