package sample.View;

import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.Controller.AbstractController;
import sample.Controller.Controller;
import sample.Controller.EmailDetailsController;
import sample.Controller.ModelAccess;

import java.io.IOException;

public class ViewFactory {
    //designed to return different scenes depending on the layout (e.g. Main or EmailDetails)
    private final String DEFAULT_CSS_STYLESHEET = "main_style.css";
    private final String EMAIL_DETAIL_FXML="email_detail_layout.fxml";
    private final String MAIN_FXML="main_layout.fxml";
    public static ViewFactory defaultViewFactory = new ViewFactory();

    private ModelAccess ma = new ModelAccess();
    private Controller ctrl;
    private EmailDetailsController emailCtrl;

    public Node getIcon(String treeItemValue) {
        String itemValueLowerCase = treeItemValue.toLowerCase();
        ImageView returnIcon;

        try {
            if (itemValueLowerCase.contains("inbox")) {
                returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/folder.png")));
            } else if (itemValueLowerCase.contains("@")) {
                returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/mail.png")));
            } else {
                returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/folder.png")));
            }
            returnIcon.setFitHeight(18);
            returnIcon.setFitWidth(18);
            return returnIcon;

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ImageView();
        }
    }

    public Scene getScene(String name) throws IllegalArgumentException {
        if(name.contains("email_detail_layout")) {
            emailCtrl = new EmailDetailsController(ma);
            return initializeScene(EMAIL_DETAIL_FXML, emailCtrl);
        } else if (name.contains("main_layout")) {
                ctrl = new Controller(ma);
                return initializeScene(MAIN_FXML, ctrl);
        } else {
            throw new IllegalArgumentException("No scene name was provided");
        }
    }

    private Scene initializeScene(String fxmlPath, AbstractController controller) {
        FXMLLoader loader;
        Parent parent;
        Scene scene;

        try {
            loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(controller);
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource(DEFAULT_CSS_STYLESHEET).toExternalForm());
        return scene;
    }
}
