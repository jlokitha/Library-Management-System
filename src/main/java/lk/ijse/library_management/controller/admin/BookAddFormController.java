package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.util.navigation.AdminNavigation;

public class BookAddFormController {

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtGenre;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblGenre;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {

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
    void txtAuthorOnAction(ActionEvent event) {

    }

    @FXML
    void txtAuthorOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtGenreOnAction(ActionEvent event) {

    }

    @FXML
    void txtGenreOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtTiltleOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtTitleOnAction(ActionEvent event) {

    }

}
