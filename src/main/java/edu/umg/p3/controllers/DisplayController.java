package edu.umg.p3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Created by fvcg2 on 8/06/2016.
 */
public class DisplayController extends BaseController {

    @FXML
    private TextArea textArea;

    @FXML
    private void close(ActionEvent actionEvent) {
        closeWindow(actionEvent);
    }

    @FXML
    private void display(ActionEvent actionEvent) {
        String value = vehicleService.getFileContent();
        textArea.setText(value);
    }
}
