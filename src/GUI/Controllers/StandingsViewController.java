package GUI.Controllers;

import GM.League;
import GM.Team;
import GM.GamePlayer;

import static GUI.Main.gm;
import static GUI.Main.navigation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class StandingsViewController implements Initializable {

    @FXML AnchorPane roster_view;
    @FXML TableView<Team> roster_table;
    @FXML TableColumn<Team, String> player_col;
    @FXML TableColumn<GamePlayer, String> pos_col;
    @FXML TableColumn<GamePlayer, Double> mpg_col;
    @FXML TableColumn<GamePlayer, Double> points_col;
    @FXML TableColumn<GamePlayer, Double> assists_col;
    @FXML TableColumn<GamePlayer, Double> rebounds_col;
    @FXML TableColumn<GamePlayer, Double> steals_col;
    @FXML TableColumn<GamePlayer, Double> blocks_col;
    @FXML TableColumn<GamePlayer, Double> tos_col;
    @FXML TableColumn<GamePlayer, Double> fouls_col;

    @Override public void initialize(URL url, ResourceBundle rb)
    {
        HashMap leagues = gm.getLeagues();
        //Team Team = league.getTeams();
        //getRoster();

    }

    @FXML void GoBack(ActionEvent events) throws IOException
    {
        navigation.unwind();
    }
}
