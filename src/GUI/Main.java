package GUI;

import javafx.application.Application;
import GUI.NavigationStack;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import GM.*;

public class Main extends Application {

    public static NavigationStack navigation = new NavigationStack(1700, 900);
    public static GM gm = new GM();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //navigation.performSegue("Views/TeamView.fxml", false);
        navigation.performSegue("Views/StandingsView.fxml", true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
