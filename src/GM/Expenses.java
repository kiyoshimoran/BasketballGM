package GM;

public class Expenses {

    public RankedAttribute Salary, LuxuryTax, MinTax, Scouting, Coaching, Health, Facilities;

    public Expenses() {}

    public Expenses(RankedAttribute salary, RankedAttribute luxuryTax, RankedAttribute minTax, RankedAttribute scouting,
                    RankedAttribute coaching, RankedAttribute health, RankedAttribute facilities) {
        Salary = salary;
        LuxuryTax = luxuryTax;
        MinTax = minTax;
        Scouting = scouting;
        Coaching = coaching;
        Health = health;
        Facilities = facilities;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "Salary=" + Salary +
                ", LuxuryTax=" + LuxuryTax +
                ", MinTax=" + MinTax +
                ", Scouting=" + Scouting +
                ", Coaching=" + Coaching +
                ", Health=" + Health +
                ", Facilities=" + Facilities +
                '}';
    }

    public RankedAttribute getSalary() {
        return Salary;
    }

    public RankedAttribute getLuxuryTax() {
        return LuxuryTax;
    }

    public RankedAttribute getMinTax() {
        return MinTax;
    }

    public RankedAttribute getScouting() {
        return Scouting;
    }

    public RankedAttribute getCoaching() {
        return Coaching;
    }

    public RankedAttribute getHealth() {
        return Health;
    }

    public RankedAttribute getFacilities() {
        return Facilities;
    }
}
