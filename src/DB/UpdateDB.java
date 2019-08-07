package DB;

import java.io.*;
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

    public boolean addSeason(File f, String season)
    {
        FileInputStream inputStream = new FileInputStream("Users\kiyos\Documents\My shit\BasketballGM\\2018_season_stats");
        Scanner sc = new Scanner(inputStream, "UTF-8");
        while(sc.hasNextLine()) {
    }
    }

}
