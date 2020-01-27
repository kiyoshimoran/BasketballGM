package GM;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Seasons {

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

    public Seasons() {}

    @Override
    public String toString() {
        return "Seasons{" +
                "ts=" + ts +
                ", mood=" + mood +
                ", colors=" + colors +
                ", tid=" + tid +
                ", season=" + season +
                ", gp=" + gp +
                ", goHome=" + goHome +
                ", att=" + att +
                ", won=" + won +
                ", lost=" + lost +
                ", tied=" + tied +
                ", wonHome=" + wonHome +
                ", lostHome=" + lostHome +
                ", wonAway=" + wonAway +
                ", lostAway=" + lostAway +
                ", tiedAway=" + tiedAway +
                ", wonDiv=" + wonDiv +
                ", lostDiv=" + lostDiv +
                ", tiedDiv=" + tiedDiv +
                ", wonConf=" + wonConf +
                ", lostConf=" + lostConf +
                ", tiedConf=" + tiedConf +
                ", streak=" + streak +
                ", playoffRoundsWon=" + playoffRoundsWon +
                ", hype=" + hype +
                ", stadiumCapacity=" + stadiumCapacity +
                ", cash=" + cash +
                ", pop=" + pop +
                ", lastTen=" + lastTen +
                ", revenues=" + revenues +
                ", expenses=" + expenses +
                "}\n";
    }
}
