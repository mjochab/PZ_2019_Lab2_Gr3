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

@Controller
public class VisitsController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    TableView<Wizyta> tableWizyty;

    @FXML
    TableColumn<Wizyta, LocalDateTime> columnData;

    @FXML
    TableColumn<Wizyta,String> columnPacjent;

    @Autowired
    WizytaRepository wizytyRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadWizyty();
    }

    private void loadWizyty() {

        this.tableWizyty.getColumns().clear();

        List<Wizyta> patients = wizytyRepository.findByDoctor(ActUser.getDoctor());
        final ObservableList<Wizyta> data = FXCollections.observableArrayList();
        data.addAll(patients);

        columnData.setCellValueFactory(
                new PropertyValueFactory<>("localDateTime")
        );
        columnPacjent.setCellValueFactory(
                new PropertyValueFactory<>("kartoteka")
        );


        this.tableWizyty.setItems(data);

        this.tableWizyty.getColumns().addAll(columnData, columnPacjent);
    }

    @FXML
    public void wstecz(){
        stageManager.switchScene(FxmlView.DOCTOR);
    }
}
