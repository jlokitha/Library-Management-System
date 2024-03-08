package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminGlobalFormController {

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

    public static String user;

    private static AdminGlobalFormController globalFormController;

    @FXML
    void btnBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnBranchOnAction(ActionEvent event) {

    }

    @FXML
    void btnBranchOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBranchOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnDashboardOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnIssuedOnAction(ActionEvent event) {

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

    }

    @FXML
    void btnLogOutOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnLogOutOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnMemberOnAction(ActionEvent event) {

    }

    @FXML
    void btnMemberOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnMemberOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnProfileOnAction(ActionEvent event) {

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

    public static AdminGlobalFormController getInstance() {
        return globalFormController ;
    }

    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
    }

}
