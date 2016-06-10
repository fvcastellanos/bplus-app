package edu.umg.p3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Created by fcastellanos on 6/9/16.
 */
public class TreeController extends BaseController {

    @FXML
    private TextArea textArea;

    @FXML
    private void display(ActionEvent actionEvent) {
        textArea.setText(vehicleService.getBTreeContent());
    }

    @FXML
    private void close(ActionEvent actionEvent) {
        closeWindow(actionEvent);
    }

}
