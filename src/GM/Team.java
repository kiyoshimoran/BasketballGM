package GM;

import GM.*;
import com.google.gson.annotations.Expose;

import java.util.List;

public class Team {

    public String region, name, abbrev, strategy, record;
    private transient String imgURL;
    public int tid, cid, did;
    public Budget budget;
    public List<Season> seasons;

    private transient List<TeamStats> stats;
    private transient List<String> colors;

    public Team() {}

    public Team(String region, String name, String abbrev, String imgURL, String strategy, int tid, int cid, int did,
                Budget budget, List<Season> seasons, List<TeamStats> stats, List<String> colors) {
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

    public Team(int tid, int cid, int did, String region, String name, String abbrev, int won, int lost)
    {
        this.tid = tid;
        this.cid = cid;
        this.did = did;
        this.region = region;
        this.name = name;
        this.abbrev = abbrev;
        this.record = Integer.toString(won) + "-" + Integer.toString(lost);
    }

    public String toSQL(int season) {
        return "(" + tid +
                ", " + cid +
                ", " + did +
                ", '" + region + '\'' +
                ", '" + name + '\'' +
                ", '" + abbrev + '\'' +
                ", " + season +
                ", " + getRecord(seasons, season) +
                //", " + seasons.get(0).getExpenses().getSalary().getAmount() +
                ')';
    }

    @Override
    public String toString() {
        return "(" +
                "'" + region + '\'' +
                ", '" + name + '\'' +
                ", '" + abbrev + '\'' +
                ", '" + imgURL + '\'' +
                ", '" + strategy + '\'' +
                ", " + tid +
                ", " + cid +
                ", " + did +
                ", " + budget +
                ", " + seasons +
                ", " + stats +
                ", " + colors +
                ')';
    }

    public String getRecord(List<Season> seasons, int season)
    {
        String record = "";
        for(Season s : seasons)
        {
            if(s.getSeason() == season)
            {
                record = s.getWon() + ", " + s.getLost();
            }
        }
        return record;
    }

    public String getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public String getStrategy() {
        return strategy;
    }

    public String getImgURL() {
        return imgURL;
    }

    public int getTid() {
        return tid;
    }

    public int getCid() {
        return cid;
    }

    public int getDid() {
        return did;
    }

    public Budget getBudget() {
        return budget;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public String getRecord() {
        return record;
    }
}
