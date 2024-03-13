package lk.ijse.library_management.controller.member;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BookDto;

public class BookBorrowAddRowFormController {

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblGenre;

    @FXML
    private ImageView imgDelete;

    private BookDto dto;

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) {
        BookBorrowAddFormController.controller.removeBook(dto);
        BookBorrowAddFormController.controller.getBooks();
    }

    @FXML
    void imgDeleteOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgDeleteOnMouseExited(MouseEvent event) {

    }

    public void setData(BookDto dto) {
        lblBookId.setText(String.valueOf(dto.getId()));
        lblAuthor.setText(dto.getAuthor());
        lblTitle.setText(dto.getTitle());
        lblGenre.setText(dto.getGenre());

        this.dto = dto;
    }
}
