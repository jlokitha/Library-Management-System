package lk.ijse.library_management.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.ijse.library_management.dto.BookDto;

public class BookBorrowViewRowFormController {

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblGenre;

    public void setData(BookDto dto) {
        lblBookId.setText(String.valueOf(dto.getId()));
        lblTitle.setText(dto.getTitle());
        lblAuthor.setText(dto.getAuthor());
        lblGenre.setText(dto.getGenre());
    }
}
