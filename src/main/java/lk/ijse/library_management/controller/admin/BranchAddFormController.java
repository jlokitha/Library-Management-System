package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

public class BranchAddFormController {

    @FXML
    public JFXTextField txtBranchName;

    @FXML
    public Label lblName;

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
        if (validate()) {
            int id = branchService.getIdFromUsername(AdminGlobalFormController.username);

            boolean isSaved = branchService.saveBranch( new BranchDto(
                    -1,
                    txtBranchName.getText(),
                    txtBranchLocation.getText(),
                    txtBranchMobile.getText(),
                    txtBranchEmail.getText(),
                    null,
                    null,
                    branchService.getAdminData(id)
            ) );

            if (isSaved) {
                AdminNavigation.closePane();
                BranchManageFormController.controller.getAllData();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something went wrong !").show();
            }
        }
    }

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

    @FXML
    void txtAddressOnAction(ActionEvent event) {
        String location = txtBranchLocation.getText();

        if (Regex.address(location)) {
            lblAddress.setText("Should contain at least 3 letters");
        } else {
            btnAddOnAction(event);
        }
    }

    @FXML
    void txtAddressOnMouseClicked(MouseEvent event) {
        lblAddress.setText("");
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {
        String email = txtBranchEmail.getText();

        if (Regex.email(email)) {
            lblEmail.setText("Please enter valid email");
        } else {
            txtBranchLocation.requestFocus();
        }
    }

    @FXML
    void txtEmailOnMouseClicked(MouseEvent event) {
        lblEmail.setText("");
    }

    @FXML
    void txtMobileOnAction(ActionEvent event) {
        String mobile = txtBranchMobile.getText();

        if (Regex.mobile(mobile)) {
            lblMobile.setText("Please enter valid mobile number");
        } else {
            txtBranchEmail.requestFocus();
        }
    }

    @FXML
    void txtMobileOnMouseClicked(MouseEvent event) {
        lblMobile.setText("");
    }


    @FXML
    void btnAddOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {

    }

    @FXML
    public void txtNameOnAction(ActionEvent actionEvent) {
        String name = txtBranchName.getText();

        if (Regex.fullName(name)) {
            lblName.setText("Should contain at least 3 letters");
        } else {
            txtBranchMobile.requestFocus();
        }
    }

    @FXML
    public void txtNameOnMouseClicked(MouseEvent mouseEvent) {
        lblName.setText("");
    }

    public boolean validate() {
        String name = txtBranchName.getText();

        if (Regex.fullName(name)) {
            lblName.setText("Should contain at least 3 letters");
            return false;
        }

        String mobile = txtBranchMobile.getText();

        if (Regex.mobile(mobile)) {
            lblMobile.setText("Please enter valid mobile number");
            return false;
        }

        String email = txtBranchEmail.getText();

        if (Regex.email(email)) {
            lblEmail.setText("Please enter valid email");
            return false;
        }

        String location = txtBranchLocation.getText();

        if (Regex.address(location)) {
            lblAddress.setText("Should contain at least 3 letters");
            return false;
        }

        return true;
    }
}
