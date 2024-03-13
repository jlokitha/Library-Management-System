package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberSignUpService;
import lk.ijse.library_management.service.custom.impl.MemberSignUpServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;

public class ResetPasswordFormController {

    public static MemberDto dto;

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

    private final MemberSignUpService memberSignUpService =
            (MemberSignUpServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERSIGNUP);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        try {
            dto = null;
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
    void btnConfirmOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnConfirmOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnResetPasswordOnAction(ActionEvent event) {
        if (validatePassword()) {
            if (txtNewPassword.getText().equals(txtComfirmNewPassword.getText())) {
                dto.setPassword(txtNewPassword.getText());

                boolean isUpdated = memberSignUpService.updateMember(dto);

                if (isUpdated) {
                    try {
                        MemberGlobalFormController.username = dto.getUsername();
                        MemberNavigation.switchNavigation("MemberGlobalForm.fxml", event);
                        dto = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Password Reset failed !").show();
                }
            }
        }
    }

    @FXML
    void txtConfirmOnAction(ActionEvent event) {
        String password = txtComfirmNewPassword.getText();

        if (Regex.password(password)) {
            lblConPass.setText("Password should have at least 6 and less than 20 characters");
        } else {
            btnResetPasswordOnAction(event);
        }
    }

    @FXML
    void txtConfirmOnMouseClicked(MouseEvent event) {
        lblConPass.setText("");
    }

    @FXML
    void txtNewOnAction(ActionEvent event) {
        String password = txtNewPassword.getText();

        if (Regex.password(password)) {
            lblNewPass.setText("Password should have at least 6 and less than 20 characters");
        } else {
            txtComfirmNewPassword.requestFocus();
        }
    }

    @FXML
    void txtNewOnMouseClicked(MouseEvent event) {
        lblNewPass.setText("");
    }

    public boolean validatePassword() {
        String password = txtNewPassword.getText();

        if (Regex.password(password)) {
            lblNewPass.setText("Password should have at least 6 and less than 20 characters");
            return false;
        }

        String password2 = txtComfirmNewPassword.getText();

        if (Regex.password(password2)) {
            lblConPass.setText("Password should have at least 6 and less than 20 characters");
            return false;
        }

        return true;
    }

}
