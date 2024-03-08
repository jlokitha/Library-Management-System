package lk.ijse.library_management.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.StageStyle;
import lk.ijse.library_management.controller.admin.AdminGlobalFormController;
import lk.ijse.library_management.controller.admin.AdminGlobalLoginFormController;
import lk.ijse.library_management.controller.admin.SignInFormController;


import java.io.IOException;

public class Navigation {

    private static Parent parent;
    private static Stage stage;
    private static Scene scene;

    public static void switchNavigation(String path, ActionEvent event) throws IOException {
        parent = FXMLLoader.load(Navigation.class.getResource("/view/" + path));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignInFormController.stage = stage;
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void switchPaging(String path) throws IOException {
        AdminGlobalFormController.getInstance().pagingPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root = loader.load();
        AdminGlobalFormController.getInstance().pagingPane.getChildren().add(root);
    }

    public static void popupPane(String path) throws IOException {

        AdminGlobalFormController.getInstance().popUpPane.setVisible(true);
        AdminGlobalFormController.getInstance().imgGreyBack.setVisible(true);

        AnchorPane root = FXMLLoader.load(Navigation.class.getResource("/view/" + path));

        Stage popupStage = new Stage();
        AdminGlobalFormController.getInstance().setPopupStage(popupStage);
        popupStage.setScene(new Scene(root));
        popupStage.centerOnScreen();
        popupStage.initOwner(AdminGlobalFormController.getInstance().popUpPane.getScene().getWindow());
        popupStage.initStyle(StageStyle.UNDECORATED);
        popupStage.show();
    }

    public static void switchLoginPage(String path) throws IOException {
        AdminGlobalLoginFormController.getInstance().loginPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root = loader.load();
        AdminGlobalLoginFormController.getInstance().loginPane.getChildren().add(root);
    }

    public static void closePane(){
        AdminGlobalFormController.getInstance().popUpPane.getChildren().clear();
        AdminGlobalFormController.getInstance().popupStage.close();
        AdminGlobalFormController.getInstance().popUpPane.setVisible(false);
        AdminGlobalFormController.getInstance().imgGreyBack.setVisible(false);
    }

}