package lk.ijse.library_management.controller.admin;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.library_management.util.Style;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminGlobalFormController implements Initializable {

    @FXML
    public Label lblTime;

    @FXML
    public Label lblDate;

    @FXML
    public ImageView imgBorrow;

    @FXML
    public Label lblMember;

    @FXML
    public ImageView imgBranch;

    @FXML
    public Label lblBranch;

    @FXML
    public ImageView imgBook;

    @FXML
    public Label lblBook;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private ImageView imgDashboard;

    @FXML
    private Label lblDashboard;

    @FXML
    private JFXButton btnIssued;

    @FXML
    private Label lblBorrow;

    @FXML
    private JFXButton btnMember;

    @FXML
    private ImageView imgMember;

    @FXML
    private JFXButton btnBranch;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private ImageView imgLogOut;

    @FXML
    private Label lblLogout;

    @FXML
    private JFXButton btnBook;

    @FXML
    private Label labelUser;

    @FXML
    private ImageView imgProfile;

    @FXML
    private JFXButton btnProfile;

    @FXML
    public AnchorPane pagingPane;

    @FXML
    public ImageView imgGreyBack;

    @FXML
    public AnchorPane popUpPane;

    public Stage popupStage;

    public static String username;

    private boolean dashboard;
    private boolean borrow;
    private boolean book;
    private boolean member;
    private boolean branch;

    private static AdminGlobalFormController globalFormController;

    public AdminGlobalFormController() {
        globalFormController = this;
    }

    public static AdminGlobalFormController getInstance() {
        return globalFormController;
    }

    @FXML
    void btnBookOnAction(ActionEvent event) {
        unSelected();

        try {
            Style.btnSelected(btnBook,imgBook,"book_color.png", lblBook);
            AdminNavigation.switchPaging("BookManageForm.fxml");
            book = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBranchOnAction(ActionEvent event) {
        unSelected();

        try {
            Style.btnSelected(btnBranch,imgBranch,"branch_color.png", lblBranch);
            AdminNavigation.switchPaging("BranchManageForm.fxml");
            branch = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        unSelected();

        try {
            Style.btnSelected(btnDashboard,imgDashboard,"dashboard_color.png", lblDashboard);
            AdminNavigation.switchPaging("DashboardForm.fxml");
            dashboard = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnIssuedOnAction(ActionEvent event) {
        unSelected();

        try {
            Style.btnSelected(btnIssued,imgBorrow,"borrow_color.png", lblBorrow);
            AdminNavigation.switchPaging("BookBorrowManageForm.fxml");
            borrow = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

        try {
            AdminNavigation.switchNavigation("AdminGlobalLoginForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {
        unSelected();

        try {
            Style.btnSelected(btnMember,imgMember,"member_color.png", lblMember);
            AdminNavigation.switchPaging("MemberManageForm.fxml");
            member = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBranchOnMouseEntered(MouseEvent event) {
        if ( !branch ) {
            Style.btnHover(btnBranch, imgBranch, "branch.png", lblBranch);
        }
    }

    @FXML
    void btnBranchOnMouseExited(MouseEvent event) {
        if ( !branch ) {
            Style.btnUnselected(btnBranch, imgBranch, "branch.png", lblBranch);
        }
    }

    @FXML
    void btnDashboardOnMouseEntered(MouseEvent event) {
        if ( !dashboard ) {
            Style.btnHover(btnDashboard, imgDashboard, "dashboard.png", lblDashboard);
        }
    }

    @FXML
    void btnDashboardOnMouseExited(MouseEvent event) {
        if ( !dashboard ) {
            Style.btnUnselected(btnDashboard, imgDashboard, "dashboard.png", lblDashboard);
        }
    }

    @FXML
    void btnIssuedOnMouseEntered(MouseEvent event) {
        if ( !borrow ) {
            Style.btnHover(btnIssued, imgBorrow, "borrow.png", lblBorrow);
        }
    }

    @FXML
    void btnIssuedOnMouseExited(MouseEvent event) {
        if ( !borrow ) {
            Style.btnUnselected(btnIssued, imgBorrow, "borrow.png", lblBorrow);
        }
    }

    @FXML
    void btnItemOnMouseEntered(MouseEvent event) {
        if ( !book ) {
            Style.btnHover(btnBook, imgBook, "book.png", lblBook);
        }
    }

    @FXML
    void btnItemOnMouseExited(MouseEvent event) {
        if ( !book ) {
            Style.btnUnselected(btnBook, imgBook, "book.png", lblBook);
        }
    }

    @FXML
    void btnLogOutOnMouseEntered(MouseEvent event) {
        Style.btnSelectedLogOut(btnLogOut, lblLogout, imgLogOut);
    }

    @FXML
    void btnLogOutOnMouseExited(MouseEvent event) {
        Style.btnUnselected(btnLogOut, imgLogOut, "logout.png", lblLogout);
    }

    @FXML
    void btnMemberOnMouseEntered(MouseEvent event) {
        if ( !member ) {
            Style.btnHover(btnMember, imgMember, "member.png", lblMember);
        }
    }

    @FXML
    void btnMemberOnMouseExited(MouseEvent event) {
        if ( !member ) {
            Style.btnUnselected(btnMember, imgMember, "member.png", lblMember);
        }
    }

    @FXML
    void btnProfileOnMouseEntered(MouseEvent event) {
        Tooltip tooltip = new Tooltip("Profile");
        tooltip.setShowDelay(Duration.millis(150));
        btnProfile.setTooltip(tooltip);

        Style.btnSelectedProfile(imgProfile);
    }

    @FXML
    void btnProfileOnMouseExited(MouseEvent event) {
        Style.btnUnselectedProfile(imgProfile);
    }

    @FXML
    void btnProfileOnAction(ActionEvent event) {
        try {
            AdminNavigation.popupPane("AdminProfileForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
    }

    private void updateClock() {
        lblTime.setText(timeNow());
    }

    private void setTimeLine() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateClock()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static String timeNow() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss"); //In 24hr Format
        return dateFormat.format(new Date()) ;
    }

    public void unSelected() {
        Style.btnUnselected(btnDashboard, imgDashboard, "dashboard.png", lblDashboard);
        Style.btnUnselected(btnIssued, imgBorrow, "borrow.png", lblBorrow);
        Style.btnUnselected(btnBook, imgBook, "book.png", lblBook);
        Style.btnUnselected(btnMember, imgMember, "member.png", lblMember);
        Style.btnUnselected(btnBranch, imgBranch, "branch.png", lblBranch);
        Style.btnUnselected(btnLogOut, imgLogOut, "logout.png", lblLogout);

        dashboard = false;
        borrow = false;
        member = false;
        branch = false;
        book = false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDate.setText(String.valueOf(LocalDate.now()));
        labelUser.setText(username);
        btnDashboardOnAction(new ActionEvent());
        setTimeLine();
    }
}
