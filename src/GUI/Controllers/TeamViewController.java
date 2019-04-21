package GUI.Controllers;

import GM.League;
import GM.Team;
import GM.Player;
import static GUI.Main.navigation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

import java.io.IOException;

public class TeamViewController implements Initializable {

    @FXML AnchorPane roster_view;
    @FXML TableView<roster_table> flight_table;
    @FXML TableColumn<Roster, String> dest_column;
    @FXML TableColumn<Player, String> origin_column;
    @FXML TableColumn<Player, String> departure_column;
    @FXML TableColumn<Player, String> arrival_column;

    @FXML void GoBack(ActionEvent events) throws IOException
    {
        navigation.unwind();
    }
}
