package edu.umg.p3.controllers;

import edu.umg.p3.dialogs.DialogsUtils;
import edu.umg.p3.dto.Field;
import edu.umg.p3.structures.file.RowDefinition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

/**
 * Created by fvcg2 on 4/06/2016.
 */
public class RowDefinitionController extends BaseController {

    private RowDefinition rowDefinition;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSize;

    @FXML
    private CheckBox isKey;

    @FXML
    private TableView<Field> tableView;

    @FXML
    private TableColumn<Field, String> nameColumn;

    @FXML
    private TableColumn<Field, String> sizeColumn;

    @FXML
    private TableColumn<Field, String> isKeyColumn;

    @FXML
    private Button addField;

    @FXML
    private Button saveFieldDefinition;

    private ObservableList<Field> fieldList = FXCollections.observableArrayList();

    private void fillFieldList() {
        rowDefinition = new RowDefinition();
        if (vehicleService.getRowDefinition() != null) {
            rowDefinition = vehicleService.getRowDefinition();
            List<Field> fields = rowDefinition.getStructure();
            fieldList.addAll(fields);
        }
    }

    @FXML
    private void initialize() {
        tableView.setItems(fieldList);

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        sizeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSize().toString()));
        isKeyColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().isKey()?"Y":"N"));

        fillFieldList();
    }

    private void cleanFields() {
        fieldName.setText("");
        fieldSize.setText("");
        isKey.setSelected(false);
        fieldName.requestFocus();
    }

    @FXML
    private void addFieldAction(ActionEvent actionEvent) {
        try {
            Field field = Field.newBuilder()
                    .withKey(isKey.isSelected())
                    .withName(fieldName.getText())
                    .withSize(Integer.parseInt(fieldSize.getText()))
                    .build();

            rowDefinition.addField(field);
            fieldList.add(field);

            cleanFields();

        } catch (Exception ex) {
            DialogsUtils.showWarning("Row Definition error", ex.getMessage());
        }
    }

    @FXML
    private void saveFieldDefinitionAction(ActionEvent actionEvent) {
        vehicleService.createFileDefinition("vehicles.txt", rowDefinition);
//        vehicleService.setRowDefinition(rowDefinition);

        closeWindow(actionEvent);
    }

}
