package DB;

import java.io.FileReader;
import java.io.File;
import java.sql.*;

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

    /*public boolean addSeason(File f)
    {
        while(stuff in file)
        {
            String st = "UPDATE " + db +
        }
    }
    }*/

}
