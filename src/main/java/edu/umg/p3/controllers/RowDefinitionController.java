package edu.umg.p3.controllers;

import edu.umg.p3.dto.Field;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Created by fvcg2 on 4/06/2016.
 */
public class RowDefinitionController {
    @FXML
    private TextField fieldName;

    @FXML
    private Spinner<Integer> fieldSize;

    @FXML
    private TableView<Field> tableView;

    @FXML
    private Button addField;

    private ObservableList<Field> fieldList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        fieldSize = new Spinner<>(1, 500, 10);
    }

    @FXML
    private void addFieldAction(ActionEvent actionEvent) {

        Field field = Field.newBuilder()
                .withKey(false)
                .withName(fieldName.getText())
                .withSize(fieldSize.getValue())
                .build();

        fieldList.add(field);
    }

}
