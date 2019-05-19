package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.CreatePdf.CreatePdf;
import com.przychodnia.przychodnia.Entity.Presciption;
import com.przychodnia.przychodnia.Repository.PresciptionsRepository;
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
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class PresciptionsPatientPanelController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    TableView<Presciption> tableRecepty;

    @FXML
    TableColumn<Presciption, LocalDateTime> columnData;

    @FXML
    TableColumn<Presciption,String> columnLekarz;

    @FXML
    Label labelInfo;


    @Autowired
    PresciptionsRepository presciptionsRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadPresciptionToTable();
    }

    @FXML
    public void drukuj(){
        int i = tableRecepty.getSelectionModel().getFocusedIndex();
        Presciption presciptionToPrint = tableRecepty.getItems().get(i);
        String info = CreatePdf.createPdf(presciptionToPrint);

        if(info == "blad"){
            this.labelInfo.setText("nie udało się utworzyć recepty");
        }
        else{
            this.labelInfo.setText("Recepta zapisana w lokalizacji: "+info);
        }
    }

    private void loadPresciptionToTable() {

        this.tableRecepty.getColumns().clear();

        List<Presciption> patients = presciptionsRepository.findByKartoteka(ActUser.getPatient().getKartoteka());
        final ObservableList<Presciption> data = FXCollections.observableArrayList();
        data.addAll(patients);

        columnData.setCellValueFactory(
                new PropertyValueFactory<>("localDateTime")
        );
        columnLekarz.setCellValueFactory(
                new PropertyValueFactory<>("doctor")
        );

        this.tableRecepty.setItems(data);

        this.tableRecepty.getColumns().addAll(columnData, columnLekarz);
    }

    @FXML
    public void wstecz(){
        stageManager.switchScene(FxmlView.PATIENT);
    }
}
