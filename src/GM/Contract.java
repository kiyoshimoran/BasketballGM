package GM;

public class Contract {

    public double amount;
    public int exp;

    public Contract(double amount, int exp) {
        this.amount = amount;
        this.exp = exp;
    }

    public Contract() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
