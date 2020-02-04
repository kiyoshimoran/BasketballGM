package GM;

public class Salary {

    public int season;
    public double amount;

    public Salary() {
    }

    public Salary(int season, double amount) {
        this.season = season;
        this.amount = amount;
    }

    public String toSQL() {
        return Double.toString(amount);
    }

    public int getSeason() {
        return season;
    }

    public double getAmount() {
        return amount;
    }
}
