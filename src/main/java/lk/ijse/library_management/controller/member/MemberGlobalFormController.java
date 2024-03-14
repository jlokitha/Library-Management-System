package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.library_management.controller.admin.AdminGlobalFormController;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class MemberGlobalFormController implements Initializable {

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
    private ImageView imgProfile;

    @FXML
    private JFXButton btnProfile;

    @FXML
    public AnchorPane pagingPane;

    @FXML
    public ImageView imgGreyBack;

    @FXML
    public AnchorPane popUpPane;

    public static String username;

    public Stage popupStage;

    private static MemberGlobalFormController globalFormController;

    public MemberGlobalFormController() {
        globalFormController = this;
    }

    public static MemberGlobalFormController getInstance() {
        return globalFormController;
    }

    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
    }

    @FXML
    void btnBookOnAction(ActionEvent event) {
        try {
            MemberNavigation.switchPaging("BookManageForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBranchOnAction(ActionEvent event) {
        try {
            MemberNavigation.switchPaging("BranchManageForm.fxml");
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
            MemberNavigation.switchPaging("DashboardForm.fxml");
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
            MemberNavigation.switchPaging("BookBorrowManageForm.fxml");
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
            MemberNavigation.switchNavigation("SignInForm.fxml", event);
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
    void btnProfileOnAction(ActionEvent event) {
        try {
            MemberNavigation.popupPane("MemberProfileForm.fxml");
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
        System.out.println(imgGreyBack.isVisible());
        btnDashboardOnAction(new ActionEvent());
        setTimeLine();
    }
}
