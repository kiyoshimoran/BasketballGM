package GM;

public class Health {

    public Double amount;
    public int rank;

    public Health() {}

    public Health(Double amount, int rank) {
        this.amount = amount;
        this.rank = rank;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
