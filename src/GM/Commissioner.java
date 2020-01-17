package GM;

import java.util.List;

public class Commissioner {

    public String version, startingSeason;
    public List<Team> Teams;
    public List<JsonPG> Players;

    private transient List<Award> Awards;
    private transient List<ReleasedPlayer> ReleasedPlayers;
    private transient List<Game> Games;

    public Commissioner() {}

    public Commissioner(String version, String startingSeason, List<Team> teams, List<JsonPG> players, List<Award> awards, List<ReleasedPlayer> releasedPlayers, List<Game> games) {
        this.version = version;
        this.startingSeason = startingSeason;
        Teams = teams;
        Players = players;
        Awards = awards;
        ReleasedPlayers = releasedPlayers;
        Games = games;
    }

    //useful one for updatedb?
    public Commissioner( List<Team> teams, List<JsonPG> players)
    {
        this.Teams = teams;
        this.Players = players;
    }

    @Override
    public String toString() {
        return "Commisioner{" +
                "version='" + version + '\'' +
                ", startingSeason='" + startingSeason + '\'' +
                ", Teams=" + Teams +
                ", ReleasedPlayers=" + ReleasedPlayers +
                ", Players=" + Players +
                ", Games=" + Games +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public List<Team> getTeams() {
        return Teams;
    }

    public List<ReleasedPlayer>  getReleasedPlayers() {
        return ReleasedPlayers;
    }

    public List<JsonPG> getPlayers() {
        return Players;
    }

    public List<Game> getGames() {
        return Games;
    }

    public String getStartingSeason() {
        return startingSeason;
    }
}
