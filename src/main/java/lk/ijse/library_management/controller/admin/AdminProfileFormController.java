package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.ProfileService;
import lk.ijse.library_management.service.custom.impl.ProfileServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminProfileFormController implements Initializable {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReset;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblName;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblAdminId;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblMobile;

    private final ProfileService profileService =
            (ProfileServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.PROFILE);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            AdminNavigation.closePane();
            AdminNavigation.popupPane("DeleteAdminForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnDeleteOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        try {
            AdminNavigation.closePane();
            AdminNavigation.popupPane("ChangeCredentialForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnResetOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnResetOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgCloseOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void imgCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgCloseOnMouseExited(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AdminDto dto = profileService.getAdminData();

        lblAdminId.setText(String.valueOf(dto.getId()));
        lblName.setText(dto.getFName() + " " + dto.getLName());
        lblUserName.setText(dto.getUsername());
        lblMobile.setText(dto.getMobile());
        lblEmail.setText(dto.getEmail());
    }
}
