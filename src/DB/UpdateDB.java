package DB;

import java.sql.*;
import java.io.FileReader;

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

    public void updateDB()
    {

    }
}
