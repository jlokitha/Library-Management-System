package lk.ijse.library_management.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberService;
import lk.ijse.library_management.service.custom.impl.MemberServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class MemberManageRowFormController {

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblEmail;

    @FXML
    private ImageView imgView;

    @FXML
    private ImageView imgDelete;

    private final MemberService memberService =
            (MemberServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Delete Member");
        alert.setContentText("Are you sure you want to delete this member?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK) {
            memberService.deleteMember(Integer.parseInt(lblId.getText()));
            MemberManageFormController.controller.getAllData();
        }
    }

    @FXML
    void imgDeleteOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgDeleteOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) {
        try {
            MemberViewFormController.id = Integer.parseInt(lblId.getText());
            AdminNavigation.popupPane("MemberViewForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void imgViewOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseExited(MouseEvent event) {

    }

    public void setData(MemberDto dto) {
        lblId.setText(String.valueOf(dto.getId()));
        lblName.setText(dto.getName());
        lblEmail.setText(dto.getEmail());
        lblMobile.setText(dto.getMobile());
    }
}
