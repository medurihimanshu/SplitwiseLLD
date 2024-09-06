package models;

public class Expense {
    private double amount;

    public Expense() {
        this.amount = 0.0;
    }
    public Expense(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
