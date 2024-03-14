package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class SignInVerifyOtpFormController {

    public static String otp;

    public static AdminDto dto;

    @FXML
    private JFXTextField txtOtp;

    @FXML
    private JFXButton btnVerify;

    @FXML
    private JFXButton btnBack;

    @FXML
    private Label lblOtp;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            dto = null;
            otp= null;
            AdminNavigation.switchLoginPage("FrogotPasswordForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBackOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBackOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnVerifyOnAction(ActionEvent event) {

        if (validate()) {
            if (txtOtp.getText().equals(otp)) {
                try {
                    ResetPasswordFormController.dto = dto;
                    AdminNavigation.switchLoginPage("ResetPasswordForm.fxml");
                    dto = null;
                    otp= null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        String userName = txtOtp.getText();

        if (Regex.userName(userName)) {
            lblOtp.setText("Invalid OTP");
        } else {
            btnVerifyOnAction(event);
        }
    }

    @FXML
    void txtOtpOnMouseClicked(MouseEvent event) {
        lblOtp.setText("");
    }

    public boolean validate() {
        String otp = txtOtp.getText();

        if (Regex.otp(otp)) {
            lblOtp.setText("Invalid OTP");
            return false;
        }

        return true;
    }

}
