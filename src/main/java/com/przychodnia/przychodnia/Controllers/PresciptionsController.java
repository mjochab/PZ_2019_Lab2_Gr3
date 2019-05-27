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
public class PresciptionsController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    Label labelInfo;

    @FXML
    TableView<Presciption> tableRecepty;

    @FXML
    TableColumn<Presciption, LocalDateTime> columnData;

    @FXML
    TableColumn<Presciption,String> columnPacjent;

    @FXML
    TextField szukajTextField;

    @Autowired
    PresciptionsRepository presciptionsRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadRecepty();
    }

    @FXML
    public void szukaj(){
        String filter = this.szukajTextField.getText();
        List<Presciption> presciptions = presciptionsRepository.findByDoctor(ActUser.getDoctor());

        if(filter.equals("")){
            this.refreshTable(presciptions);
        }
        else {
            List<Presciption> filteredPresciption = presciptions.stream().filter(p -> p.getKartoteka().getPatient().getFirstName().equals(filter) ||
                    p.getKartoteka().getPatient().getLastName().equals(filter)).collect(Collectors.toList());

            this.refreshTable(filteredPresciption);
        }
    }

    private void loadRecepty() {
        List<Presciption> patients = presciptionsRepository.findByDoctor(ActUser.getDoctor());
        this.refreshTable(patients);
    }

    private void refreshTable( List<Presciption> patients){
        this.tableRecepty.getColumns().clear();

        final ObservableList<Presciption> data = FXCollections.observableArrayList();
        data.addAll(patients);

        columnData.setCellValueFactory(
                new PropertyValueFactory<>("localDateTime")
        );
        columnPacjent.setCellValueFactory(
                new PropertyValueFactory<>("kartoteka")
        );


        this.tableRecepty.setItems(data);

        this.tableRecepty.getColumns().addAll(columnData, columnPacjent);
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


    @FXML
    public void wstecz(){
        stageManager.switchScene(FxmlView.DOCTOR);
    }

    @FXML
    public void addPrescription(){
        stageManager.switchScene(FxmlView.DODAJ_RECEPTE);
    }
}
