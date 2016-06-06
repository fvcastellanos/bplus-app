package edu.umg.p3.controllers;

import edu.umg.p3.service.VehicleService;
import javafx.event.ActionEvent;
import javafx.scene.control.Control;
import javafx.stage.Stage;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class BaseController {

    protected VehicleService vehicleService = VehicleService.getInstance();

    protected void closeWindow(ActionEvent actionEvent) {
        Control control = (Control) actionEvent.getSource();
        Stage stage = (Stage) control.getScene().getWindow();
        stage.close();
    }
}
