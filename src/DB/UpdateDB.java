package DB;

import java.io.*;
import com.google.gson.Gson;
import java.sql.*;
import java.util.Scanner;

public class UpdateDB {

    private CreateConnection createObj;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedstatement;
    private ResultSet result;

    private void OpenConnection() {
        createObj = CreateConnection.getCreateConnection();
        connection = createObj.getConnection();
    }


    public boolean addSeason()
    {
        Gson gson = new Gson();
        String json_player = "{'firstname' : 'lastname' :"
        while(stuff in file)
        {
            String st = "UPDATE " + db +
        }
        return true;
    }

}
