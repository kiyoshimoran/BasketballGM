package GM;

import java.util.List;

public class Ratings {

    public int stre, spd, jmp, endu, ins, dnk, ft, fg, tp, oiq, diq, drb, pss, reb, hgt, orv, pot, season;
    public String pos;
    public double fuzz;
    List<Skills> skills;

    public Ratings() {
    }

    public Ratings(int stre, int spd, int jmp, int endu, int ins, int dnk, int ft, int fg, int tp, int oiq, int diq, int drb, int pss, int reb, int hgt, int orv, int pot, int season, String pos, double fuzz) {
        this.stre = stre;
        this.spd = spd;
        this.jmp = jmp;
        this.endu = endu;
        this.ins = ins;
        this.dnk = dnk;
        this.ft = ft;
        this.fg = fg;
        this.tp = tp;
        this.oiq = oiq;
        this.diq = diq;
        this.drb = drb;
        this.pss = pss;
        this.reb = reb;
        this.hgt = hgt;
        this.orv = orv;
        this.pot = pot;
        this.season = season;
        this.pos = pos;
        this.fuzz = fuzz;
    }

    public int getStre() {
        return stre;
    }

    public int getSpd() {
        return spd;
    }

    public int getJmp() {
        return jmp;
    }

    public int getEndu() {
        return endu;
    }

    public int getIns() {
        return ins;
    }

    public int getDnk() {
        return dnk;
    }

    public int getFt() {
        return ft;
    }

    public int getFg() {
        return fg;
    }

    public int getTp() {
        return tp;
    }

    public int getOiq() {
        return oiq;
    }

    public int getDiq() {
        return diq;
    }

    public int getDrb() {
        return drb;
    }

    public int getPss() {
        return pss;
    }

    public int getReb() {
        return reb;
    }

    public int getHgt() {
        return hgt;
    }

    public int getOrv() {
        return orv;
    }

    public int getPot() {
        return pot;
    }

    public int getSeason() {
        return season;
    }

    public String getPos() {
        return pos;
    }

    public double getFuzz() {
        return fuzz;
    }
}
