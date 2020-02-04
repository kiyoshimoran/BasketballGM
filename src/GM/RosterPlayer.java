package GM;

public class RosterPlayer {
    private String df = "%.5f";
    public int games, tid;
    public double mp, pts, fgm, fga, fgp, tpm, tpa, tpp, ftm, fta, ftp, trb, orb, drb, ast, stl, blk, to, pf, plsmns;
    public String name, pos, opp, score, wl, abbrev;
    public Team team;
    public boolean playoffs;

    public RosterPlayer()
    {
    }

    public RosterPlayer(String name, String pos, String abbrev, double mp, double pts, double fgm, double fga, double tpm, double tpa,
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
        this.tid = tid;
        this.abbrev = abbrev;
    }

    public double checkPercent(double x, double y)
    {
        if(y == 0) {return 0;}
        else {return x / y;}
    }

    @Override
    public String toString() {
        return "RosterPlayer{" +
                "df='" + df + '\'' +
                ", games=" + games +
                ", mp=" + mp +
                ", pts=" + pts +
                ", fgm=" + fgm +
                ", fga=" + fga +
                ", fgp=" + fgp +
                ", tpm=" + tpm +
                ", tpa=" + tpa +
                ", tpp=" + tpp +
                ", ftm=" + ftm +
                ", fta=" + fta +
                ", ftp=" + ftp +
                ", trb=" + trb +
                ", orb=" + orb +
                ", drb=" + drb +
                ", ast=" + ast +
                ", stl=" + stl +
                ", blk=" + blk +
                ", to=" + to +
                ", pf=" + pf +
                ", plsmns=" + plsmns +
                ", name='" + name + '\'' +
                ", pos='" + pos + '\'' +
                ", opp='" + opp + '\'' +
                ", score='" + score + '\'' +
                ", wl='" + wl + '\'' +
                ", team=" + team +
                ", playoffs=" + playoffs +
                '}';
    }

    public String getAbbrev() {return abbrev;}

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
