package GM;

public class RosterPlayer {
    private String df = "%.5f";
    public int games;
    public double mp, pts, fgm, fga, fgp, tpm, tpa, tpp, ftm, fta, ftp, trb, orb, drb, ast, stl, blk, to, pf, plsmns;
    public String name, pos, opp, score, wl;
    public Team team;
    public boolean playoffs;

    public RosterPlayer()
    {
    }

    public RosterPlayer(String name, String pos, double mp, double pts, double fgm, double fga, double tpm, double tpa,
                        double ftm, double fta, double orb, double drb, double ast, double stl, double blk, //double to,
                        double pf, double plsmns)
    {
        this.pts = pts;
        this.fgm = fgm;
        this.fga = fga;
        this.fgp = checkPercent(fgm, fga);
        this.tpm = tpm;
        this.tpa = tpa;
        this.tpp = checkPercent(tpm, tpa);
        this.ftm = ftm;
        this.fta = fta;
        this.ftp = checkPercent(ftm, fta);
        this.trb = orb + drb;
        this.orb = orb;
        this.drb = drb;
        this.ast = ast;
        //this.to = to;
        this.stl = stl;
        this.blk = blk;
        this.pf = pf;
        this.plsmns = plsmns;
        this.name = name;
        this.pos = pos;
        this.mp = mp;
    }

    public double checkPercent(double x, double y)
    {
        if(y == 0) {return 0;}
        else {return x / y;}
    }
    public String getName() {return this.name;}

    public String getPos() {return this.pos;}

    public double getMp() {return this.mp;}

    public String getFMP() {return String.format("%.2f", this.mp);}

    public double getPts() {return  this.pts;}

    public double getTrb() {return this.trb;}

    public double getAst() {return this.ast;}

    public double getBlk() {return this.blk;}

    public double getStl() {return this.stl;}

    public double getPf() {return this.pf;}

    public double getFgp() {return this.fgp;}

    public double getTo() {
        return to;
    }

    public String getFFGP() {return String.format(df, this.fgp);}

    public double getFtp() {return this.ftp;}

    public String getFFTP() {return String.format(df, this.ftp);}

    public double getTpp() {return this.tpp;}

    public String getFTPP() {return String.format(df, this.tpp);}
}
