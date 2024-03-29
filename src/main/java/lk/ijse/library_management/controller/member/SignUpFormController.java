package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberSignUpService;
import lk.ijse.library_management.service.custom.impl.MemberSignUpServiceImpl;
import lk.ijse.library_management.util.OTPGenerator;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;

public class SignUpFormController {

    @FXML
    public JFXButton btnSignIn;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUsername;

    @FXML
    private JFXTextField txtFullName;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblFullName;

    private final String subject = "Member Sign Up Verification Code";

    private final MemberSignUpService signUpService =
            (MemberSignUpServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERSIGNUP);

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        if (validate()) {
            String otp = OTPGenerator.generateOTP();

            MemberDto memberDto = new MemberDto();

            memberDto.setName(txtFullName.getText());
            memberDto.setMobile(txtMobile.getText());
            memberDto.setEmail(txtEmail.getText());
            memberDto.setUsername(txtUsername.getText());
            memberDto.setPassword(txtPassword.getText());

            SignUpVerifyOtpFormController.dto = memberDto;
            SignUpVerifyOtpFormController.otp = otp;

            signUpService.sendEmail(txtEmail.getText(), subject, "SignUpEmail.html", otp);

            try {
                MemberNavigation.switchLoginPage("SignUpVerifyOtpForm.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
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
    void btnSignUpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {
        String email = txtEmail.getText();

        if (Regex.email(email)) {
            lblEmail.setText("Please enter valid email");
        } else {
            txtUsername.requestFocus();
        }
    }

    @FXML
    void txtEmailOnMouseClicked(MouseEvent event) {
        lblEmail.setText("");
    }

    @FXML
    void txtFullNameOnAction(ActionEvent event) {
        String firstName = txtFullName.getText();

        if (Regex.fullName(firstName)) {
            lblFullName.setText("Should contain at least 3 letters");
        } else {
            txtMobile.requestFocus();
        }
    }

    @FXML
    void txtFullNameOnMouseClicked(MouseEvent event) {
        lblFullName.setText("");
    }

    @FXML
    void txtMobileOnAction(ActionEvent event) {
        String mobile = txtMobile.getText();

        if (Regex.mobile(mobile)) {
            lblMobile.setText("Please enter valid mobile number");
        } else {
            txtEmail.requestFocus();
        }
    }

    @FXML
    void txtMobileOnMouseClicked(MouseEvent event) {
        lblMobile.setText("");
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        String password = txtPassword.getText();

        if ( Regex.password(password) ) {
            lblPassword.setText("Password should contain at least 6 characters");
        } else {
            btnSignUpOnAction(event);
        }
    }

    @FXML
    void txtPasswordOnMouseClicked(MouseEvent event) {
        lblPassword.setText("");
    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        String userName = txtUsername.getText();

        if (Regex.userName(userName)) {
            lblUsername.setText("Please enter a username");
        } else {
            txtPassword.requestFocus();
        }
    }

    @FXML
    void txtUserNameOnMouseClicked(MouseEvent event) {
        lblUsername.setText("");
    }

    public boolean validate() {
        String firstName = txtFullName.getText();

        if (Regex.fullName(firstName)) {
            lblFullName.setText("Should contain at least 3 letters");
            return false;
        }

        String mobile = txtMobile.getText();

        if (Regex.mobile(mobile)) {
            lblMobile.setText("Please enter valid mobile number");
            return false;
        }

        String email = txtEmail.getText();

        if (Regex.email(email)) {
            lblEmail.setText("Please enter valid email");
            return false;
        }

        String userName = txtUsername.getText();

        if (Regex.userName(userName)) {
            lblUsername.setText("Please enter a username");
            return false;
        }

        String password = txtPassword.getText();

        if ( Regex.password(password) ) {
            lblPassword.setText("Password should contain at least 6 characters");
            return false;
        }

        return true;
    }

    @FXML
    public void btnSignInOnAction(ActionEvent actionEvent) {
        try {
            MemberNavigation.switchLoginPage("SignInForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btnSignInOnMouseEntered(MouseEvent mouseEvent) {

    }

    @FXML
    public void btnSignInOnMouseExited(MouseEvent mouseEvent) {

    }

    @FXML
    public void imgShutDownOnMouseClicked(MouseEvent mouseEvent) {
        MemberGlobalLoginFormController.stage.close();
        System.exit(0);
    }

    @FXML
    public void imgShutDownOnMouseEntered(MouseEvent mouseEvent) {

    }

    @FXML
    public void imgShutDownOnMouseExited(MouseEvent mouseEvent) {

    }
}
