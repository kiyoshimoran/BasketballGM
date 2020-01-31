package GM;

public class PlayerStats {

    public boolean playoffs;
    public int season, tid, yearsWithTeam, gp, gs, fg, fga, fgAtRim, fgaAtRim, fgLowPost, fgaLowPost, fgMidRange,
            fgaMidRange, tp, tpa, ft, fta, pm, orb, drb, ast, tov, stl, blk, ba, pf, pts;
    public double per, ewa, astp, blkp, drbp, orbp, stlp, trbp, usgp, drtg, ortg, dws, ows, min;

    public PlayerStats() {}

    public PlayerStats(boolean playoffs, int season, int tid, int yearsWithTeam, int gp, int gs, int fg, int fga, int fgAtRim,
                       int fgaAtRim, int fgLowPost, int fgaLowPost, int fgMidRange, int fgaMidRange, int tp, int tpa, int ft,
                       int fta, int pm, int orb, int drb, int ast, int tov, int stl, int blk, int ba, int pf, int pts, double per,
                       double ewa, double astp, double blkp, double drbp, double orbp, double stlp, double trbp, double usgp,
                       double drtg, double ortg, double dws, double ows, double min) {
        this.playoffs = playoffs;
        this.season = season;
        this.tid = tid;
        this.yearsWithTeam = yearsWithTeam;
        this.gp = gp;
        this.gs = gs;
        this.fg = fg;
        this.fga = fga;
        this.fgAtRim = fgAtRim;
        this.fgaAtRim = fgaAtRim;
        this.fgLowPost = fgLowPost;
        this.fgaLowPost = fgaLowPost;
        this.fgMidRange = fgMidRange;
        this.fgaMidRange = fgaMidRange;
        this.tp = tp;
        this.tpa = tpa;
        this.ft = ft;
        this.fta = fta;
        this.pm = pm;
        this.orb = orb;
        this.drb = drb;
        this.ast = ast;
        this.tov = tov;
        this.stl = stl;
        this.blk = blk;
        this.ba = ba;
        this.pf = pf;
        this.pts = pts;
        this.per = per;
        this.ewa = ewa;
        this.astp = astp;
        this.blkp = blkp;
        this.drbp = drbp;
        this.orbp = orbp;
        this.stlp = stlp;
        this.trbp = trbp;
        this.usgp = usgp;
        this.drtg = drtg;
        this.ortg = ortg;
        this.dws = dws;
        this.ows = ows;
        this.min = min;
    }

    public boolean isPlayoffs() {
        return playoffs;
    }

    public int getSeason() {
        return season;
    }

    public int getTid() {
        return tid;
    }

    public int getYearsWithTeam() {
        return yearsWithTeam;
    }

    public int getGp() {
        return gp;
    }

    public int getGs() {
        return gs;
    }

    public int getFg() {
        return fg;
    }

    public int getFga() {
        return fga;
    }

    public int getFgAtRim() {
        return fgAtRim;
    }

    public int getFgaAtRim() {
        return fgaAtRim;
    }

    public int getFgLowPost() {
        return fgLowPost;
    }

    public int getFgaLowPost() {
        return fgaLowPost;
    }

    public int getFgMidRange() {
        return fgMidRange;
    }

    public int getFgaMidRange() {
        return fgaMidRange;
    }

    public int getTp() {
        return tp;
    }

    public int getTpa() {
        return tpa;
    }

    public int getFt() {
        return ft;
    }

    public int getFta() {
        return fta;
    }

    public int getPm() {
        return pm;
    }

    public int getOrb() {
        return orb;
    }

    public int getDrb() {
        return drb;
    }

    public int getAst() {
        return ast;
    }

    public int getTov() {
        return tov;
    }

    public int getStl() {
        return stl;
    }

    public int getBlk() {
        return blk;
    }

    public int getBa() {
        return ba;
    }

    public int getPf() {
        return pf;
    }

    public int getPts() {
        return pts;
    }

    public double getPer() {
        return per;
    }

    public double getEwa() {
        return ewa;
    }

    public double getAstp() {
        return astp;
    }

    public double getBlkp() {
        return blkp;
    }

    public double getDrbp() {
        return drbp;
    }

    public double getOrbp() {
        return orbp;
    }

    public double getStlp() {
        return stlp;
    }

    public double getTrbp() {
        return trbp;
    }

    public double getUsgp() {
        return usgp;
    }

    public double getDrtg() {
        return drtg;
    }

    public double getOrtg() {
        return ortg;
    }

    public double getDws() {
        return dws;
    }

    public double getOws() {
        return ows;
    }

    public double getMin() {
        return min;
    }
}
