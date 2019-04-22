package GM;

import GM.Team;
import java.util.HashMap;

public class League
{
    public HashMap<String, Team> team_hash;
    public HashMap<Integer, League> league_hash;

    public League() {}

    public League(HashMap teams)
    {
        this.team_hash = teams;
    }

    public HashMap getTeams() { return team_hash;}

    public void populate_leauges()
    {

    }
}
