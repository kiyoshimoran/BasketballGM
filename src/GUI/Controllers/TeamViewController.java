package GUI.Controllers;

import DB.CreateConnection;
import GM.*;

import static GM.GM.pl;
import static GUI.Main.gm;
import static GUI.Main.navigation;


import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class TeamViewController implements Initializable {

    private CreateConnection createObj;
    private Connection connection;

    @FXML Text record_text;
    @FXML Text team_name;

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


    private void OpenConnection() {
        createObj = CreateConnection.getCreateConnection();
        connection = createObj.getConnection();
    }

    @Override public void initialize(URL url, ResourceBundle rb)
    {
        String name, record, query;

        Statement stmt;
        ResultSet result;


        try {
            OpenConnection();
            query = "SELECT name, region, won, lost from Teams WHERE abbrev = " + gm.currentTeam + "";
            stmt = connection.createStatement();
            result = stmt.executeQuery(query);
            while(result.next())
            {
                name = result.getString("region") + " " + result.getString("name");
                record = Integer.toString(result.getInt("won")) + "-" + Integer.toString(result.getInt("lost"));
                team_name.setText(name);
                record_text.setText(record);
                team_name.setFont(Font.font("Garamond"));
                team_name.setFont(Font.font(70));
                record_text.setFont(Font.font(30));
            }
        }
        catch(SQLException e)
        {
            System.out.print("TeamViewController: ");
            System.out.println(e.getMessage());

        }
        formatCells();

        roster_table.setItems(gm.getRoster(gm.currentTeam));
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
    }

    @FXML void GoBack(ActionEvent events) throws IOException
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
