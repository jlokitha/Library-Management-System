package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.util.navigation.AdminNavigation;

public class BranchViewFormController {

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

}
