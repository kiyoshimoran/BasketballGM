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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.ResourceBundle;

import static GUI.Main.gm;
import static GUI.Main.navigation;

public class PlayerSearchController implements Initializable {

    private CreateConnection createObj;
    private Connection connection;

    public static String table = "Teams";
    String query = "SELECT name, pos, sum(mp), sum(pts), sum(fgm), sum(fga), sum(tpm), sum(tpa), sum(ftm), sum(fta)," +
            " sum(pts), sum(orb), sum(drb), sum(ast), sum(blk), sum(stl), sum(pf), sum(pm) FROM " + table +
            " WHERE ";
    public int filters = 0;

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
    @FXML ComboBox<String> comparator;
    @FXML ComboBox<String> statBox;
    @FXML TextField valueField;

    @Override public void initialize(URL url, ResourceBundle rb)
    {
        ObservableList<String> comparators = FXCollections.observableArrayList(">", ">=", "=", "<", "<=");
        ObservableList<String> stats = FXCollections.observableArrayList("mp", "fgm", "fga", "fgp", "ftm", "fta",
                "ftp", "tpm", "tpa", "tpp", "pts", "rb", "ast", "blk", "stl", "pf");
        comparator.setItems(comparators);
        statBox.setItems(stats);
        /*
        comparator.getItems().add(">");
        comparator.getItems().add(">=");
        comparator.getItems().add("=");
        comparator.getItems().add("<");
        comparator.getItems().add("<=");
        */
    }

    private void OpenConnection() {
        createObj = CreateConnection.getCreateConnection();
        connection = createObj.getConnection();
    }

    @FXML
    void AddFilter(ActionEvent events)
    {
        RosterPlayer rp;
        ObservableList<RosterPlayer> Roster = FXCollections.observableArrayList();
        String comp = comparator.getValue();
        String field = statBox.getValue();
        String val = valueField.getText();
        String gamesQuery = "SELECT count(pid) from " + table + " GROUP BY pid;";
        filters++;
        try {
            OpenConnection();
            Statement stmt = connection.createStatement();
            ResultSet games = stmt.executeQuery(gamesQuery);
            System.out.println("qeury executed");
            double gamesPlayed = games.getInt(1);
            query = query + "(sum(" + field + ") / " + gamesPlayed + ") " +comp + " " + val;
            System.out.println(query);
            ResultSet result = stmt.executeQuery(query + " Group by name;");
            while (result.next())
            {
                rp = new RosterPlayer(
                        result.getString("Name"),
                        result.getString("Pos"),
                        result.getDouble("sum(MP)") / gamesPlayed,
                        result.getDouble("sum(PTS)") / gamesPlayed,
                        result.getDouble("sum(FGM)") / gamesPlayed,
                        result.getDouble("sum(FGA)") / gamesPlayed,
                        result.getDouble("sum(TPM)") / gamesPlayed,
                        result.getDouble("sum(TPA)") / gamesPlayed,
                        result.getDouble("sum(FTM)") / gamesPlayed,
                        result.getDouble("sum(FTA)") / gamesPlayed,
                        result.getDouble("sum(ORB)") / gamesPlayed,
                        result.getDouble("sum(DRB)") / gamesPlayed,
                        result.getDouble("sum(AST)") / gamesPlayed,
                        result.getDouble("sum(STL)") / gamesPlayed,
                        result.getDouble("sum(BLK)") / gamesPlayed,
                        //result.getDouble("sum(TO)") / gamesPlayed,
                        result.getDouble("sum(PF)") / gamesPlayed,
                        result.getDouble("sum(PM)") / gamesPlayed);
                Roster.add(rp);
            }
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
        roster_table.getSortOrder().add(mpg_col);
        addAnotherFilter();
    }

    public void addAnotherFilter()
    {
        ComboBox<String> newcomp = new ComboBox<>();
        ComboBox<String> newstat = new ComboBox<>();
        TextField valField = new TextField();
        newcomp.show();
    }

    @FXML
    void GoBack(ActionEvent events) throws IOException
    {
        navigation.unwind();
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
