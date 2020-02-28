package GM;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Season {

    public transient Stats  ts;
    private transient Mood mood;
    private transient Colors colors;
    public int tid, season, gp, goHome, att, won, lost, tied, wonHome, lostHome, wonAway, lostAway, tiedAway, wonDiv,
            lostDiv, tiedDiv, wonConf, lostConf, tiedConf, streak, playoffRoundsWon, stadiumCapacity;
    private transient double hype;
    public Double cash, pop;
    public List<Integer> lastTen;
    public transient Revenues revenues;
    public Expenses expenses;

    public Season() {}

    public Season(int season, int won, int lost)
    {
        this.season = season;
        this.won = won;
        this.lost = lost;
    }

    @Override
    public String toString() {
        return "" + ts +
                ", " + mood +
                ", " + colors +
                ", " + tid +
                ", " + season +
                ", " + gp +
                ", " + goHome +
                ", " + att +
                ", " + won +
                ", " + lost +
                ", " + tied +
                ", " + wonHome +
                ", " + lostHome +
                ", " + wonAway +
                ", " + lostAway +
                ", " + tiedAway +
                ", " + wonDiv +
                ", " + lostDiv +
                ", " + tiedDiv +
                ", " + wonConf +
                ", " + lostConf +
                ", " + tiedConf +
                ", " + streak +
                ", " + playoffRoundsWon +
                ", " + hype +
                ", " + stadiumCapacity +
                ", " + cash +
                ", " + pop +
                //", " + lastTen +
                //", " + revenues +
                ", " + expenses +
                ")";
    }

    public Stats getTs() {
        return ts;
    }

    public Mood getMood() {
        return mood;
    }

    public Colors getColors() {
        return colors;
    }

    public int getTid() {
        return tid;
    }

    public int getSeason() {
        return season;
    }

    public int getGp() {
        return gp;
    }

    public int getGoHome() {
        return goHome;
    }

    public int getAtt() {
        return att;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTied() {
        return tied;
    }

    public int getWonHome() {
        return wonHome;
    }

    public int getLostHome() {
        return lostHome;
    }

    public int getWonAway() {
        return wonAway;
    }

    public int getLostAway() {
        return lostAway;
    }

    public int getTiedAway() {
        return tiedAway;
    }

    public int getWonDiv() {
        return wonDiv;
    }

    public int getLostDiv() {
        return lostDiv;
    }

    public int getTiedDiv() {
        return tiedDiv;
    }

    public int getWonConf() {
        return wonConf;
    }

    public int getLostConf() {
        return lostConf;
    }

    public int getTiedConf() {
        return tiedConf;
    }

    public int getStreak() {
        return streak;
    }

    public int getPlayoffRoundsWon() {
        return playoffRoundsWon;
    }

    public int getStadiumCapacity() {
        return stadiumCapacity;
    }

    public double getHype() {
        return hype;
    }

    public Double getCash() {
        return cash;
    }

    public Double getPop() {
        return pop;
    }

    public List<Integer> getLastTen() {
        return lastTen;
    }

    public Revenues getRevenues() {
        return revenues;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }
}
