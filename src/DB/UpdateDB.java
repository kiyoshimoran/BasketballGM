package DB;

import GM.*;
import com.google.gson.Gson;
import java.lang.reflect.Type;
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
        JsonPG jpg = new JsonPG();
        List<JsonPG> pglist = new ArrayList<JsonPG>();
        Type listType = new TypeToken<ArrayList<JsonPG>>(){}.getType();
        League league = new League();
        Players p;
        HashMap<String, Team> team_hash = new HashMap<String, Team>();
        HashMap<String, GamePlayer> roster = new HashMap<String, GamePlayer>();

        Gson gson = new Gson();
        String filepath = "C:\\Users\\kiyos\\Documents\\My shit\\BasketballGM\\BBGM_League_1_2043.json";
        String testfile = "C:\\Users\\kiyos\\Documents\\My shit\\BasketballGM\\bbgm_test.json";
        //String file = "BBGM_League_1_2043";

        //start at line 154228 "Player feats"
        try (Reader reader = new FileReader(filepath))
        {
            System.out.println("file reader craeted");
            //jpg = gson.fromJson(reader, JsonPG.class);
            p = gson.fromJson(reader, Players.class);
            //List<JsonPG> otherlist = gson.fromJson(reader, listType);
            System.out.println("parsed json");
            System.out.println(p.season);
            System.out.println(p.toString());
        }

        catch (IOException e)
        {
            System.out.println("no filepath");
            e.printStackTrace();
        }
    }

}
