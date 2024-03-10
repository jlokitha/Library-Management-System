package lk.ijse.library_management.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.service.custom.impl.BranchServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.sql.SQLException;

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

    @FXML
    private ImageView imgUpdate;

    @FXML
    private ImageView imgDelete;

    private final BranchService branchService =
            (BranchServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Delete Branch");
        alert.setContentText("Are you sure you want to delete this branch?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK) {
            branchService.deleteBranch(Integer.parseInt(lblId.getText()));
            BranchManageFormController.controller.getAllData();
        }
    }

    @FXML
    void imgDeleteOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgDeleteOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgUpdateOnMouseClicked(MouseEvent event) {
        try {
            BranchUpdateFormController.id = Integer.parseInt(lblId.getText());
            AdminNavigation.popupPane("BranchUpdateForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void imgUpdateOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgUpdateOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) {
        try {
            BranchViewFormController.id = Integer.parseInt(lblId.getText());
            AdminNavigation.popupPane("BranchViewForm.fxml");
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
