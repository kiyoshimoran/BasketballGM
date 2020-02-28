package GM;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Commissioner {

    public String version, startingSeason;
    public Meta meta;
    public List<Team> teams;
    public List<Player> players;

    private transient List<Award> awards;
    private transient List<ReleasedPlayer> ReleasedPlayers;
    private transient List<Game> Games;

    public Commissioner() {}

    public Commissioner(String version, String startingSeason, Meta meta, List<Team> teams, List<Player> players, List<Award> awards, List<ReleasedPlayer> releasedPlayers, List<Game> games) {
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
    public Commissioner( List<Team> teams, List<Player> players)
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

    public int getSeason() { return meta.getSeason(); }

    public String getVersion() {
        return version;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<ReleasedPlayer>  getReleasedPlayers() {
        return ReleasedPlayers;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Game> getGames() {
        return Games;
    }

    public String getStartingSeason() {
        return startingSeason;
    }
}
