package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberSignInService;
import lk.ijse.library_management.service.custom.impl.MemberSignInServiceImpl;
import lk.ijse.library_management.util.OTPGenerator;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.MemberNavigation;

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

    private String subject = "Member Password Reset Verification Code";

    private final MemberSignInService memberSignInService =
            (MemberSignInServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERSIGNIN);

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            MemberNavigation.switchLoginPage("SignInForm.fxml");
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
            int id = memberSignInService.getIdFormUsername(txtUsername.getText());

            if (id > 0) {
                MemberDto dto = memberSignInService.getMemberData(id);

                String otp = OTPGenerator.generateOTP();

                SignInVerifyOtpFormController.dto = dto;
                SignInVerifyOtpFormController.otp = otp;

                memberSignInService.sendEmail(dto.getEmail(), subject , "ForgotPasswordEmail.html", otp);

                try {
                    MemberNavigation.switchLoginPage("SignInVerifyOtpForm.fxml");
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
