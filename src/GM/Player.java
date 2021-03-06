package GM;

import java.util.List;

public class Player {

    private transient List<PlayerAward> playerAwards;
    private transient String imgURL, college;
    private transient List<Relative> relatives;
    private transient int retiredYear;
    private transient Face face;
    private transient List<statsTids> st;

    public Born born;
    public Contract contract;
    public Draft draft;
    public String firstName, lastName;
    public List<Double> freeAgentMood;
    public int gamesUntilTradable, hgt, ptModifier, rosterOrder, tid, weight, yearsFreeAgent, pid;
    public boolean hof, watch;
    public List<Ratings> ratings;
    public List<Salary> salaries;
    public double value, valueNoPot, valueFuzz, valueNoPotFuzz, valueWithContract;
    public List<Injury> injuries;
    public List<PlayerStats> stats;

    /*
    3: Three Point Shooter
    A: Athlete
    B: Ball Handler
    Di: Interior Defender
    Dp: Perimeter Defender
    Po: Post Scorer
    Ps: Passer
    R: Rebounder
     */

    public Player() {}

    public Player(Born born, Contract contract, Draft draft, String firstName, String lastName, List<Double> freeAgentMood,
                  int gamesUntilTradable, int hgt, int ptModifier, int rosterOrder, int tid, int weight, int yearsFreeAgent,
                  int pid, boolean hof, boolean watch, List<Ratings> ratings, List<Salary> salaries, double value, double valueNoPot,
                  double valueFuzz, double valueNoPotFuzz, double valueWithContract, List<Injury> injuries, List<PlayerStats> stats)
    {
        this.born = born;
        this.contract = contract;
        this.draft = draft;
        this.firstName = firstName;
        this.lastName = lastName;
        this.freeAgentMood = freeAgentMood;
        this.gamesUntilTradable = gamesUntilTradable;
        this.hgt = hgt;
        this.ptModifier = ptModifier;
        this.rosterOrder = rosterOrder;
        this.tid = tid;
        this.weight = weight;
        this.yearsFreeAgent = yearsFreeAgent;
        this.pid = pid;
        this.hof = hof;
        this.watch = watch;
        this.ratings = ratings;
        this.salaries = salaries;
        this.value = value;
        this.valueNoPot = valueNoPot;
        this.valueFuzz = valueFuzz;
        this.valueNoPotFuzz = valueNoPotFuzz;
        this.valueWithContract = valueWithContract;
        this.injuries = injuries;
        this.stats = stats;
    }

    public String toSQL(int season) {
        return "(" +  pid +
                ", '" + firstName.replace("'", "''") + '\'' +
                ", '" + lastName.replace("'", "''") + '\'' +
                ", " + season +
                ", " + gamesUntilTradable +
                ", " + ptModifier +
                ", " + rosterOrder +
                ", " + tid +
                ", " + weight +
                ", " + yearsFreeAgent +
                ", " + ((salaries.isEmpty()) ? "0" : getSeasonSalary(salaries, season)) +
                //draft.toSQL() +
                ", " + hof +
                ", " + watch +
                getSeasonRatings(ratings, season) +
                ", " + value +
                ", " + valueNoPot +
                ", " + valueFuzz +
                ", " + valueNoPotFuzz +
                ", " + valueWithContract +
                ((stats.isEmpty()) ? popStats() : getSeasonStats(stats, season)) +
                ')';
    }

    public String getSeasonStats(List<PlayerStats> list, int season)
    {
        for(PlayerStats p : list)
        {
            if(p.getSeason() == season)
            {
                return p.toSQL();
            }
        }
        return list.get(0).toSQL();
    }

    public String getSeasonRatings(List<Ratings> list, int season)
    {
        for(Ratings r : list)
        {
            if(r.getSeason() == season)
            {
                return r.toSQL();
            }
        }
        return list.get(0).toSQL();
    }

    public String getSeasonSalary(List<Salary> list, int season)
    {
        for(Salary s : list)
        {
            if(s.getSeason() == season)
            {
                return s.toSQL();
            }
        }
        return list.get(0).toSQL();
    }

    @Override
    public String toString() {
        return "Player{" +
                "born=" + born +
                ", contract=" + contract +
                ", draft=" + draft +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", freeAgentMood=" + freeAgentMood +
                ", gamesUntilTradable=" + gamesUntilTradable +
                ", hgt=" + hgt +
                ", ptModifier=" + ptModifier +
                ", rosterOrder=" + rosterOrder +
                ", tid=" + tid +
                ", weight=" + weight +
                ", yearsFreeAgent=" + yearsFreeAgent +
                ", pid=" + pid +
                ", hof=" + hof +
                ", watch=" + watch +
                ", ratings=" + ratings +
                ", salaries=" + salaries +
                ", value=" + value +
                ", valueNoPot=" + valueNoPot +
                ", valueFuzz=" + valueFuzz +
                ", valueNoPotFuzz=" + valueNoPotFuzz +
                ", valueWithContract=" + valueWithContract +
                ", injuries=" + injuries +
                ", stats=" + stats +
                '}';
    }

    public String popStats()
    {
        return ", FALSE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
    }

    public Born getBorn() {
        return born;
    }

    public Contract getContract() {
        return contract;
    }

    public Draft getDraft() {
        return draft;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Double> getFreeAgentMood() {
        return freeAgentMood;
    }

    public int getGamesUntilTradable() {
        return gamesUntilTradable;
    }

    public int getHgt() {
        return hgt;
    }

    public int getPtModifier() {
        return ptModifier;
    }

    public int getRosterOrder() {
        return rosterOrder;
    }

    public int getTid() {
        return tid;
    }

    public int getWeight() {
        return weight;
    }

    public int getYearsFreeAgent() {
        return yearsFreeAgent;
    }

    public int getPid() {
        return pid;
    }

    public boolean isHof() {
        return hof;
    }

    public boolean isWatch() {
        return watch;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public double getValue() {
        return value;
    }

    public double getValueNoPot() {
        return valueNoPot;
    }

    public double getValueFuzz() {
        return valueFuzz;
    }

    public double getValueNoPotFuzz() {
        return valueNoPotFuzz;
    }

    public double getValueWithContract() {
        return valueWithContract;
    }

    public List<Injury> getInjuries() {
        return injuries;
    }

    public List<PlayerStats> getStats() {
        return stats;
    }
}
