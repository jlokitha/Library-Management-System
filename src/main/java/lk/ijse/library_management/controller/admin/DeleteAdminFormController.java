package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.ProfileService;
import lk.ijse.library_management.service.custom.impl.ProfileServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteAdminFormController implements Initializable {

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblOtp;

    private final ProfileService profileService =
            (ProfileServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.PROFILE);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        if (validatePassword()) {
            int id = profileService.getIdFromUsernamePassword(lblUserName.getText(), txtPassword.getText());

            if (id > 0) {

                try {
                    profileService.deleteAdmin(id);
                    SignInFormController.stage.close();
                    AdminNavigation.switchNavigation("SignInForm.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        AdminNavigation.closePane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnDeleteOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnDeleteOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtPasswordOnMouseClicked(MouseEvent event) {

    }

    public boolean validatePassword() {
        String password = txtPassword.getText();

        if (Regex.password(password)) {
            lblOtp.setText("Password should contain at least 6 characters");
            return false;
        }

        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblUserName.setText(AdminGlobalFormController.username);
    }
}
