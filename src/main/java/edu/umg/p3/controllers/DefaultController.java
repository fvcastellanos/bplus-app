package edu.umg.p3.controllers;

import edu.umg.p3.service.VehicleService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static edu.umg.p3.dialogs.DialogsUtils.showWarning;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class DefaultController extends BaseController {

    private static String [] ROW_DEFINITION = { "/fxml/row-definition.fxml", "Vehicle system - Row Definition" };
    private static String [] ADD_ROWS = { "/fxml/vehicles.fxml", "Vehicle system - Add vehicle" };
    private static String [] SEARCH = { "/fxml/search.fxml", "Vehicle system - Search vehicle" };

    private VehicleService getVehicleService() {
        return VehicleService.getInstance();
    }

    private void loadScene(String [] fxml) {
        try {
            String fxmlFile = fxml[0];
            FXMLLoader loader = new FXMLLoader();
            Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode, 600, 300);
            scene.getStylesheets().add("/styles/styles.css");

            Stage stage = new Stage();
            stage.setTitle(fxml[1]);
            stage.setScene(scene);
            stage.show();

        } catch(Exception ex) {

        }
    }

    private boolean hasRowDefinition() {
        if (getVehicleService().getRowDefinition() == null) {
            return false;
        }

        return true;
    }

    @FXML
    private void rowDefinitionAction(ActionEvent actionEvent) {
        loadScene(ROW_DEFINITION);
    }

    @FXML
    private void addRowsAction(ActionEvent actionEvent) {
        if (hasRowDefinition()) {
            loadScene(ADD_ROWS);
        } else {
            showWarning("Vehicle system", "You have to define a record structure first");
        }
    }

    @FXML
    private void searchVehicle(ActionEvent actionEvent) {
        loadScene(SEARCH);
    }

    @FXML
    private void closeApplication(ActionEvent actionEvent) {
        this.closeWindow(actionEvent);
    }
}
