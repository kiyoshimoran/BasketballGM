package GM;

public class Stats {

    public int gs, fg, fga, fgAtRim, fgaAtRim, fgLowPost, fgaLowPost, fgMidRange, fgaMidRange, tp, tpa, ft, fta, pm,
            orb, drb, ast, tov, stl, blk, ba, pf, pts;
    public Double min, courtTime, benchTime, energy;

    public Stats() {}

    public Stats(int gs, int fg, int fga, int fgAtRim, int fgaAtRim, int fgLowPost, int fgaLowPost, int fgMidRange,
                 int fgaMidRange, int tp, int tpa, int ft, int fta, int pm, int orb, int drb, int ast, int tov, int stl,
                 int blk, int ba, int pf, int pts, Double min, Double courtTime, Double benchTime, Double energy) {
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
        this.min = min;
        this.courtTime = courtTime;
        this.benchTime = benchTime;
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "gs=" + gs +
                ", fg=" + fg +
                ", fga=" + fga +
                ", fgAtRim=" + fgAtRim +
                ", fgaAtRim=" + fgaAtRim +
                ", fgLowPost=" + fgLowPost +
                ", fgaLowPost=" + fgaLowPost +
                ", fgMidRange=" + fgMidRange +
                ", fgaMidRange=" + fgaMidRange +
                ", tp=" + tp +
                ", tpa=" + tpa +
                ", ft=" + ft +
                ", fta=" + fta +
                ", pm=" + pm +
                ", orb=" + orb +
                ", drb=" + drb +
                ", ast=" + ast +
                ", tov=" + tov +
                ", stl=" + stl +
                ", blk=" + blk +
                ", ba=" + ba +
                ", pf=" + pf +
                ", pts=" + pts +
                ", min=" + min +
                ", courtTime=" + courtTime +
                ", benchTime=" + benchTime +
                ", energy=" + energy +
                '}';
    }

    public int getGs() {
        return gs;
    }

    public void setGs(int gs) {
        this.gs = gs;
    }

    public int getFg() {
        return fg;
    }

    public void setFg(int fg) {
        this.fg = fg;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public int getFgAtRim() {
        return fgAtRim;
    }

    public void setFgAtRim(int fgAtRim) {
        this.fgAtRim = fgAtRim;
    }

    public int getFgaAtRim() {
        return fgaAtRim;
    }

    public void setFgaAtRim(int fgaAtRim) {
        this.fgaAtRim = fgaAtRim;
    }

    public int getFgLowPost() {
        return fgLowPost;
    }

    public void setFgLowPost(int fgLowPost) {
        this.fgLowPost = fgLowPost;
    }

    public int getFgaLowPost() {
        return fgaLowPost;
    }

    public void setFgaLowPost(int fgaLowPost) {
        this.fgaLowPost = fgaLowPost;
    }

    public int getFgMidRange() {
        return fgMidRange;
    }

    public void setFgMidRange(int fgMidRange) {
        this.fgMidRange = fgMidRange;
    }

    public int getFgaMidRange() {
        return fgaMidRange;
    }

    public void setFgaMidRange(int fgaMidRange) {
        this.fgaMidRange = fgaMidRange;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getTpa() {
        return tpa;
    }

    public void setTpa(int tpa) {
        this.tpa = tpa;
    }

    public int getFt() {
        return ft;
    }

    public void setFt(int ft) {
        this.ft = ft;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public int getOrb() {
        return orb;
    }

    public void setOrb(int orb) {
        this.orb = orb;
    }

    public int getDrb() {
        return drb;
    }

    public void setDrb(int drb) {
        this.drb = drb;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getTov() {
        return tov;
    }

    public void setTov(int tov) {
        this.tov = tov;
    }

    public int getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }

    public int getBlk() {
        return blk;
    }

    public void setBlk(int blk) {
        this.blk = blk;
    }

    public int getBa() {
        return ba;
    }

    public void setBa(int ba) {
        this.ba = ba;
    }

    public int getPf() {
        return pf;
    }

    public void setPf(int pf) {
        this.pf = pf;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getCourtTime() {
        return courtTime;
    }

    public void setCourtTime(Double courtTime) {
        this.courtTime = courtTime;
    }

    public Double getBenchTime() {
        return benchTime;
    }

    public void setBenchTime(Double benchTime) {
        this.benchTime = benchTime;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }
}
