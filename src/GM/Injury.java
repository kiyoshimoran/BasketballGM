package GM;

public class Injury {

    public String type;
    public int gamesRemaining;

    public Injury() {}

    public Injury(String type, int gamesRemaining) {
        this.type = type;
        this.gamesRemaining = gamesRemaining;
    }

    public String getType() {
        return type;
    }

    public int getGamesRemaining() {
        return gamesRemaining;
    }
}
