package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static NavigationStack navigation = new NavigationStack(600, 400);

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        navigation.performSegue("../Views/TeamView.fxml", true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
