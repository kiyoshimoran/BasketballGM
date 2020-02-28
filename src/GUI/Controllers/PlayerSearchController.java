package GUI.Controllers;

import GM.*;
import DB.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import static GUI.Main.gm;
import static GUI.Main.navigation;

public class PlayerSearchController implements Initializable {

    private CreateConnection createObj;
    private Connection connection;

    public static String table = "Players";
    String query = "SELECT firstName, lastName, pos, min / gp, pts / gp, fg / gp, fga / gp, tp / gp, tpa / gp, ft / gp, fta / gp,  " +
            "orb / gp, drb / gp, ast / gp, stl / gp, blk / gp, pf / gp, pm / gp, t.abbrev FROM Players p join Teams t on p.tid = t.tid WHERE ";

    public ObservableList<String> comparators = FXCollections.observableArrayList(">", ">=", "=", "<", "<=");
    public ObservableList<String> stats = FXCollections.observableArrayList("min", "fg", "fga", "fgp", "ft", "fta",
            "ftp", "tp", "tpa", "tpp", "pts", "rb", "ast", "blk", "stl", "pf");

    @FXML AnchorPane roster_view;
    @FXML TableView<RosterPlayer> roster_table;
    @FXML TableColumn<RosterPlayer, String> player_col;
    @FXML TableColumn<RosterPlayer, String> pos_col;
    @FXML TableColumn<RosterPlayer, String> team_col;
    @FXML TableColumn<RosterPlayer, Double> mpg_col;
    @FXML TableColumn<RosterPlayer, Double> points_col;
    @FXML TableColumn<RosterPlayer, Double> fgp_col;
    @FXML TableColumn<RosterPlayer, Double> ftp_col;
    @FXML TableColumn<RosterPlayer, Double> tpp_col;
    @FXML TableColumn<RosterPlayer, Double> assists_col;
    @FXML TableColumn<RosterPlayer, Double> rebounds_col;
    @FXML TableColumn<RosterPlayer, Double> steals_col;
    @FXML TableColumn<RosterPlayer, Double> blocks_col;
    @FXML TableColumn<RosterPlayer, Double> to_col;
    @FXML TableColumn<RosterPlayer, Double> fouls_col;
    @FXML ComboBox<String> comparator;
    @FXML ComboBox<String> comparator1;
    @FXML ComboBox<String> comparator2;
    @FXML ComboBox<String> comparator3;
    @FXML ComboBox<String> comparator4;
    @FXML ComboBox<String> statBox;
    @FXML ComboBox<String> statBox1;
    @FXML ComboBox<String> statBox2;
    @FXML ComboBox<String> statBox3;
    @FXML ComboBox<String> statBox4;
    @FXML TextField valueField;
    @FXML TextField valueField1;
    @FXML TextField valueField2;
    @FXML TextField valueField3;
    @FXML TextField valueField4;
    @FXML CheckBox three;
    @FXML CheckBox A;
    @FXML CheckBox B;
    @FXML CheckBox Di;
    @FXML CheckBox Dp;
    @FXML CheckBox Po;
    @FXML CheckBox Ps;
    @FXML CheckBox R;


    @Override public void initialize(URL url, ResourceBundle rb)
    {
        comparator.setItems(comparators);
        comparator1.setItems(comparators);
        comparator2.setItems(comparators);
        comparator3.setItems(comparators);
        comparator4.setItems(comparators);
        statBox.setItems(stats);
        statBox1.setItems(stats);
        statBox2.setItems(stats);
        statBox3.setItems(stats);
        statBox4.setItems(stats);

    }

    private void OpenConnection() {
        createObj = CreateConnection.getCreateConnection();
        connection = createObj.getConnection();
    }

    @FXML
    void ApplyFilter(ActionEvent events)
    {
        RosterPlayer rp;
        String ptable = "Players" + gm.getCurrentSeason();
        String ttable = "Teams" + gm.getCurrentSeason();
        String query = "SELECT firstName, lastName, pos, min / gp, pts / gp, fg / gp, fga / gp, tp / gp, tpa / gp, ft / gp, fta / gp,  " +
                "orb / gp, drb / gp, ast / gp, stl / gp, blk / gp, pf / gp, pm / gp, t.abbrev FROM " + ptable + " p join " +
                ttable + " t on p.tid = t.tid WHERE ";
        ObservableList<RosterPlayer> Roster = FXCollections.observableArrayList();
        String qFilters = checkFilters();
        try {
            OpenConnection();
            Statement stmt = connection.createStatement();
            //System.out.println("qeury executed");
            System.out.println(query + qFilters);
            ResultSet result = stmt.executeQuery(query  + qFilters);
            //ResultSet result = stmt.executeQuery("SELECT fg / fga as fgp from Players;");
            //gm.viewResults(result);
            Roster = gm.buildRoster(result);
        }
        catch(SQLException e)
        {
            System.out.print("PlayerSearchController: ");
            System.out.println(e.getMessage());

        }
        formatCells();
        roster_table.setItems(Roster);
        mpg_col.setSortType(TableColumn.SortType.DESCENDING);
        player_col.setCellValueFactory(new PropertyValueFactory("name"));
        team_col.setCellValueFactory(new PropertyValueFactory("abbrev"));
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
        to_col.setCellValueFactory(new PropertyValueFactory("to"));
        fouls_col.setCellValueFactory(new PropertyValueFactory("pf"));
        roster_table.getColumns().setAll(player_col, pos_col, team_col, mpg_col, points_col, fgp_col, ftp_col, tpp_col, assists_col, rebounds_col, steals_col, blocks_col, to_col, fouls_col);
        roster_table.getSortOrder().add(mpg_col);
    }

