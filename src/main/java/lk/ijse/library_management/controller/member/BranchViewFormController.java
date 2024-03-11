package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.service.custom.impl.BranchServiceImpl;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.net.URL;
import java.util.ResourceBundle;

public class BranchViewFormController implements Initializable {

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblBranchId;

    @FXML
    private Label lblBranchName;

    @FXML
    private Label lblBranchMobile;

    @FXML
    private Label lblBranchEmail;

    @FXML
    private Label lblBranchAddress;

    public static int id;

    private final BranchService branchService =
            (BranchServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BRANCH);

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

    public void setData() {
        BranchDto dto = branchService.getBranchData(id);

        lblBranchId.setText(String.valueOf(dto.getId()));
        lblBranchName.setText(dto.getName());
        lblBranchAddress.setText(dto.getLocation());
        lblBranchMobile.setText(dto.getMobile());
        lblBranchEmail.setText(dto.getEmail());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
