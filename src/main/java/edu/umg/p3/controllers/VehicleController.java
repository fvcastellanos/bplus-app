package edu.umg.p3.controllers;

import edu.umg.p3.dto.Field;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class VehicleController extends BaseController {

    private ObservableList<Field> fields = FXCollections.observableArrayList();

    @FXML
    private TableView<String> vehiclesTable;

    private TableColumn<Field, String> fieldColumn;

    private TableColumn<Field, String> valueColumn;

    private TableColumn<String, String> buildTableColumn(Field field) {
        TableColumn<String, String> column = new TableColumn<>();
        column.setEditable(true);
        column.setSortable(false);
        column.setText(field.getName());

        return column;
    }

    private void addColumnsToTable() {
        List<Field> fields = vehicleService.getRowDefinition().getStructure();
        int i = 0;
        for(Field field : fields) {
            vehiclesTable.getColumns().add(i, buildTableColumn(field));
            i++;
        }

    }

    private void loadFields() {
/*
        fieldColumn.setCellValueFactory(cellValue -> new SimpleStringProperty(cellValue.getValue().getName()));
        valueColumn.setEditable(true);

        List<Field> fieldList = vehicleService.getRowDefinition().getStructure();
        fields.addAll(fieldList);
*/

        addColumnsToTable();
    }

    @FXML
    private void initialize() {
        loadFields();
    }

}
