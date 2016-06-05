package edu.umg.p3.dialogs;

import javafx.scene.control.Alert;

/**
 * Created by fvcg2 on 5/06/2016.
 */
public class DialogsUtils {

    private static void showDialog(Alert.AlertType type, String header, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void showWarning(String title, String message) {
        showDialog(Alert.AlertType.WARNING, "Warning", title, message);
    }
}
