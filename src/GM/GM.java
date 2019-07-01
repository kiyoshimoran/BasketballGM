package GM;

import GM.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;

public class GM {
    public HashMap<Integer, League> leagues;

    public GM() {}

    public GM(HashMap l)
    {
        this.leagues = l;
    }

    public ObservableList<RosterPlayer> getRoster(String myTeam)
    {
        ObservableList<RosterPlayer> Roster = FXCollections.observableArrayList();
        String query = "SELECT count(mp, fgm, fga, tpm, tpa, ftm, fta, pts, trb, ast, blk, stl, to, pf) FROM Player WHERE Team = " + myTeam + "Group by name";
        OpenConnection();
        statement= connection.createStatement();
        result=statement.executeQuery(query);
        return Roster;
    }

    public HashMap getLeagues()
    {
        return leagues;
    }
}
