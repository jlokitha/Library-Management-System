package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class SignUpFormController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUsername;

    @FXML
    private JFXTextField txtFullName;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblFullName;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchLoginPage("SignInForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchLoginPage("SignUpVerifyOtpForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSignUpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmailOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtFullNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtFullNameOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtMobileOnAction(ActionEvent event) {

    }

    @FXML
    void txtMobileOnMouseClicked(MouseEvent event) {

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
