package lk.ijse.library_management.util;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Style {
    public static void btnOnMouseExited( JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #1351CB;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-text-fill:  #FFFFFF;"
        );
    }

    public static void btnOnMouseEntered(JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #1351CB;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-text-fill:  #FFFFFF;"
        );
    }

    public static void btnOnMouseEnteredWithBorder ( JFXButton btn ) {
        btn.setStyle(
                "-fx-background-color: #A5C3FF;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: #1351CB;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill:  #1351CB;"
        );
    }

    public static void btnOnMouseEnteredWithBorder2 ( JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #EEEEEE;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: #727374;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill:  #727374;");
    }

    public static void btnOnMouseExitedWithBorder ( JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: #727374;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill:  #727374;"
        );
    }

    public static void btnOnMouseExitedWithBorder2(JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: #1351CB;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill:  #1351CB;"
        );
    }

    public static void btnOnMouseEntered( JFXButton btn, Label lbl, ImageView img ) {
        btn.setStyle(
                "-fx-background-color: #A5C3FF;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-border-color: #1351CB;" +
                        "-fx-border-radius: 20px;"
        );
        lbl.setStyle( "-fx-text-fill:  #1351CB;");
        img.setImage(new Image ("/assests/icon/add_green.png"));
    }

    public static void btnOnMouseExited(JFXButton btn, Label lbl, ImageView img) {
        btn.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-border-color: #727374;" +
                        "-fx-border-radius: 20px;"
        );
        lbl.setStyle( "-fx-text-fill:  #727374;" );
        img.setImage(new Image("/assests/icon/add.png") );
    }

    public static void btnAddAttendanceMouseEntered(JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #1351CB;" +
                        "-fx-background-radius: 10px;"
        );
    }

    public static void btnAddAttendanceMouseExited(JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #1351CB;" +
                        "-fx-background-radius: 10px;"
        );
    }

    public static void btnDeleteOnMouseEntered(JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #ff6a6a;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-text-fill:  #FFFFFF;"
        );
    }

    public static void btnDeleteOnMouseExited(JFXButton btn) {
        btn.setStyle(
                "-fx-background-color:  #f44930;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-text-fill:  #FFFFFF;"
        );
    }

    public static void btnDeleteOnMouseEntered( JFXButton btn, Label lbl, ImageView img) {
        btn.setStyle(
                "-fx-background-color: #FFE0E0;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-border-color: #FD3535;" +
                        "-fx-border-radius: 20px;");
        lbl.setStyle(
                "-fx-text-fill:  #FD3535;");
        img.setImage(new Image("/assests/icon/delete_red.png"));
    }

    public static void btnDeleteOnMouseEnteredWithBorder( JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #FFC4C4;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: #f44949;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill: #f44949;"
        );
    }

    public static void btnDeleteOnMouseExitedWithBorder(JFXButton btn) {
        btn.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: #f44949;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill: #f44949;"
        );
    }

    public static void btnUnselectedProfile(ImageView imgProfile) {
        imgProfile.setImage(new Image("/assests/icon/profile.png"));
    }

    public static void btnSelectedProfile(ImageView imgProfile) {
        imgProfile.setImage(new Image("/assests/icon/profile_color.png"));
    }

    public static void btnUnselected(JFXButton button, ImageView imageView, String path, Label label) {
        button.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 20px;");
        label.setStyle(
                "-fx-text-fill:  #727374;");
        imageView.setImage(new Image("/assests/icon/" + path));
    }

    public static void btnSelectedLogOut(JFXButton btnLogOut, Label lblLogout, ImageView imgLogOut) {
        btnLogOut.setStyle(
                "-fx-background-color: #FFC4C4;" +
                        "-fx-background-radius: 20px;");
        lblLogout.setStyle(
                "-fx-text-fill: #FD3535;");
        imgLogOut.setImage(new Image("/assests/icon/logout_color.png"));
    }

    public static void btnHover(JFXButton button, ImageView imageView, String path, Label label) {
        button.setStyle(
                "-fx-background-color: #EEEEEE;" +
                        "-fx-background-radius: 20px;");
        label.setStyle(
                "-fx-text-fill:  #727374;");
        imageView.setImage(new Image("/assests/icon/" + path));
    }

    public static void btnSelected(JFXButton button, ImageView imageView, String path, Label label) {
        button.setStyle(
                "-fx-background-color: #A5C3FF;" +
                        "-fx-background-radius: 20px;");
        label.setStyle(
                "-fx-text-fill:  #1351CB;");
        imageView.setImage(new Image("/assests/icon/" + path));
    }
}
