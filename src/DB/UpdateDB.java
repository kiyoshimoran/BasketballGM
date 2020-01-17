package DB;

import GM.*;
import com.google.gson.Gson;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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

    public UpdateDB() {};

    //Gets a connection to the DB
    private void OpenConnection() {
        createObj = CreateConnection.getCreateConnection();
        connection = createObj.getConnection();
    }


    public void addSeason()

    {
        Statement stmt;

        String table = "JPGBoxscores";
        String createTable = "CREATE TABLE " + table + " (name varchar(50), season int, pid int, tid int, gid int, PRIMARY KEY (pid, gid, season))";

        List<JsonPG> Players = new ArrayList<JsonPG>();
        List<Team> Teams = new ArrayList<Team>();
        JsonPG jpg = new JsonPG();
        League league = new League();
        Players p = new Players();
        Seasons s;
        Commissioner commish; // = new Commissioner(Teams, Players);

        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.STATIC).create();
        String filepath = "C:\\Users\\kiyos\\Documents\\My shit\\BasketballGM\\BBGM_League_2_2019_re_sign_players.json";
        String testfile = "C:\\Users\\kiyos\\Documents\\My shit\\BasketballGM\\bbgm_test.json";
        //String file = "BBGM_League_1_2043";

        //start at line 154228 "Player feats"
        try (Reader reader = new FileReader(filepath))
        {
            System.out.println("file reader craeted");
            //jpg = gson.fromJson(reader, JsonPG.class);
            commish = gson.fromJson(reader, Commissioner.class);
            //List<JsonPG> otherlist = gson.fromJson(reader, listType);
            System.out.println("parsed json");
            System.out.println(commish.toString());

            /*try
            {
                OpenConnection();
                // check if table exists (by year) and create or skip depending
                System.out.println(createTable);
                Statement stmt = connection.createStatement();
                System.out.println("statement created");
                stmt.executeUpdate(createTable);
                System.out.println("table created");
                for (JsonPG j : p.everyone)
                {
                    String add = "INSERT INTO " + table +  " VALUES" + j.toSQLStatement();
                    stmt = connection.createStatement();
                    stmt.executeUpdate(add);
                }
            }
            catch (SQLException e)
            {
                System.out.print("UpdateDB: ");
                System.out.println(e.getMessage());
            }*/
        }

        catch (IOException e)
        {
            System.out.println("no filepath");
            e.printStackTrace();
        }



    }

}
