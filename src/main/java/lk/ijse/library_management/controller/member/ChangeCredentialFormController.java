package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.controller.admin.AdminGlobalFormController;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberProfileService;
import lk.ijse.library_management.service.custom.impl.MemberProfileServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;
import lk.ijse.library_management.util.navigation.MemberNavigation;

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

    private final MemberProfileService profileService =
            (MemberProfileServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERPROFILE);

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (validatePassword()) {
            int id = profileService.getIdFromUsername(MemberGlobalFormController.username);

            if (txtNEWPass.getText().equals(txtConNewPass.getText())) {

                MemberDto memberData = profileService.getMemberData(id);

                boolean isUpdated = profileService.updateMemberPassword(id, txtCurrentPass.getText(), txtNEWPass.getText());

                if (isUpdated) {
                    MemberNavigation.closePane();
                    profileService.sendPasswordChangeEmail(memberData.getEmail());
                } else {
                    new Alert(Alert.AlertType.ERROR, "Provided Password Incorrect !").show();
                }
            }
        }
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        MemberNavigation.closePane();
    }

    @FXML
    void btnCancelOnMoseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMoseExited(MouseEvent event) {

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
