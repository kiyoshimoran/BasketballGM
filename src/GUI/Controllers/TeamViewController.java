package GUI.Controllers;

import GM.League;
import GM.Team;
import GM.Player;

import static GUI.Main.gm;
import static GUI.Main.navigation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TeamViewController implements Initializable {

    @FXML AnchorPane roster_view;
    @FXML TableView<Team> roster_table;
    @FXML TableColumn<Team, String> player_col;
    @FXML TableColumn<Player, Double> pos_col;
    @FXML TableColumn<Player, String> mpg_col;
    @FXML TableColumn<Player, Double> points_col;
    @FXML TableColumn<Player, Double> assists_col;
    @FXML TableColumn<Player, Double> rebounds_col;
    @FXML TableColumn<Player, Double> steals_col;
    @FXML TableColumn<Player, Double> blocks_col;
    @FXML TableColumn<Player, Double> tos_col;
    @FXML TableColumn<Player, Double> fouls_col;

    @Override public void initialize(URL url, ResourceBundle rb)
    {
        String myTeam = 'TOR';
        HashMap leagues = gm.getLeagues();
        //Team team = gm.getTeam(myTeam);
        ObservableList<Player> roster = gm.getRoster();
        // TODO get games played from data
        int gamesPlayed = 82;
        //roster_table.setItems(gm.getRoster(myTeam));
        for(Player in roster) {
            player_col.setCellValueFactory(new PropertyValueFactory("_Name"));
            pos_col.setCellValueFactory(new PropertyValueFactory("_Position"));
            mpg_col.setCellValueFactory(new PropertyValueFactory("_mp"));
            points_col.setCellValueFactory(new PropertyValueFactory("_points"));
            assists_col.setCellValueFactory(new PropertyValueFactory("_assists"));
            rebounds_col.setCellValueFactory(new PropertyValueFactory("_rebounds"));
            steals_col.setCellValueFactory(new PropertyValueFactory("_steals"));
            blocks_col.setCellValueFactory(new PropertyValueFactory("_blocks"));
            tos_col.setCellValueFactory(new PropertyValueFactory("_tos"));
            fouls_col.setCellValueFactory(new PropertyValueFactory("_fouls"));
            roster_table.getColumns().setAll(player_col, pos_col, mpg_col, points_col, assists_col, rebounds_col, steals_col, blocks_col, tos_col, fouls_col);
        }
        //Team Team = league.getTeams();
        //getRoster();

    }

    @FXML void GoBack(ActionEvent events) throws IOException
    {
        navigation.unwind();
    }
}
