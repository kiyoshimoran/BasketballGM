package GM;

public class GamePlayer {
    public int pid, season, fgm, fga, tpm, tpa, ftm, fta, orb, drb, ast, to, stl, blk, pf, plsmns;
    public String name, pos, opp, score, wl;
    public Team team;
    public boolean playoffs;
    double mp;

    public GamePlayer()
    {
    }

    public GamePlayer(int pid, int season, int fgm, int fga, int tpm, int tpa, int ftm, int fta, int orb, int drb, int ast, int to, int stl, int blk, int pf,
                      int plsmns, String name, String pos, String opp, String score, String wl, Boolean playoffs, double mp)
    {
        this.pid = pid;
        this.season = season;
        this.fgm = fgm;
        this.fga = fga;
        this.tpm = tpm;
        this.tpa = tpa;
        this.ftm = ftm;
        this.fta = fta;
        this.orb = orb;
        this.drb = drb;
        this.ast = ast;
        this.to = to;
        this.stl = stl;
        this.blk = blk;
        this.pf = pf;
        this.plsmns = plsmns;
        this.name = name;
        this.pos = pos;
        this.opp = opp;
        this.score = score;
        this.wl = wl;
        this.playoffs = playoffs;
        this.mp = mp;
    }

}
