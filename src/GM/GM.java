package GM;

import GM.Team;

import java.util.HashMap;

public class GM {
    public HashMap<Integer, League> leagues;

    public GM() {}

    public GM(HashMap l)
    {
        this.leagues = l;
    }

    public HashMap getLeagues()
    {
        return leagues;
    }
}
