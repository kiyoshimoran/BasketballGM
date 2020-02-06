package GM;

import GM.*;
import DB.*;
import GUI.Python.PyLauncher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class GM {
    public HashMap<Integer, League> leagues;
    private CreateConnection createObj;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedstatement;
    private ResultSet result;
    private ResultSet games;
    public String currentTeam;
    public static PyLauncher pl = new PyLauncher();
    public GM() {}

    public GM(HashMap l)
    {
        this.leagues = l;
    }

    private void OpenConnection()
    {
        createObj = CreateConnection.getCreateConnection();
        connection = createObj.getConnection();
    }

    public ObservableList<Team> getTeams()
    {
        ObservableList<Team> Teams = FXCollections.observableArrayList();
        String table = "Teams";
        tryMakeTable(table);
        String query = "SELECT * from " + table;
        UpdateDB udb = new UpdateDB();
        Commissioner c = new Commissioner();
        udb.addSeason();
        try
        {
            OpenConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            //viewResults(result);
            while(result.next())
            {
                Team t = new Team(
                        result.getInt("tid"),
                        result.getInt("cid"),
                        result.getInt("did"),
                        result.getString("region"),
                        result.getString("name"),
                        result.getString("abbrev"),
                        result.getInt("won"),
                        result.getInt("lost"));
                Teams.add(t);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());

        }
        return Teams;
    }

    public ObservableList<RosterPlayer> getRoster()
    {
        String table = "Players";
        RosterPlayer rp;
        ObservableList<RosterPlayer> Roster = FXCollections.observableArrayList();
        String stats[] = {"mp", "fgm", "fga", "ftm", "fta", "pts", "trb", "ast", "blk", "stl", "pf"};
        String query = "SELECT firstName, lastName, pos, min / gp, pts / gp, fg / gp, fga / gp, tp / gp, tpa / gp, ft / gp, fta / gp,  " +
                    "orb / gp, drb / gp, ast / gp, stl / gp, blk / gp, pf / gp, pm / gp, t.abbrev FROM Players p join Teams t on p.tid = t.tid;";
        //String query = "SELECT firstName, lastName, pos, min / gp, pts / gp, fg / gp, fga / gp, tp / gp, tpa / gp, ft / gp, fta / gp,  " +
        //    "orb / gp, drb / gp, ast / gp, stl / gp, blk / gp, pf / gp, pm / gp FROM Players;";
        //System.out.println(query);
        try
        {
            OpenConnection();
            statement = connection.createStatement();
            preparedstatement = connection.prepareStatement(query);
            result = preparedstatement.executeQuery();
            Roster = buildRoster(result);
        }
        catch(SQLException e)
        {
            System.out.print("getRoster: ");
            System.out.println(e.getMessage());
        }
        return Roster;
    }

    public ObservableList<RosterPlayer> getRoster(String team)
    {
        String table = "Players";
        RosterPlayer rp;
        ObservableList<RosterPlayer> Roster = FXCollections.observableArrayList();
        String stats[] = {"mp", "fgm", "fga", "ftm", "fta", "pts", "trb", "ast", "blk", "stl", "pf"};
        String query = "SELECT firstName, lastName, pos, min / gp, pts / gp, fg / gp, fga / gp, tp / gp, tpa / gp, ft / gp, fta / gp,  " +
                "orb / gp, drb / gp, ast / gp, stl / gp, blk / gp, pf / gp, pm / gp, t.abbrev FROM Players p join Teams t on p.tid = t.tid " +
                "WHERE p.tid = t.tid and t.abbrev = ";
        System.out.println(query + currentTeam);
        //String query = "SELECT firstName, lastName, pos, min / gp, pts / gp, fg / gp, fga / gp, tp / gp, tpa / gp, ft / gp, fta / gp,  " +
        //    "orb / gp, drb / gp, ast / gp, stl / gp, blk / gp, pf / gp, pm / gp FROM Players;";
        //System.out.println(query);
        try
        {
            OpenConnection();
            statement = connection.createStatement();
            preparedstatement = connection.prepareStatement(query + currentTeam);
            result = preparedstatement.executeQuery();
            Roster = buildRoster(result);
        }
        catch(SQLException e)
        {
            System.out.print("getRoster: ");
            System.out.println(e.getMessage());
        }
        return Roster;
    }

    public void tryMakeTable(String table)
    {
        try {
            OpenConnection();
            statement = connection.createStatement();
            String create = "CREATE TABLE IF NOT EXISTS " + table + " (tid int, cid int, did int, region varchar(20), " +
                    "name varchar(20), abbrev varchar(3), season int, won int, lost int, PRIMARY KEY (tid, season));";
            statement.executeUpdate(create);
        }
        catch(SQLException e)
        {
            System.out.print("tryMakeTable: ");
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<RosterPlayer> buildRoster(ResultSet result)
    {
        ObservableList<RosterPlayer> Roster = FXCollections.observableArrayList();
        RosterPlayer rp;
        try
        {
            while (result.next()) {
                rp = new RosterPlayer(
                        result.getString("firstName") + " " + result.getString("lastName"),
                        result.getString("Pos"),
                        result.getString("abbrev"),
                        result.getDouble(4),
                        result.getDouble(5),
                        result.getDouble(6),
                        result.getDouble(7),
                        result.getDouble(8),
                        result.getDouble(9),
                        result.getDouble(10),
                        result.getDouble(11),
                        result.getDouble(12),
                        result.getDouble(13),
                        result.getDouble(14),
                        result.getDouble(15),
                        result.getDouble(16),
                        //result.getDouble("sum(TO)") / gamesPlayed,
                        result.getDouble(17),
                        result.getDouble(18));
                //System.out.println(rp.toString());
                Roster.add(rp);
            }
        }
        catch(SQLException e)
        {
            System.out.print("buildRoster: ");
            System.out.println(e.getMessage());

        }
        return Roster;
    }

    public void viewResults(ResultSet result)
    {
        try {
            ResultSetMetaData rsmd = result.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = result.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
        }
        catch(SQLException e)
        {
            System.out.print("viewResults: ");
            System.out.println(e.getMessage());
        }
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = '"' + currentTeam + '"';
    }

    public HashMap getLeagues()
    {
        return leagues;
    }
}
