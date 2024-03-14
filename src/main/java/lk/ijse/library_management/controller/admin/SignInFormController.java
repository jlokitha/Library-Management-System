package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.AdminSignInService;
import lk.ijse.library_management.service.custom.impl.AdminSignInServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class SignInFormController {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogIn;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblPassword;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private Pane paneShutDown;

    public static Stage stage;

    private final AdminSignInService signInService =
            (AdminSignInServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.SIGNIN);

    @FXML
    void btnLogInOnAction(ActionEvent event) {

        if (validateSignIn()) {

            String username = txtUsername.getText();
            String password = txtPassword.getText();

            int id = signInService.getIdFromUsernamePassword(username, password);

            if (id > 0) {
                try {
                    AdminGlobalFormController.username = username;
                    AdminNavigation.switchNavigation("AdminGlobalForm.fxml", event);
                } catch (IOException e) {

                }
            } else {
                lblPassword.setText("Invalid username or password !");
            }
        }
    }

    @FXML
    void btnLogInOnMouseEnter(MouseEvent event) {

    }

    @FXML
    void btnLogInOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchLoginPage("SignUpForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSignUpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgShutDownOnMouseClicked(MouseEvent event) {
        AdminGlobalLoginFormController.stage.close();
        System.exit(0);
    }

    @FXML
    void imgShutDownOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgShutDownOnMouseExited(MouseEvent event) {

    }

    @FXML
    void linkForgotPasswordOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchLoginPage("FrogotPasswordForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        String password = txtPassword.getText();

        if ( Regex.password(password) ) {
            lblPassword.setText("Please enter a password");
        } else {
            btnLogInOnAction(event);
        }
    }

    @FXML
    void txtPasswordOnMouseClicked(MouseEvent event) {
        lblPassword.setText("");
        lblUserName.setText("");
    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        String userName = txtUsername.getText();

        if (Regex.userName(userName)) {
            lblUserName.setText("Invalid Username");
        } else {
            txtPassword.requestFocus();
        }
    }

    @FXML
    void txtUserNameOnMouseClicked(MouseEvent event) {
        lblPassword.setText("");
        lblUserName.setText("");
    }

    public boolean validateSignIn() {
        String userName = txtUsername.getText();

        if (Regex.userName(userName)) {
            lblUserName.setText("Invalid Username");
            return false;
        }

        String password = txtPassword.getText();

        if ( Regex.password(password) ) {
            lblPassword.setText("Please enter a password");
            return false;
        }

        return true;
    }

}
