package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.TransactionService;
import lk.ijse.library_management.service.custom.impl.TransactionServiceImpl;
import lk.ijse.library_management.util.navigation.MemberNavigation;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class BookBorrowAddFormController implements Initializable {

    @FXML
    public JFXTextField txtDueDate;

    @FXML
    public TextField txtBookTitle;

    @FXML
    public Label lblTitle;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private JFXButton btnAddBook;

    @FXML
    private VBox vBox;

    @FXML
    private JFXButton btnBorrow;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label labelTotal;

    @FXML
    private JFXTextField txtIssedDate;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtMemberId;

    private AutoCompletionBinding<String> AutoTitle;

    public static BookBorrowAddFormController controller;

    private List<BookDto> books = new ArrayList<>();

    private final TransactionService transactionService =
            (TransactionServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.TRANSACTION);
    private MemberDto member;

    private List<String> titles;

    private Set<String> titleSet;

    public BookBorrowAddFormController() {
        controller = this;
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

        if (true) {
            BookDto dto = transactionService.getBookDataFromTitle(txtBookTitle.getText());

            if (dto != null) {
                if (!isContain(dto)) {
                    books.add(dto);

                    getBooks();

                    txtBookTitle.clear();
                    txtAuthor.clear();
                } else {
                    lblTitle.setText("This Book Already Added !");
                }
            } else {
                lblTitle.setText("This Book Does Not Available !");
            }
        }
    }

    @FXML
    void btnAddBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddBookOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

        if (!books.isEmpty()) {

            TransactionDto dto = new TransactionDto();

            dto.setQty(books.size());
            dto.setStatus("Due");
            dto.setDueDate(Date.valueOf(txtDueDate.getText()));

            boolean isSaved = transactionService.saveTransaction(dto, member, books);

            if (isSaved) {
                MemberNavigation.closePane();
            }
        }
    }

    @FXML
    void btnBorrowOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBorrowOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        MemberNavigation.closePane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    public void txtBookTitleOnAction(ActionEvent actionEvent) {
        String author = transactionService.getBookAuthorFromTitle(txtBookTitle.getText());

        txtAuthor.setText(author);
    }

    @FXML
    public void txtBookTitleOnMouseClicked(MouseEvent mouseEvent) {
        lblTitle.setText("");
    }

    public void getBooks() {
        vBox.getChildren().clear();

        for (BookDto dto : books) {
            loadBookRow(dto);
        }
    }

    public void loadBookRow(BookDto dto) {
        try {
            FXMLLoader loader = new FXMLLoader(BookBorrowAddFormController.class.getResource("/view/member/BookBorrowAddRowForm.fxml"));
            Parent root = loader.load();
            BookBorrowAddRowFormController controller = loader.getController();
            controller.setData(dto);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadAllBookTitles() {
        titles = transactionService.getAllBookTitles();

        titleSet = new HashSet<>(titles);

        AutoTitle = TextFields.bindAutoCompletion(txtBookTitle,titleSet);
    }

    public void loadMember() {
        MemberDto dto = transactionService.getMemberFromUsername(MemberGlobalFormController.username);
        member = dto;

        txtMemberId.setText(String.valueOf(dto.getId()));
        txtMemberName.setText(dto.getName());
        txtIssedDate.setText(String.valueOf(LocalDate.now()));
        txtDueDate.setText(String.valueOf(LocalDate.now().plusDays(7)));
    }

    public void removeBook(BookDto dto) {
        books.remove(dto);
    }

    public boolean isContain(BookDto dto) {
        boolean flag = false;

        for (BookDto bookDto : books) {
            if (bookDto.getId() == dto.getId()) {
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        loadAllBookTitles();
        loadMember();
    }
}
