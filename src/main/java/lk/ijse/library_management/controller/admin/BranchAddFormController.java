package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.util.Navigation;

public class BranchAddFormController {

    @FXML
    private JFXTextField txtBranchMobile;

    @FXML
    private JFXTextField txtBranchEmail;

    @FXML
    private JFXTextField txtBranchLocation;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblAddress;

    private final BranchService branchService =
            (BranchService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (true) {
            boolean isSaved = branchService.saveBranch( new BranchDto(
                    -1,
                    txtBranchLocation.getText(),
                    txtBranchMobile.getText(),
                    txtBranchEmail.getText()
            ) );

            if (isSaved) {
//                Navigation.closePane();
//                BranchManageFormController.controller.getAllId();
            }
        }
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtAddressOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmailOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtMobileOnAction(ActionEvent event) {

    }

    @FXML
    void txtMobileOnMouseClicked(MouseEvent event) {

    }


    @FXML
    void btnAddOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {

    }
}
