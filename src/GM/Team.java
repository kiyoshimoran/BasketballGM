package GM;

import java.util.HashMap;
import GM.*;

public class Team {
    public HashMap<String, RosterPlayer> Roster;
    public int season, wins, losses;
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

    /*public HashMap<String, GM.RosterPlayer> getRoster() {
        return Roster;
    }

    public void setRoster(HashMap<String, GM.RosterPlayer> roster) {
        this.Roster = roster;
    }*/

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public double getSalary_cap() {
        return salary_cap;
    }

    public void setSalary_cap(double salary_cap) {
        this.salary_cap = salary_cap;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public double getLux_tax() {
        return lux_tax;
    }

    public void setLux_tax(double lux_tax) {
        this.lux_tax = lux_tax;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getTicket() {
        return ticket;
    }

    public void setTicket(double ticket) {
        this.ticket = ticket;
    }

    public double getScouting() {
        return scouting;
    }

    public void setScouting(double scouting) {
        this.scouting = scouting;
    }

    public double getCoaching() {
        return coaching;
    }

    public void setCoaching(double coaching) {
        this.coaching = coaching;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getFacilites() {
        return facilites;
    }

    public void setFacilites(double facilites) {
        this.facilites = facilites;
    }
}
