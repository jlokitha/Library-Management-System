package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.AdminSignInService;
import lk.ijse.library_management.service.custom.impl.AdminSignInServiceImpl;
import lk.ijse.library_management.util.OTPGenerator;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

import static lk.ijse.library_management.service.ServiceFactory.ServiceType.SIGNIN;

public class ForgotPasswordFormController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnReqOtp;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblUserName;

    private String subject = "Admin Password Reset Verification Code";

    private final AdminSignInService adminSignInService =
            (AdminSignInServiceImpl) ServiceFactory.getInstance().getService(SIGNIN);

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

        if (validate()) {
            int id = adminSignInService.getIdFormUsername(txtUsername.getText());

            if (id > 0) {
                AdminDto dto = adminSignInService.getAdminData(id);

                String otp = OTPGenerator.generateOTP();

                SignInVerifyOtpFormController.otp = otp;
                SignInVerifyOtpFormController.dto = dto;

                adminSignInService.sendEmail(dto.getEmail(), subject , "ForgotPasswordEmail.html", otp);

                try {
                    AdminNavigation.switchLoginPage("SignInVerifyOtpForm.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        String userName = txtUsername.getText();

        if (Regex.userName(userName)) {
            lblUserName.setText("Invalid Username");
        } else {
            btnRequesOtpOnAction(event);
        }
    }

    @FXML
    void txtUserNameOnMouseClicked(MouseEvent event) {
        lblUserName.setText("");
    }

    public boolean validate() {
        String userName = txtUsername.getText();

        if (Regex.userName(userName)) {
            lblUserName.setText("Invalid Username");
            return false;
        }

        return true;
    }

}
