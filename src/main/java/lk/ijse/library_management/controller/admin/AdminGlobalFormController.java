package lk.ijse.library_management.controller.admin;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    private JFXButton btnDashboard;

    @FXML
    private ImageView imgDashboard;

    @FXML
    private Label lblDashboard;

    @FXML
    private JFXButton btnIssued;

    @FXML
    private ImageView imgOrder;

    @FXML
    private Label lblOrder;

    @FXML
    private JFXButton btnMember;

    @FXML
    private ImageView imgCustomer;

    @FXML
    private Label lblCustomer;

    @FXML
    private JFXButton btnBranch;

    @FXML
    private ImageView imgSupplier;

    @FXML
    private Label lblSupplier;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private ImageView imgLogOut;

    @FXML
    private Label lblLogout;

    @FXML
    private JFXButton btnBook;

    @FXML
    private ImageView imgItem;

    @FXML
    private Label lblItem;

    @FXML
    private Label labelUser;

    @FXML
    private JFXTextField txtSearch;

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

    private static AdminGlobalFormController globalFormController;

    public AdminGlobalFormController() {
        globalFormController = this;
    }

    public static AdminGlobalFormController getInstance() {
        return globalFormController;
    }

    @FXML
    void btnBookOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchPaging("BookManageForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBranchOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchPaging("BranchManageForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBranchOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBranchOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchPaging("DashboardForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDashboardOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnDashboardOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnIssuedOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchPaging("BookBorrowManageForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnIssuedOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnIssuedOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnItemOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnItemOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchNavigation("SignInForm.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLogOutOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnLogOutOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {
        try {
            AdminNavigation.switchPaging("MemberManageForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnMemberOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnMemberOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnProfileOnAction(ActionEvent event) {
        try {
            AdminNavigation.popupPane("AdminProfileForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnProfileOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnProfileOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnMouseClicked(MouseEvent event) {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDate.setText(String.valueOf(LocalDate.now()));
        labelUser.setText(username);
        btnDashboardOnAction(new ActionEvent());
        setTimeLine();
    }
}
