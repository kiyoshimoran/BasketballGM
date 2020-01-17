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
}
