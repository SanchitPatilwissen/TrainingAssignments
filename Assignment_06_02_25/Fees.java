package Assignment_06_02_25;

public class Fees {
    private double totalFees;
    private double feesPaid;
    private double feesPending;

    public double getTotalFees() {
        return totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getFeesPending() {
        return feesPending;
    }

    public Fees setTotalFees(double totalFees) {
        this.totalFees = totalFees;
        return this;
    }

    public Fees setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
        return this;
    }

    public Fees setFeesPending(double feesPending) {
        this.feesPending = feesPending;
        return this;
    }
}
