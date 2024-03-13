package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberSignUpService;
import lk.ijse.library_management.service.custom.impl.MemberSignUpServiceImpl;
import lk.ijse.library_management.util.navigation.MemberNavigation;

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

    public static MemberDto dto;

    public static String otp;

    private final MemberSignUpService memberSignUpService =
            (MemberSignUpServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERSIGNUP);

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
            MemberNavigation.switchLoginPage("SignUpForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnVerifyOnAction(ActionEvent event) {

        if (txtOtp.getText().equals(otp)) {
            boolean isSaved = memberSignUpService.saveMember(dto);

            if (isSaved) {
                try {
                    MemberGlobalFormController.username = dto.getUsername();
                    MemberNavigation.switchNavigation("MemberGlobalForm.fxml", event);
                    dto = null;
                    otp = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            lblOtp.setText("Please enter valid OTP !");
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
