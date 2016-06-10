package edu.umg.p3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Map;

/**
 * Created by fvcg2 on 7/06/2016.
 */
public class SearchController extends BaseController {

    @FXML
    private TextArea textArea;

    @FXML
    private TextField searchKey;

    private boolean validate() {
        if(searchKey.getText().equals("")) {
            return false;
        }

        return true;
    }

    private void fillSearch(Map<String, String> map) {

        StringBuilder sb = new StringBuilder();
        sb.append("Search: {\n");

        if (map != null) {
            for(String key : map.keySet()) {
                sb.append("  " + key + ": " + map.get(key) + "\n");
            }
        } else {
            sb.append("  No data found\n");
        }

        sb.append("}\n");

        textArea.setText(sb.toString());
    }

    @FXML
    private void search(ActionEvent actionEvent) {
        if(validate()) {
            Map<String, String> map = vehicleService.searchVehicle(searchKey.getText());
            fillSearch(map);
        }
    }

    @FXML
    private void close(ActionEvent actionEvent) {
        closeWindow(actionEvent);
    }
}
