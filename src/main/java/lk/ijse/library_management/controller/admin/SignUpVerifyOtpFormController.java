package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class SignUpVerifyOtpFormController {

    @FXML
    private JFXTextField txtOtp;

    @FXML
    private JFXButton btnVerify;

    @FXML
    private JFXButton btnBack;

    @FXML
    private Label lblOtp;

    @FXML
    void btnBackOMouseEntered(MouseEvent event) {
        try {
            AdminNavigation.switchLoginPage("SignUpForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBackOMouseExited(MouseEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnVerifyOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchNavigation("AdminGlobalForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnVerifyOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnVerifyOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtOtpOnAction(ActionEvent event) {

    }

    @FXML
    void txtOtpOnMouseClicked(MouseEvent event) {

    }

}
