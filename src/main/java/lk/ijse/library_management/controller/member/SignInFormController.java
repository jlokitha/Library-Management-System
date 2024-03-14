package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.library_management.controller.admin.AdminGlobalFormController;
import lk.ijse.library_management.controller.admin.AdminGlobalLoginFormController;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberSignInService;
import lk.ijse.library_management.service.custom.impl.MemberSignInServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;
import lk.ijse.library_management.util.navigation.MemberNavigation;

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

    private final MemberSignInService signInService =
            (MemberSignInServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERSIGNIN);

    @FXML
    void btnLogInOnAction(ActionEvent event) {

        if (validateSignIn()) {
            String username = txtUsername.getText();
            String password = txtPassword.getText();

            int id = signInService.getIdFromUsernamePassword(username, password);

            if (id > 0) {
                try {
                    MemberGlobalFormController.username = username;
                    MemberNavigation.switchNavigation("MemberGlobalForm.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
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
            MemberNavigation.switchLoginPage("SignUpForm.fxml");
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
        MemberGlobalLoginFormController.stage.close();
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
            MemberNavigation.switchLoginPage("FrogotPasswordForm.fxml");
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
        lblUserName.setText("");
        lblPassword.setText("");
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
        lblUserName.setText("");
        lblPassword.setText("");
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
