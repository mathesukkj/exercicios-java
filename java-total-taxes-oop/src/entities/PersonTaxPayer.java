package entities;

public final class PersonTaxPayer extends TaxPayer {
    private double healthExpenditures;

    @Override
    public double paidTaxes() {
        if (this.getAnnualIncome() > 20000) {
            return Math.round(this.getAnnualIncome() * 0.25 - healthExpenditures * 0.5);
        }
        return Math.round(this.getAnnualIncome() * 0.15 - healthExpenditures * 0.5);
    }

    public PersonTaxPayer(String name, double annualIncome, double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

}
