package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.AdminSignUpService;
import lk.ijse.library_management.service.custom.impl.AdminSignUpServiceImpl;
import lk.ijse.library_management.util.Regex;
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

    public static AdminDto dto;

    public static String otp;

    private final AdminSignUpService signUpService =
            (AdminSignUpServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.SIGNUP);

    @FXML
    void btnBackOMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBackOMouseExited(MouseEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            dto = null;
            otp = null;
            AdminNavigation.switchLoginPage("SignUpForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnVerifyOnAction(ActionEvent event) {

        if (validate()) {
            if (txtOtp.getText().equals(otp)) {

                try {
                    boolean isSaved = signUpService.saveAdmin(dto);

                    if (isSaved) {
                        try {
                            AdminGlobalFormController.username = dto.getUsername();
                            AdminNavigation.switchNavigation("AdminGlobalForm.fxml", event);
                            dto = null;
                            otp = null;
                        } catch (IOException e) {
                            new Alert( Alert.AlertType.ERROR, e.getMessage() ).show();
                        }
                    }
                } catch (Exception e) {
                    new Alert( Alert.AlertType.ERROR, e.getMessage() ).show();
                }
            } else {
                lblOtp.setText("Please enter valid OTP !");
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

        if (Regex.otp(userName)) {
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
