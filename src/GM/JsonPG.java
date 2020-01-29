package GM;

import java.util.*;

public class JsonPG {
    public int pid, season, tid, oppTid, gid, overtimes, fid;
    public String name, pos, score;
    public boolean playoffs, won;
    public List<Stats> stats;

    public JsonPG()  {};

    public JsonPG(int pid, int season, int tid, int oppTid, int gid, int overtimes, int fid, String name, String pos, String score, boolean playoffs, boolean won, List<Stats> stats) {
        this.pid = pid;
        this.season = season;
        this.tid = tid;
        this.oppTid = oppTid;
        this.gid = gid;
        this.overtimes = overtimes;
        this.fid = fid;
        this.name = name;
        this.pos = pos;
        this.score = score;
        this.playoffs = playoffs;
        this.won = won;
        this.stats = stats;
    }

    public int getPid() {

        return pid;
    }

    @Override
    public String toString() {
        return "(" + pid +
                ", " + season +
                ", " + tid +
                ", " + oppTid +
                ", " + gid +
                ", " + overtimes +
                ", " + fid +
                ", '" + name + '\'' +
                ", '" + pos + '\'' +
                ", '" + score + '\'' +
                ", " + playoffs +
                ", " + won +
                ", " + stats +
                ")";
    }

    /*
    @Override
    public String toString() {
        return "JsonPG{" +
                "pid=" + pid +
                ", season=" + season +
                ", tid=" + tid +
                ", oppTid=" + oppTid +
                ", gid=" + gid +
                ", overtimes=" + overtimes +
                ", fid=" + fid +
                ", name='" + name + '\'' +
                ", pos='" + pos + '\'' +
                ", score='" + score + '\'' +
                ", playoffs=" + playoffs +
                ", won=" + won +
                ", stats=" + stats +
                "}\n";
    }*/

    public String toSQLStatement() {
        return  " ('" + name + '\'' +
                ", " + season +
                ", " + pid +
                ", " + tid +
                ", " + gid +
                /*", " + oppTid +
                ", " + overtimes +
                ", " + fid +
                ", '" + name + '\'' +
                ", '" + pos + '\'' +
                ", '" + score + '\'' +
                ", " + playoffs +
                ", " + won +
                ", " + stats +*/
                ")";
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getOppTid() {
        return oppTid;
    }

    public void setOppTid(int oppTid) {
        this.oppTid = oppTid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getOvertimes() {
        return overtimes;
    }

    public void setOvertimes(int overtimes) {
        this.overtimes = overtimes;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public boolean isPlayoffs() {
        return playoffs;
    }

    public void setPlayoffs(boolean playoffs) {
        this.playoffs = playoffs;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }
}
