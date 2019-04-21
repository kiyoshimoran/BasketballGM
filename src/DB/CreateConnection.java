package DB;

import java.sql.*;

public class CreateConnection {
    private static CreateConnection createObj;
    private Connection connection;

    private CreateConnection() {}

    private void connect()
    {
        try {
            String url="jdbc:sqlite:RealGMDB.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static CreateConnection getCreateConnection()
    {
        if (createObj == null)
        {
            createObj = new CreateConnection();
        }

        return createObj;
    }

    public Connection getConnection()
    {
        if (connection == null)
        {
            connect();
        }
        return connection;
    }

    public void cleanup(ResultSet result, PreparedStatement preparedstatement) {
        try {
            if (result!=null)
                result.close();
            if (preparedstatement!=null) {
                preparedstatement.close();
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
