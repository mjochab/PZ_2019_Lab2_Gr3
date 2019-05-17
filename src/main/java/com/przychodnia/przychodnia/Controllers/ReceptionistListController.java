package com.przychodnia.przychodnia.Controllers;

import com.przychodnia.przychodnia.Entity.Receptionist;
import com.przychodnia.przychodnia.Repository.ReceptionistRepository;
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
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ReceptionistListController implements Initializable {

    @Lazy
    @Autowired
    StageManager stageManager;

    @FXML
    TableView<Receptionist> receptionistTableView;

    @FXML
    TableColumn<Receptionist,String> columnImie;

    @FXML
    TableColumn<Receptionist,String> columnNazwisko;

    @FXML
    TableColumn<Receptionist,String> columnPesel;

    @Autowired
    ReceptionistRepository receptionistRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.loadReceptionistTableView();
    }

    private void loadReceptionistTableView() {

        this.receptionistTableView.getColumns().clear();

        List<Receptionist> receptionists = receptionistRepository.findAll();
        final ObservableList<Receptionist> data = FXCollections.observableArrayList();
        data.addAll(receptionists);

        columnImie.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        columnNazwisko.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );
        columnPesel.setCellValueFactory(
                new PropertyValueFactory<>("pesel")
        );

        this.receptionistTableView.setItems(data);

        this.receptionistTableView.getColumns().addAll(columnImie, columnNazwisko, columnPesel);
    }

    @FXML
    public void addReceptionist(){
        stageManager.switchScene(FxmlView.DODAJ_RECEPSJONISTE);
    }

    @FXML
    public void wstecz(){
        stageManager.switchScene(FxmlView.RECEPTIONIST);
    }
}
