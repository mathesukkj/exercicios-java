package entities;

public abstract class TaxPayer {
    private String name;
    private double annualIncome;

    public TaxPayer(String name, double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public abstract double paidTaxes();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    @Override
    public String toString() {
        return name + ": $" + this.paidTaxes();
    }

}
