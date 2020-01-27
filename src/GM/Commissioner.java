package GM;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Commissioner {

    public String version, startingSeason;
    public Meta meta;
    public List<Team> teams;
    public List<JsonPG> players;

    private transient List<Award> awards;
    private transient List<ReleasedPlayer> ReleasedPlayers;
    private transient List<Game> Games;

    public Commissioner() {}

    public Commissioner(String version, String startingSeason, Meta meta, List<Team> teams, List<JsonPG> players, List<Award> awards, List<ReleasedPlayer> releasedPlayers, List<Game> games) {
        this.version = version;
        this.startingSeason = startingSeason;
        this.meta = meta;
        teams = teams;
        players = players;
        awards = awards;
        ReleasedPlayers = releasedPlayers;
        Games = games;
    }

    //useful one for updatedb?
    public Commissioner( List<Team> teams, List<JsonPG> players)
    {
        this.teams = teams;
        this.players = players;
    }

    @Override
    public String toString() {
        return "('"  + version + '\'' +
                ", " + meta +
                ", " + startingSeason + '\'' +
                ", " + teams +
                "," + ReleasedPlayers +
                ", " + players +
                ", " + Games +
                ")";
    }

    /*
    @Override
    public String toString() {
        return "Commisioner{" +
                "version='" + version + '\'' +
                ", Meta=" + meta +
                ", startingSeason='" + startingSeason + '\'' +
                ", Teams=" + teams +
                ", ReleasedPlayers=" + ReleasedPlayers +
                ", Players=" + players +
                ", Games=" + Games +
                '}';
    }*/

    public String getVersion() {
        return version;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<ReleasedPlayer>  getReleasedPlayers() {
        return ReleasedPlayers;
    }

    public List<JsonPG> getPlayers() {
        return players;
    }

    public List<Game> getGames() {
        return Games;
    }

    public String getStartingSeason() {
        return startingSeason;
    }
}
