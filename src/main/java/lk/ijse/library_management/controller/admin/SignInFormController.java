package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class SignInFormController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogIn;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblPassword;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private Pane paneShutDown;

    public static Stage stage;

    @FXML
    void btnLogInOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchNavigation("AdminGlobalForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLogInOnMouseEnter(MouseEvent event) {

    }

    @FXML
    void btnLogInOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

    }

    @FXML
    void btnSignUpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgShutDownOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void imgShutDownOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgShutDownOnMouseExited(MouseEvent event) {

    }

    @FXML
    void linkForgotPasswordOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchLoginPage("FrogotPasswordForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtPasswordOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnMouseClicked(MouseEvent event) {

    }

}
