package DB;

import GM.*;
import com.google.gson.Gson;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.scene.control.ComboBox;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateDB {

    private CreateConnection createObj;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedstatement;
    private ResultSet result;

    public UpdateDB() {}

    //Gets a connection to the DB
    private void OpenConnection() {
        createObj = CreateConnection.getCreateConnection();
        connection = createObj.getConnection();
    }


    public void addSeason()

    {
        String table = "JPGBoxscores";
        String createTable = "CREATE TABLE IF NOT EXISTS " + table + " (name varchar(50), season int, pid int, tid int, gid int, PRIMARY KEY (pid, gid, season))";

        List<Player> Players = new ArrayList<Player>();
        List<Team> Teams = new ArrayList<Team>();
        League league = new League();
        Players p = new Players();
        Seasons s;
        RankedAttribute ra;
        Commissioner commish; // = new Commissioner(Teams, Players);

        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.PRIVATE).create();
        String filepath = "C:\\Users\\kiyos\\Documents\\My shit\\BasketballGM\\BBGM_League_2_2019_re_sign_players.json";

        //parse json
        try (Reader reader = new FileReader(filepath)) {
            commish = gson.fromJson(reader, Commissioner.class);
            //addPlayers(commish.players, "Players");
        } catch (IOException e) {
            System.out.println("no filepath");
            e.printStackTrace();
        }
    }

    public void addPlayers(List<Player> players, String table)
    {
        Statement stmt;
        String add;
        String createTable = "CREATE TABLE IF NOT EXISTS " + table + " (pid int, firstName vatchar(20), lastName varchar(20), " +
                "season int, gamesUntilTradable int, ptModifier int, rosterOrder int, tid int, weight int, " +
                "yearsFreeAgent int, salary int, hof boolean, watch boolean, stre int, spd int, jmp int, endu int, ins int, " +
                "dnk int, ftskill int, fgskill int, tpskill int, oiq int, diq int, drbskill int, pss int, reb int, hgt int, orv int , pot int, " +
                "pos varchar(5), fuzz double, '3' boolean, A boolean, B boolean, Di boolean, Dp boolean, Po boolean, Ps boolean, " +
                "R boolean, value double, valueNoPot double, valueFuzz double, valueNoPotFuzz double, valueWithContract double, " +
                "yearsWithTeam int, gp double, gs int, fg double, fga int, fgAtRim int, fgaAtRim int, fgLowPost int, fgaLowPost int, " +
                "fgMidRange int, fgaMidRange int, tp double, tpa int, ft double, fta int, pm int, orb int, drb int, ast double, tov int, " +
                "stl int, blk int, ba int, pf int, pts int, per double, ewa double, astp double, blkp double, drbp double, " +
                "orbp double, stlp double, trbp double, usgp double, drtg double, ortg double, dws double, ows double, min double," +
                "PRIMARY KEY(pid, season));";
        System.out.println(createTable);
        try {
            OpenConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate("DROP TABLE Players;");
            stmt.executeUpdate(createTable);
            for(Player p : players)
            {
                add = "INSERT INTO " + table + " VALUES" + p.toSQL();
                //System.out.println(add);
                stmt = connection.createStatement();
                stmt.executeUpdate(add);
            }
        }

        catch (SQLException e)
        {
            System.out.print("addPlayers: ");
            System.out.println(e.getMessage());
        }
    }

    public void addTeams(Commissioner c, String table) {
        Statement stmt;
        String add;
        String createTable = "CREATE TABLE IF NOT EXISTS " + table + " (tid int, cid int, did int, region varchar(20), " +
                "name varchar(20), abbrev char(3), season int, won int, lost int, PRIMARY KEY (tid, season));";
        //System.out.println(createTable);
        try {
            OpenConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(createTable);
            for (Team t : c.teams) {
                //System.out.println("salary: " + t.getSeasons().get(0).getExpenses().getSalary().getAmount());
                add = "INSERT INTO " + table + " VALUES" + t.toSQL();
                System.out.println(add);
                stmt = connection.createStatement();
                stmt.executeUpdate(add);
            }

        } catch (SQLException e) {
            System.out.print("addTeams: ");
            System.out.println(e.getMessage());
        }

    }
}
