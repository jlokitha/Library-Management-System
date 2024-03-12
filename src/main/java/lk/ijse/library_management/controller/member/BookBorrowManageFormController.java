package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;

public class BookBorrowManageFormController {

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private VBox vBox;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAdd;

    @FXML
    void btnAddBorrowOnAction(ActionEvent event) {
        try {
            MemberNavigation.popupPane("BookBorrowAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnAddOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {

    }

    @FXML
    public void txtSearchOnAction(ActionEvent actionEvent) {

    }

    @FXML
    public void txtSearchOnMouseClicked(MouseEvent mouseEvent) {

    }
}
