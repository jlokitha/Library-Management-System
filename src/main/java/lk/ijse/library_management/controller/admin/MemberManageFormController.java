package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberService;
import lk.ijse.library_management.service.custom.impl.MemberServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberManageFormController implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAdd;

    public static MemberManageFormController controller;

    public MemberManageFormController() {
        controller = this;
    }

    private final MemberService memberService =
            (MemberServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {

    }

    public void getAllData() {

        List<MemberDto> data = memberService.getAllMemberData();

        vBox.getChildren().clear();

        for(MemberDto dto : data) {
            loadDataTable(dto);
        }
    }

    private void loadDataTable(MemberDto dto) {
        try {
            FXMLLoader loader = new FXMLLoader(BookManageFormController.class.getResource("/view/admin/MemberManageRowForm.fxml"));
            Parent root = loader.load();
            MemberManageRowFormController controller = loader.getController();
            controller.setData(dto);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllData();
    }
}
