package GUI.Controllers;

import GM.*;
import DB.*;

import static GUI.Main.gm;
import static GUI.Main.navigation;

import javafx.collections.FXCollections;
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

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.ResourceBundle;

public class StandingsViewController implements Initializable {

    private UpdateDB udb;
    @FXML AnchorPane roster_view;
    @FXML TableView<Team> West;
    @FXML TableView<Team> East;
    @FXML TableColumn<Team, String> west_teams;
    @FXML TableColumn<Team, String> east_teams;
    @FXML TableColumn<Team, String> west_records;
    @FXML TableColumn<Team, String> east_records;
    @FXML ComboBox<Integer> season_box;


    @Override public void initialize(URL url, ResourceBundle rb)
    {
        UpdateDB udb = new UpdateDB();
        udb.addSeason();
        ObservableList<Integer> seasons = gm.getSeasons();
        season_box.setItems(seasons);
        int size = seasons.size();
        System.out.println(seasons.get(size - 1));
        setTeams(seasons.get(size - 1));
        gm.setCurrentSeason(seasons.get(size - 1));
    }

    public void setTeams(int season)
    {
        ObservableList<Team> teams = gm.getTeams(season);
        ObservableList<Team> western = FXCollections.observableArrayList();
        ObservableList<Team> eastern = FXCollections.observableArrayList();

        for(Team t: teams)
        {
            if(t.getCid() == 0)
            {
                western.add(t);
            }
            else
            {
                eastern.add(t);
            }
        }
        West.setItems(western);
        East.setItems(eastern);

        west_records.setSortType(TableColumn.SortType.DESCENDING);
        east_records.setSortType(TableColumn.SortType.DESCENDING);
        west_teams.setCellValueFactory(new PropertyValueFactory("name"));
        east_teams.setCellValueFactory(new PropertyValueFactory("name"));
        west_records.setCellValueFactory(new PropertyValueFactory("record"));
        east_records.setCellValueFactory(new PropertyValueFactory("record"));
        West.getColumns().setAll(west_teams, west_records);
        East.getColumns().setAll(east_teams, east_records);
        West.getSortOrder().add(west_records);
        East.getSortOrder().add(east_records);
    }

    @FXML
    void setSeason()
    {
        int season = season_box.getValue();
        setTeams(season);
        gm.setCurrentSeason(season);
        System.out.println("setSeason gm.season: " + gm.getCurrentSeason());
    }

    @FXML
    void clickEast()
    {
        String team = East.getSelectionModel().getSelectedItem().getAbbrev();
        gm.setCurrentTeam(team);
        navigation.performSegue("Views/TeamView.fxml", true);
    }

    @FXML
    void clickWest()
    {
        String team = West.getSelectionModel().getSelectedItem().getAbbrev();
        gm.setCurrentTeam(team);
        navigation.performSegue("Views/TeamView.fxml", true);
    }

    @FXML void SearchAction(ActionEvent event)
    {
        navigation.performSegue("Views/PlayerSearch.fxml", true);
    }

    @FXML void GoBack(ActionEvent events) throws IOException
    {
        navigation.unwind();
    }
}
