package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class ResetPasswordFormController {

    @FXML
    private JFXTextField txtNewPassword;

    @FXML
    private JFXPasswordField txtComfirmNewPassword;

    @FXML
    private JFXButton btnConfirm;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblNewPass;

    @FXML
    private Label lblConPass;

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
    void btnConfirmOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnConfirmOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnResetPasswordOnAction(ActionEvent event) {



        try {
            AdminNavigation.switchNavigation("AdminGlobalForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void txtConfirmOnAction(ActionEvent event) {

    }

    @FXML
    void txtConfirmOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtNewOnAction(ActionEvent event) {

    }

    @FXML
    void txtNewOnMouseClicked(MouseEvent event) {

    }

    public boolean validatePassword() {
        String password = txtNewPassword.getText();

        if (Regex.password(password)) {
            lblNewPass.setText("Password should have at least 6 and less than 20 characters");
            return false;
        }

        return true;
    }

}
