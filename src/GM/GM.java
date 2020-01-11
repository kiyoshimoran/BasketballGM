package GM;

import GM.*;
import DB.*;
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

    public ObservableList<RosterPlayer> getRoster(String myTeam)
    {
        double gamesPlayed;
        RosterPlayer rp;
        ObservableList<RosterPlayer> Roster = FXCollections.observableArrayList();
        String stats[] = {"mp", "fgm", "fga", "ftm", "fta", "pts", "trb", "ast", "blk", "stl", "pf"};
        String gamesQuery = "SELECT count(pid) from GamePlayer WHERE team = " + myTeam + " GROUP BY pid;";
        String query = "SELECT name, pos, sum(mp), sum(pts), sum(fgm), sum(fga), sum(tpm), sum(tpa), sum(ftm), sum(fta)," +
                " sum(pts), sum(orb), sum(drb), sum(ast), sum(blk), sum(stl), sum(pf), sum(pm) FROM GamePlayer " +
                "WHERE Team = " + myTeam + " Group by name;";
        //System.out.println(query);
        try {
            OpenConnection();
            statement = connection.createStatement();
            games = statement.executeQuery(gamesQuery);
            gamesPlayed = games.getInt(1);
            preparedstatement = connection.prepareStatement(query);
            result = preparedstatement.executeQuery();

            while(result.next())
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
            /*
            ResultSetMetaData rsmd = result.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = result.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }*/

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());

        }
        return Roster;
    }

    public HashMap getLeagues()
    {
        return leagues;
    }
}
