package lk.ijse.library_management.controller.admin;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BookService;
import lk.ijse.library_management.service.custom.impl.BookServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.util.Objects;

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

    private final BookService bookService =
            (BookServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Delete Book");
        alert.setContentText("Are you sure you want to delete this Book?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK) {
            boolean isDeleted = bookService.deleteBook(Integer.parseInt(lblId.getText()));
            BookManageFormController.controller.getAllData();
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
            BookUpdateFormController.id = Integer.parseInt(lblId.getText());
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
            BookViewFormController.id = Integer.parseInt(lblId.getText());
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

    public void setStatus(String status) {
        lblAvailability.setAlignment(Pos.CENTER);

        if ( Objects.equals(status, "Available") ) {
            lblAvailability.setStyle(
                    "-fx-background-color: #C7FFDE;" +
                            "-fx-background-radius: 20px;" +
                            "-fx-text-fill: #139547");
        } else {
            lblAvailability.setStyle(
                    "-fx-background-color: #FFD3D3;" +
                            "-fx-background-radius: 20px;" +
                            "-fx-text-fill: #FF0E0E");
        }
    }

    public void setData(BookDto dto) {
        lblId.setText(String.valueOf(dto.getId()));
        lblGenre.setText(dto.getGenre());
        lblTitle.setText(dto.getTitle());
        lblAvailability.setText(dto.getAvailability());
        setStatus(dto.getAvailability());
    }
}
