package GM;

import GM.*;

public class Team {

    public String region, name, abbrev, imgURL, strategy;
    public int tid, cid, did;
    public Budget budget;
    public Seasons seasons;

    private transient TeamStats stats;
    private transient Colors colors;

    public Team() {}

    public Team(String region, String name, String abbrev, String imgURL, String strategy, int tid, int cid, int did,
                Budget budget, Seasons seasons, TeamStats stats, Colors colors) {
        this.region = region;
        this.name = name;
        this.abbrev = abbrev;
        this.imgURL = imgURL;
        this.strategy = strategy;
        this.tid = tid;
        this.cid = cid;
        this.did = did;
        this.budget = budget;
        this.seasons = seasons;
        this.stats = stats;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Team{" +
                "region='" + region + '\'' +
                ", name='" + name + '\'' +
                ", abbrev='" + abbrev + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", strategy='" + strategy + '\'' +
                ", tid=" + tid +
                ", cid=" + cid +
                ", did=" + did +
                ", budget=" + budget +
                ", seasons=" + seasons +
                ", stats=" + stats +
                ", colors=" + colors +
                '}';
    }
}
