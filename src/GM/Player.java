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
    public List<Integer> freeAgentMood;
    public int gamesUntilTradable, hgt, ptModifier, rosterOrder, tid, weight, yearsFreeAgent, pid;
    public boolean hof, watch;
    public Ratings ratings;
    public List<Salary> salaries;
    public double value, valueNoPot, valueFuzz, valueNoPotFuzz, valueWithContract;
    public List<Injury> injuries;
    public List<PlayerStats> stats;

    public Player() {}

    public Player(Born born, Contract contract, Draft draft, String firstName, String lastName, List<Integer> freeAgentMood,
                  int gamesUntilTradable, int hgt, int ptModifier, int rosterOrder, int tid, int weight, int yearsFreeAgent,
                  int pid, boolean hof, boolean watch, Ratings ratings, List<Salary> salaries, double value, double valueNoPot,
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

    public List<Integer> getFreeAgentMood() {
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

    public Ratings getRatings() {
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
