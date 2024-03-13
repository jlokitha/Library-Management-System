package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberService;
import lk.ijse.library_management.service.custom.impl.MemberServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberViewFormController implements Initializable {

    @FXML
    public Label lblMemberUsername;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblMemberName;

    @FXML
    private Label lblMemberMobile;

    @FXML
    private Label lblMemberEmail;

    public static int id;

    private final MemberService memberService =
            (MemberServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);

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

    public void setData() {
        try {
            MemberDto dto = memberService.getMemberData(id);

            lblMemberId.setText(String.valueOf(dto.getId()));
            lblMemberUsername.setText(dto.getUsername());
            lblMemberName.setText(dto.getName());
            lblMemberMobile.setText(dto.getMobile());
            lblMemberEmail.setText(dto.getEmail());
        } catch (NumberFormatException e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
