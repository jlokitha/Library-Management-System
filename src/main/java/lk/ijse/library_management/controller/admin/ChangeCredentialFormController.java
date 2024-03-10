package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.ProfileService;
import lk.ijse.library_management.service.custom.impl.ProfileServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

public class ChangeCredentialFormController {

    @FXML
    private JFXTextField txtCurrentPass;

    @FXML
    private JFXTextField txtNEWPass;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXPasswordField txtConNewPass;

    @FXML
    private Label lblCurentPass;

    @FXML
    private Label lblNewPass;

    @FXML
    private Label lblConPass;

    private final ProfileService profileService =
            (ProfileServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.PROFILE);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        AdminNavigation.closePane();
    }

    @FXML
    void btnCancelOnMoseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMoseExited(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        if (validatePassword()) {
            int id = profileService.getIdFromUsername(AdminGlobalFormController.username);

            if (txtNEWPass.getText().equals(txtConNewPass.getText())) {
                boolean isUpdated = profileService.updateAdminPassword(id, txtCurrentPass.getText(), txtNEWPass.getText());

                if (isUpdated) {
                    AdminNavigation.closePane();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Provided Password Incorrect !").show();
                }
            }
        }
    }

    @FXML
    void btnUpdateOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtConPassOnAction(ActionEvent event) {

    }

    @FXML
    void txtConPassOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtCurentPassOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtCurrentPassOnAction(ActionEvent event) {

    }

    @FXML
    void txtNewPassOnAction(ActionEvent event) {

    }

    @FXML
    void txtNewPassOnMouseClicked(MouseEvent event) {

    }

    public boolean validatePassword() {
        String curPassword = txtCurrentPass.getText();

        if (Regex.password(curPassword)) {
            lblCurentPass.setText("Please enter your current password");
            return false;
        }

        String newPassword = txtNEWPass.getText();

        if ( Regex.password(newPassword) ) {
            lblNewPass.setText("Password should contain at least 6 characters");
            return false;
        }

        String password = txtConNewPass.getText();

        if ( Regex.password(password) ) {
            lblConPass.setText("Password should contain at least 6 characters");
            return false;
        }

        return true;
    }

}
