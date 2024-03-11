package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberProfileService;
import lk.ijse.library_management.service.custom.impl.MemberProfileServiceImpl;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberProfileFormController implements Initializable {

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
    private Label lblMemberId;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblMobile;

    private final MemberProfileService memberProfileService =
            (MemberProfileServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBERPROFILE);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            MemberNavigation.closePane();
            MemberNavigation.popupPane("DeleteMemberForm.fxml");
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
            MemberNavigation.closePane();
            MemberNavigation.popupPane("ChangeCredentialForm.fxml");
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
        MemberNavigation.closePane();
    }

    @FXML
    void imgCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgCloseOnMouseExited(MouseEvent event) {

    }

    private void setData() {
        int id = memberProfileService.getIdFromUsername(MemberGlobalFormController.username);
        MemberDto dto = memberProfileService.getMemberData(id);

        lblMemberId.setText(String.valueOf(dto.getId()));
        lblName.setText(dto.getName());
        lblUserName.setText(dto.getUsername());
        lblMobile.setText(dto.getMobile());
        lblEmail.setText(dto.getEmail());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
