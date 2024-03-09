package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class ForgotPasswordFormController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnReqOtp;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblUserName;

    @FXML
    void btnBackOnAction(ActionEvent event) {
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
    void btnReqOtpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnReqOtpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnRequesOtpOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchLoginPage("SignInVerifyOtpForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnMouseClicked(MouseEvent event) {

    }

}
