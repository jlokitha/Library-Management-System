package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.AdminSignUpService;
import lk.ijse.library_management.service.custom.impl.AdminSignUpServiceImpl;
import lk.ijse.library_management.util.OTPGenerator;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class SignUpFormController {

    @FXML
    public JFXTextField txtLastName;

    @FXML
    public Label lblLastName;

    @FXML
    public JFXTextField txtFirstName;

    @FXML
    public Label lblFirstName;

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
    private JFXTextField txtMobile;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblMobile;

    private final String subject = "Admin Sign Up Verification Code";

    private final AdminSignUpService signUpService =
            (AdminSignUpServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.SIGNUP);

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

        if (validate()) {
            String otp = OTPGenerator.generateOTP();

            AdminDto adminDto = new AdminDto();

            adminDto.setFName(txtFirstName.getText());
            adminDto.setLName(txtLastName.getText());
            adminDto.setMobile(txtMobile.getText());
            adminDto.setEmail(txtEmail.getText());
            adminDto.setUsername(txtUsername.getText());
            adminDto.setPassword(txtPassword.getText());

            SignUpVerifyOtpFormController.dto = adminDto;
            SignUpVerifyOtpFormController.otp = otp;

            signUpService.sendEmail(txtEmail.getText(), subject, "SignUpEmail.html", otp);

            try {
                AdminNavigation.switchLoginPage("SignUpVerifyOtpForm.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
        lblUsername.setText("");
    }

    @FXML
    void txtFirstNameOnAction(ActionEvent event) {
        String firstName = txtFirstName.getText();

        if (Regex.name(firstName)) {
            lblFirstName.setText("Should contain at least 3 letters");
        } else {
            txtLastName.requestFocus();
        }
    }

    @FXML
    void txtFirstNameOnMouseClicked(MouseEvent event) {
        lblFirstName.setText("");
    }

    @FXML
    void txtLastNameOnAction(ActionEvent event) {
        String lastName = txtLastName.getText();

        if (Regex.name(lastName)) {
            lblLastName.setText("Should contain at least 3 letters");
        } else {
            txtMobile.requestFocus();
        }
    }

    @FXML
    void txtLastNameOnMouseClicked(MouseEvent event) {
        lblLastName.setText("");
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
        String firstName = txtFirstName.getText();

        if (Regex.name(firstName)) {
            lblFirstName.setText("Should contain at least 3 letters");
            return false;
        }

        String lastName = txtLastName.getText();

        if (Regex.name(lastName)) {
            lblLastName.setText("Should contain at least 3 letters");
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

    public void btnSignInOnAction(ActionEvent actionEvent) {
        try {
            AdminNavigation.switchLoginPage("SignInForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnSignInOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnSignInOnMouseExited(MouseEvent mouseEvent) {

    }

    public void imgShutDownOnMouseClicked(MouseEvent mouseEvent) {
        AdminGlobalLoginFormController.stage.close();
        System.exit(0);
    }

    public void imgShutDownOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void imgShutDownOnMouseExited(MouseEvent mouseEvent) {

    }
}
