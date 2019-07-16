package GUI.Controllers;

import GM.*;

import static GUI.Main.gm;
import static GUI.Main.navigation;

import javafx.beans.binding.Bindings;
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
    @FXML TableView<RosterPlayer> roster_table;
    @FXML TableColumn<RosterPlayer, String> player_col;
    @FXML TableColumn<RosterPlayer, String> pos_col;
    @FXML TableColumn<RosterPlayer, Double> mpg_col;
    @FXML TableColumn<RosterPlayer, Double> points_col;
    @FXML TableColumn<RosterPlayer, Double> fgp_col;
    @FXML TableColumn<RosterPlayer, Double> ftp_col;
    @FXML TableColumn<RosterPlayer, Double> tpp_col;
    @FXML TableColumn<RosterPlayer, Double> assists_col;
    @FXML TableColumn<RosterPlayer, Double> rebounds_col;
    @FXML TableColumn<RosterPlayer, Double> steals_col;
    @FXML TableColumn<RosterPlayer, Double> blocks_col;
    //@FXML TableColumn<RosterPlayer, Double> tos_col;
    @FXML TableColumn<RosterPlayer, Double> fouls_col;

    @Override public void initialize(URL url, ResourceBundle rb)
    {
        String myTeam = "'TOR'";
        ObservableList<RosterPlayer> roster = gm.getRoster(myTeam);
        for(RosterPlayer player : roster)
        {
            System.out.print("Player: " + player.name);
            System.out.print(" Points: " + player.pts);
            System.out.println(" plus minus: " + player.plsmns);
        }
        roster_table.setItems(gm.getRoster(myTeam));
        player_col.setCellValueFactory(new PropertyValueFactory("name"));
        pos_col.setCellValueFactory(new PropertyValueFactory("pos"));
        mpg_col.setCellValueFactory(new PropertyValueFactory("mp"));
        points_col.setCellValueFactory(new PropertyValueFactory("pts"));
        fgp_col.setCellValueFactory(new PropertyValueFactory("fgp"));
        ftp_col.setCellValueFactory(new PropertyValueFactory("ftp"));
        tpp_col.setCellValueFactory(new PropertyValueFactory("tpp"));
        assists_col.setCellValueFactory(new PropertyValueFactory("ast"));
        rebounds_col.setCellValueFactory(new PropertyValueFactory("trb"));
        steals_col.setCellValueFactory(new PropertyValueFactory("stl"));
        blocks_col.setCellValueFactory(new PropertyValueFactory("blk"));
        //tos_col.setCellValueFactory(new PropertyValueFactory("_tos"));
        fouls_col.setCellValueFactory(new PropertyValueFactory("pf"));
        roster_table.getColumns().setAll(player_col, pos_col, mpg_col, points_col, fgp_col, ftp_col, tpp_col, assists_col, rebounds_col, steals_col, blocks_col, fouls_col);
        /*for(RosterPlayer in roster) {
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
            //roster_table.getColumns().setAll(player_col, pos_col, mpg_col, points_col, assists_col, rebounds_col, steals_col, blocks_col, tos_col, fouls_col);
        }*/
        //Team Team = league.getTeams();
        //getRoster();

    }

    @FXML void GoBack(ActionEvent events) throws IOException
    {
        navigation.unwind();
    }
}
