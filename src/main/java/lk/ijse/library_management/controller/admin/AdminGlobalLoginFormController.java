package lk.ijse.library_management.controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminGlobalLoginFormController implements Initializable {

    @FXML
    public AnchorPane loginPane;

    public static AdminGlobalLoginFormController controller;

    public AdminGlobalLoginFormController() {
        controller = this;
    }

    public static AdminGlobalLoginFormController getInstance() {
        return controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AdminNavigation.switchLoginPage("SignInForm.fxml");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
