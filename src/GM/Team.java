package GM;

import java.util.HashMap;
import GM.Player;

public class Team {
    public HashMap<String, Player> Roster;
    public int wins, losses;
    public double salary_cap, payroll, lux_tax, profit, ticket, scouting, coaching, health, facilites;

    public Team() {}

    public Team(HashMap r, int wins, int losses, double salary_cap, double payroll, double lux_tax, double profit, double ticket, double scouting, double coaching, double health, double facilites)
    {
        this.Roster = r;
        this.wins = wins;
        this.losses = losses;
        this.salary_cap = salary_cap;
        this.payroll = payroll;
        this.lux_tax = lux_tax;
        this.profit = profit;
        this.ticket = ticket;
        this.scouting = scouting;
        this.coaching = coaching;
        this.health = health;
        this.facilites = facilites;
    }

    public HashMap getRoster() {return Roster;}
    public void setRoster(HashMap roster) {this.Roster = roster;}
    public int getWins() {return wins;}
    public void setWins(int wins) {this.wins = wins;}
    public int getLosses() {return losses;}
    public void setLosses(int losses) {this.losses = losses;}
}
