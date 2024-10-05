package models;

public class Transaction {
    private double amount;
    private String date;
    private String status;

    public Transaction(double amount, String date, String status) {
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Transaction[amount=" + amount + ", date=" + date + ", status=" + status + "]";
    }
}
