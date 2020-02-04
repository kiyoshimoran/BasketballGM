package GM;

import java.util.List;

public class Draft {

    public int round, pick, tid, year, originalTid, pot, ovr;
    public List<String> skills;

    public Draft(int round, int pick, int tid, int year, int originalTid, int pot, int ovr) {
        this.round = round;
        this.pick = pick;
        this.tid = tid;
        this.year = year;
        this.originalTid = originalTid;
        this.pot = pot;
        this.ovr = ovr;
    }

    public Draft() {
    }

    public String toSQL() {
        return ", " + round +
                ", " + pick +
                ", " + tid +
                ", " + year +
                ", " + originalTid +
                ", " + pot +
                ", " + ovr;
                //", " + skills;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getPick() {
        return pick;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOriginalTid() {
        return originalTid;
    }

    public void setOriginalTid(int originalTid) {
        this.originalTid = originalTid;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getOvr() {
        return ovr;
    }

    public void setOvr(int ovr) {
        this.ovr = ovr;
    }
}
