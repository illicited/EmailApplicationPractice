package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.View.ViewFactory;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ViewFactory vf = ViewFactory.defaultViewFactory;
        Scene scene = null;
        try {
            scene = vf.getScene("main_layout");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
