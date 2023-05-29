import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.CompanyTaxPayer;
import entities.PersonTaxPayer;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of tax payers: ");
        int n = s.nextInt();

        List<TaxPayer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Tax payer #" + (i + 1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            String ch = s.next().toLowerCase();
            System.out.print("Name: ");
            String name = s.next();
            System.out.print("Annual income: ");
            double annualIncome = s.nextDouble();

            if (ch.equals("i")) {
                System.out.print("Health expenditures: ");
                double healthExpenditures = s.nextDouble();
                list.add(new PersonTaxPayer(name, annualIncome, healthExpenditures));
            } else if (ch.equals("c")) {
                System.out.print("Number of employees: ");
                int employeeQuantity = s.nextInt();
                list.add(new CompanyTaxPayer(name, annualIncome, employeeQuantity));
            } else {
                System.out.println("ERROR!");
            }
        }
        s.close();

        System.out.println("\nTAXES PAID: ");
        double totalTaxes = 0;
        for (TaxPayer taxPayer : list) {
            System.out.println(taxPayer);
            totalTaxes += taxPayer.paidTaxes();
        }
        System.out.println("\nTOTAL TAXES: $" + totalTaxes);
    }
}
