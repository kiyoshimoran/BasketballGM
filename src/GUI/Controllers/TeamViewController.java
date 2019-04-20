package GUI.Controllers;

import db.Teams;
import GM.Team.team;
import GM.Player.player
import static GUI.Main.navigation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;

public class TeamViewController implements Initializable {



    @FXML void GoBack(ActionEvent events) throws IOException
    {
        navigation.unwind();
    }
}
