package GM;

import DB.CreateConnection;
import GM.Team;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.HashMap;

public class League
{
    public HashMap<String, Team> team_hash;
    ObservableList<String> team_list;
    public HashMap<Integer, League> league_hash;
    private CreateConnection createObj;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedstatement;
    private ResultSet teams;
    private ResultSet games;


    public League() {}

    public League(HashMap teams)
    {
        this.team_hash = teams;
    }

    private void OpenConnection()
    {
        createObj = CreateConnection.getCreateConnection();
        connection = createObj.getConnection();
    }

    public HashMap getTeams()
    {
        //get down to one result per team or switch to gson
        //use query as subquery? and search from there
        //String teamsQuery = "SELECT team, count(WL) from GamePlayer group by team";
        String teamsQuery = "SELECT team, sum(case when WL is 'W' and not playoffs then 1 else 0 end) as wins," +
                "sum(case when WL is 'L' and not playoffs then 1 else 0 end) as losses, pid " +
                "from GamePlayer group by team, pid having count(WL) = 82";
        try {
            OpenConnection();
            preparedstatement = connection.prepareStatement(teamsQuery);
            teams = preparedstatement.executeQuery();
            ResultSetMetaData rsmd = teams.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (teams.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = teams.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
            /*while(teams.next())
            {
                Team t = new Team();
                //team_hash.put(teams.getString("Team"), t);
                System.out.print(teams.getString("Team") + " ");
                System.out.print(teams.getString("Wins")+ " ");
                System.out.println(teams.getString("Losses"));
            }*/
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());

        }

        return team_hash;
    }

    public void populate_leauges()
    {

    }
}