    @FXML
    public void clearFilters()
    {
        comparator.valueProperty().set(null);
        comparator1.valueProperty().set(null);
        comparator2.valueProperty().set(null);
        comparator3.valueProperty().set(null);
        comparator4.valueProperty().set(null);
        statBox.valueProperty().set(null);
        statBox1.valueProperty().set(null);
        statBox2.valueProperty().set(null);
        statBox3.valueProperty().set(null);
        statBox4.valueProperty().set(null);
        valueField.clear();
        valueField1.clear();
        valueField2.clear();
        valueField3.clear();
        valueField4.clear();
    }

    public String checkSkills()
    {
        String temp = "";
        ArrayList<CheckBox> boxList = new ArrayList<CheckBox>(Arrays.asList(three, A, B, Di, Dp, Po, Ps, R));
        for(CheckBox b : boxList)
        {
            if(b.isSelected())
            {
                temp += " and " + b.getId() + " = 1";
            }
        }
        return temp;
    }

    public String checkFilters()
    {
        String temp = "";
        if(!comparator.getSelectionModel().isEmpty() && !statBox.getSelectionModel().isEmpty() && !valueField.getText().isEmpty()) {
             temp += setQuery(statBox.getValue()) + comparator.getValue() + " " + valueField.getText();
        }
        if(!comparator1.getSelectionModel().isEmpty() && !statBox1.getSelectionModel().isEmpty() && !valueField1.getText().isEmpty()) {
            temp += " and " + setQuery(statBox1.getValue()) + comparator1.getValue() + " " + valueField1.getText();
        }
        if(!comparator2.getSelectionModel().isEmpty() && !statBox2.getSelectionModel().isEmpty() && !valueField2.getText().isEmpty()) {
            temp += " and " + setQuery(statBox2.getValue()) + comparator2.getValue() + " " + valueField2.getText();
        }
        if(!comparator3.getSelectionModel().isEmpty() && !statBox3.getSelectionModel().isEmpty() && !valueField3.getText().isEmpty()) {
            temp += " and " + setQuery(statBox3.getValue()) + comparator3.getValue() + " " + valueField3.getText();
        }
        if(!comparator4.getSelectionModel().isEmpty() && !statBox4.getSelectionModel().isEmpty() && !valueField4.getText().isEmpty()) {
            temp += " and " + setQuery(statBox4.getValue()) + comparator4.getValue() + " " + valueField4.getText();
        }
        temp += checkSkills();
        if(temp.startsWith(" and "))
        {
            temp = temp.substring(4);
        }
        temp += ";";
        System.out.println("applyFilter: " + temp);
        return temp;
    }

    public String setQuery(String stat)
    {
        if(stat.equals("fgp")) {return "fg / fga ";}
        else if(stat.equals("ftp")) {return "ft / fta ";}
        else if(stat.equals("tpp")) {return "tp / tpa ";}
        else if(stat.equals("rb")) {return "(orb + drb) / gp ";}
        else {return stat + " / gp ";}
    }

    public void addAnotherFilter()
    {
        ComboBox<String> newcomp = new ComboBox<>();
        ComboBox<String> newstat = new ComboBox<>();
        TextField valField = new TextField();
    }

    @FXML
    void GoBack(ActionEvent events) throws IOException
    {
        navigation.unwind();
    }

    @FXML
    void clickTeam()
    {
        String team = roster_table.getSelectionModel().getSelectedItem().getAbbrev();
        gm.setCurrentTeam(team);
        navigation.performSegue("Views/TeamView.fxml", true);
    }

    void formatCells()
    {
        NumberFormat nf = new DecimalFormat("0.00");
        NumberFormat pf = new DecimalFormat("0.000");

        mpg_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.00");
                } else {
                    setText(nf.format(time));
                }
            }
        });
        points_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.00");
                } else {
                    setText(nf.format(time));
                }
            }
        });
        fgp_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.000");
                } else {
                    setText(pf.format(time));
                }
            }
        });
        tpp_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.000");
                } else {
                    setText(pf.format(time));
                }
            }
        });
        ftp_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.000");
                }
                else {
                    setText(pf.format(time));
                }
            }
        });
        assists_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.00");
                } else {
                    setText(nf.format(time));
                }
            }
        });
        rebounds_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.00");
                } else {
                    setText(nf.format(time));
                }
            }
        });
        fouls_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.00");
                } else {
                    setText(nf.format(time));
                }
            }
        });
        blocks_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.00");
                } else {
                    setText(nf.format(time));
                }
            }
        });
        steals_col.setCellFactory(tc ->new TableCell<RosterPlayer, Double>() {
            @Override
            protected void updateItem(Double time, boolean empty) {
                super.updateItem(time, empty);
                if (empty) {
                    setText("0.00");
                } else {
                    setText(nf.format(time));
                }
            }
        });
    }
}
