package GM;

public class SeasonStats {

    public double stat;

    public SeasonStats(double stat) {
        this.stat = stat;
    }

    public SeasonStats() {
    }

    @Override
    public String toString() {
        return "" +
                "stat=" + stat +
                "";
    }
}
