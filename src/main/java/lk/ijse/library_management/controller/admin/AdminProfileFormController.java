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
import lk.ijse.library_management.service.custom.AdminProfileService;
import lk.ijse.library_management.service.custom.impl.AdminProfileServiceImpl;
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

    private final AdminProfileService profileService =
            (AdminProfileServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ADMINPROFILE);

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
        AdminNavigation.closePane();
    }

    @FXML
    void imgCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgCloseOnMouseExited(MouseEvent event) {

    }

    private void setData() {
        int id = profileService.getIdFromUsername(AdminGlobalFormController.username);
        AdminDto dto = profileService.getAdminData(id);

        lblAdminId.setText(String.valueOf(dto.getId()));
        lblName.setText(dto.getFName() + " " + dto.getLName());
        lblUserName.setText(dto.getUsername());
        lblMobile.setText(dto.getMobile());
        lblEmail.setText(dto.getEmail());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
