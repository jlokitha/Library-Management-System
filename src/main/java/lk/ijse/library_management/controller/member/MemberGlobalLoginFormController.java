package lk.ijse.library_management.controller.member;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberGlobalLoginFormController implements Initializable {

    public static Stage stage;

    @FXML
    public AnchorPane loginPane;

    public static MemberGlobalLoginFormController controller;

    public MemberGlobalLoginFormController() {
        controller = this;
    }

    public static MemberGlobalLoginFormController getInstance() {
        return controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            MemberNavigation.switchLoginPage("SignInForm.fxml");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
