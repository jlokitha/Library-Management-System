package lk.ijse.library_management.controller.member;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.service.custom.impl.BranchServiceImpl;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;

public class BranchManageRowFormController {

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

    private final BranchService branchService =
            (BranchServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) {
        try {
            BranchViewFormController.id = Integer.parseInt(lblId.getText());
            MemberNavigation.popupPane("BranchViewForm.fxml");
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

    public void setData(BranchDto dto) {

        lblId.setText(String.valueOf(dto.getId()));
        lblName.setText(dto.getName());
        lblMobile.setText(dto.getMobile());
        lblEmail.setText(dto.getEmail());
    }
}

