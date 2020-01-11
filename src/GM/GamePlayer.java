package GM;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;

public class GamePlayer {
    public int stre, spd, jmp, endu, ins, dnk, ft, tp, oiq, diq, drb, pss, reb, hgt, ovr,  pot, season, salary;
    public double fuzz;
    public String firstName, lastName, pos;
    public Team team;
    public boolean playoffs;
    public ArrayList<String> skills;

    public GamePlayer()
    {
    }

    public GamePlayer(String firstName, String lastName, int stre, int spd, int jmp, int endu, int ins, int dnk, int ft,
                      int tp, int oiq, int diq, int drb, int pss, int reb, int hgt, double fuzz, int ovr, String pos,
                      int pot, int season, int salary, ArrayList<String> skills, Team team)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stre = stre;
        this.season = season;
        this.spd = spd;
        this.jmp = jmp;
        this.endu = endu;
        this.ins = ins;
        this.dnk = dnk;
        this.ft = ft;
        this.tp = tp;
        this.oiq = oiq;
        this.diq = diq;
        this.drb = drb;
        this.pss = pss;
        this.reb = reb;
        this.hgt = hgt;
        this.fuzz = fuzz;
        this.ovr = ovr;
        this.pot = pot;
        this.season = season;
        this.salary = salary;
        this.team = team;
        this.skills = skills;
    }

    public int getStre() {
        return stre;
    }

    public void setStre(int stre) {
        this.stre = stre;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getJmp() {
        return jmp;
    }

    public void setJmp(int jmp) {
        this.jmp = jmp;
    }

    public int getEndu() {
        return endu;
    }

    public void setEndu(int endu) {
        this.endu = endu;
    }

    public int getIns() {
        return ins;
    }

    public void setIns(int ins) {
        this.ins = ins;
    }

    public int getDnk() {
        return dnk;
    }

    public void setDnk(int dnk) {
        this.dnk = dnk;
    }

    public int getFt() {
        return ft;
    }

    public void setFt(int ft) {
        this.ft = ft;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getOiq() {
        return oiq;
    }

    public void setOiq(int oiq) {
        this.oiq = oiq;
    }

    public int getDiq() {
        return diq;
    }

    public void setDiq(int diq) {
        this.diq = diq;
    }

    public int getDrb() {
        return drb;
    }

    public void setDrb(int drb) {
        this.drb = drb;
    }

    public int getPss() {
        return pss;
    }

    public void setPss(int pss) {
        this.pss = pss;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }

    public int getHgt() {
        return hgt;
    }

    public void setHgt(int hgt) {
        this.hgt = hgt;
    }

    public int getOvr() {
        return ovr;
    }

    public void setOvr(int ovr) {
        this.ovr = ovr;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getSalary()  {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getFuzz() {
        return fuzz;
    }

    public void setFuzz(double fuzz) {
        this.fuzz = fuzz;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isPlayoffs() {
        return playoffs;
    }

    public void setPlayoffs(boolean playoffs) {
        this.playoffs = playoffs;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
