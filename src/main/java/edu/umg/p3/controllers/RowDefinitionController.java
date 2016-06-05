package edu.umg.p3.controllers;

import edu.umg.p3.dto.Field;
import edu.umg.p3.service.VehicleService;
import edu.umg.p3.structures.file.RowDefinition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

/**
 * Created by fvcg2 on 4/06/2016.
 */
public class RowDefinitionController {
    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSize;

    @FXML
    private TableView<Field> tableView;

    @FXML
    private TableColumn<Field, String> nameColumn;

    @FXML
    private TableColumn<Field, String> sizeColumn;

    @FXML
    private Button addField;

    @FXML
    private Button saveFieldDefinition;

    private ObservableList<Field> fieldList = FXCollections.observableArrayList();

    private void fillFieldList() {
        if (VehicleService.getInstance().getRowDefinition() != null) {
            List<Field> fields = VehicleService.getInstance().getRowDefinition().getStructure();
            fieldList.addAll(fields);
        }
    }

    @FXML
    private void initialize() {
        tableView.setItems(fieldList);

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        sizeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSize().toString()));

        fillFieldList();
    }

    private void cleanFields() {
        fieldName.setText("");
        fieldSize.setText("");
    }

    @FXML
    private void addFieldAction(ActionEvent actionEvent) {

        Field field = Field.newBuilder()
                .withKey(false)
                .withName(fieldName.getText())
                .withSize(Integer.parseInt(fieldSize.getText()))
                .build();

        fieldList.add(field);

        cleanFields();
    }

    @FXML
    private void saveFieldDefinitionAction(ActionEvent actionEvent) {
        RowDefinition rowDefinition = new RowDefinition();
        rowDefinition.setStructure(fieldList);

        VehicleService.getInstance().setRowDefinition(rowDefinition);
    }

}
