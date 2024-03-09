package lk.ijse.library_management.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class BookManageRowFormController {

    @FXML
    private Label lblId;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblGenre;

    @FXML
    private Label lblAvailability;

    @FXML
    private ImageView imgView;

    @FXML
    private ImageView imgUpdate;

    @FXML
    private ImageView imgDelete;

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) {

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
            AdminNavigation.popupPane("BookUpdateForm.fxml");
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
            AdminNavigation.popupPane("BookViewForm.fxml");
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

}
