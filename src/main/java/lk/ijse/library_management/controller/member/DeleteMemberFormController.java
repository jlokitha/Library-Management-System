package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.controller.admin.AdminGlobalFormController;
import lk.ijse.library_management.controller.admin.SignInFormController;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberProfileService;
import lk.ijse.library_management.service.custom.impl.MemberProfileServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteMemberFormController implements Initializable {

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

    private final MemberProfileService profileService =
            (MemberProfileServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERPROFILE);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (validatePassword()) {
            int id = profileService.getIdFromUsernamePassword(lblUserName.getText(), txtPassword.getText());

            if (id > 0) {

                MemberDto memberData = profileService.getMemberData(id);

                try {
                    profileService.deleteMember(id);
                    SignInFormController.stage.close();
                    AdminNavigation.switchNavigation("SignInForm.fxml", event);
                    profileService.sendAccountDeletionEmail(memberData.getEmail());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        MemberNavigation.closePane();
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
        lblUserName.setText(MemberGlobalFormController.username);
    }
}
