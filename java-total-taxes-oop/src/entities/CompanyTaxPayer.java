package entities;

public final class CompanyTaxPayer extends TaxPayer {
    private int employeeQuantity;

    @Override
    public double paidTaxes() {
        if (employeeQuantity > 10) {
            return Math.round(this.getAnnualIncome() * 0.14);
        }
        return Math.round(this.getAnnualIncome() * 0.16);
    }

    public CompanyTaxPayer(String name, double annualIncome, int employeeQuantity) {
        super(name, annualIncome);
        this.employeeQuantity = employeeQuantity;
    }

    public int getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(int employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }
}
