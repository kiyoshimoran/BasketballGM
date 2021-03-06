package GM;

public class RankedAttribute {

    public double amount;
    public int rank;

    public RankedAttribute() {}

    public RankedAttribute(double amount, int rank) {
        this.amount = amount;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "RankedAttribute{" +
                "amount=" + amount +
                ", rank=" + rank +
                '}';
    }

    public double getAmount() {
        return amount;
    }

    public int getRank() {
        return rank;
    }
}
