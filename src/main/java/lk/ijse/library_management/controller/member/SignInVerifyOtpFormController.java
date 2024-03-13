package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;

public class SignInVerifyOtpFormController {

    public static MemberDto dto;

    public static String otp;

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
            MemberNavigation.switchLoginPage("FrogotPasswordForm.fxml");
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
        if (txtOtp.getText().equals(otp)) {
            try {
                ResetPasswordFormController.dto = dto;
                MemberNavigation.switchLoginPage("ResetPasswordForm.fxml");
                dto = null;
                otp= null;
            } catch (IOException e) {
                e.printStackTrace();
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

    }

    @FXML
    void txtOtpOnMouseClicked(MouseEvent event) {

    }

}
