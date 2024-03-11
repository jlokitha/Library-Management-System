package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.service.custom.impl.BranchServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.net.URL;
import java.util.ResourceBundle;

public class BranchUpdateFormController implements Initializable {

    @FXML
    private JFXTextField txtBranchName;

    @FXML
    private JFXTextField txtBranchMobile;

    @FXML
    private JFXTextField txtBranchEmail;

    @FXML
    private JFXTextField txtBranchLocation;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label lblName;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblAddress;

    public static int id;

    private BranchDto dto;

    private final BranchService branchService =
            (BranchServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (validate()) {

            dto.setName(txtBranchName.getText());
            dto.setLocation(txtBranchLocation.getText());
            dto.setMobile(txtBranchMobile.getText());
            dto.setEmail(txtBranchEmail.getText());

            boolean isUpdated = branchService.updateBranch(dto);

            if (isUpdated) {
                AdminNavigation.closePane();
                BranchManageFormController.controller.getAllData();
            } else {
                new Alert(Alert.AlertType.ERROR, "Branch does not updated !").show();
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
    void btnUpdateOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnMouseExited(MouseEvent event) {

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
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnMouseClicked(MouseEvent event) {

    }

    public boolean validate() {
        String name = txtBranchName.getText();

        if (Regex.fullName(name)) {
            lblName.setText("Should contain at least 3 letters");
            return false;
        }

        String location = txtBranchLocation.getText();

        if (Regex.address(location)) {
            lblAddress.setText("Should contain at least 3 letters");
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

        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BranchDto dto = branchService.getBranchData(id);

        txtBranchName.setText(dto.getName());
        txtBranchLocation.setText(dto.getLocation());
        txtBranchMobile.setText(dto.getMobile());
        txtBranchEmail.setText(dto.getEmail());
        this.dto = dto;
    }
}
