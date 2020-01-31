package GM;

public class PlayerAvg {

    public String firstName, lastName;
    public int pid;
    public double mins, pts, fga, fgm, fgp, tpa, tpm, tpp, fta, ftm, ftp, orb, drb, trb, ast, stl, blk, tov, pf;

    public PlayerAvg() {}

    public PlayerAvg(String firstName, String lastName, int pid, double mins, double pts, double fga, double fgm, double fgp,
                     double tpa, double tpm, double tpp, double fta, double ftm, double ftp, double orb, double drb, double trb,
                     double ast, double stl, double blk, double tov, double pf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.mins = mins;
        this.pts = pts;
        this.fga = fga;
        this.fgm = fgm;
        this.fgp = fgp;
        this.tpa = tpa;
        this.tpm = tpm;
        this.tpp = tpp;
        this.fta = fta;
        this.ftm = ftm;
        this.ftp = ftp;
        this.orb = orb;
        this.drb = drb;
        this.trb = trb;
        this.ast = ast;
        this.stl = stl;
        this.blk = blk;
        this.tov = tov;
        this.pf = pf;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPid() {
        return pid;
    }

    public double getMins() {
        return mins;
    }

    public double getPts() {
        return pts;
    }

    public double getFga() {
        return fga;
    }

    public double getFgm() {
        return fgm;
    }

    public double getFgp() {
        return fgp;
    }

    public double getTpa() {
        return tpa;
    }

    public double getTpm() {
        return tpm;
    }

    public double getTpp() {
        return tpp;
    }

    public double getFta() {
        return fta;
    }

    public double getFtm() {
        return ftm;
    }

    public double getFtp() {
        return ftp;
    }

    public double getOrb() {
        return orb;
    }

    public double getDrb() {
        return drb;
    }

    public double getTrb() {
        return trb;
    }

    public double getAst() {
        return ast;
    }

    public double getStl() {
        return stl;
    }

    public double getBlk() {
        return blk;
    }

    public double getTov() {
        return tov;
    }

    public double getPf() {
        return pf;
    }
}
