package edu.umg.p3.controllers;

import edu.umg.p3.dialogs.DialogsUtils;
import edu.umg.p3.dto.Field;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class VehicleController extends BaseController {

    private List<TextField> textFieldList;
    @FXML
    private GridPane fieldGrid;

    private Label buildLabel(Field field) {
        return new Label(StringUtils.capitalize(field.getName() + ": "));
    }

    private TextField buildTextField(Field field) {
        TextField textField = new TextField();
        textField.setId(field.getName());
        textField.setMinWidth(50);
        textField.setPrefWidth(field.getSize() * 10);
        textField.setMaxWidth(400);

        return textField;
    }

    private void loadFields() {
        int i = 0;
        textFieldList = new ArrayList<>();
        for(Field field : vehicleService.getRowDefinition().getStructure()) {
            fieldGrid.add(buildLabel(field), 0, i);
            TextField textField = buildTextField(field);
            fieldGrid.add(textField, 1, i);
            textFieldList.add(textField);
            i++;
        }
    }

    private String validate() {
        String result = "OK";
        for(TextField textField : textFieldList) {
            if(StringUtils.isEmpty(textField.getText())) {
                result = "Please enter a value for field: " + textField.getId();
            }

            Field field = vehicleService.getRowDefinition().findField(textField.getId());
            if((field.isKey()) && (!StringUtils.isNumeric(textField.getText()))) {
                result = "Key field allows only numeric values: " + textField.getId();
            }
        }

        return result;
    }

    @FXML
    private void initialize() {
        loadFields();
    }

    @FXML
    private void addAction(ActionEvent actionEvent) {
        String result = validate();
        if (result.equals("OK")) {

        } else {
            DialogsUtils.showWarning("Unable to add a vehicle", result);

        }
    }

    @FXML
    private void closeAction(ActionEvent actionEvent) {
        closeWindow(actionEvent);
    }

}
