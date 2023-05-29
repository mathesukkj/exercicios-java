import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;
import services.ContractService;
import services.PaypalService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the contract data: ");
        System.out.print("Number: ");
        int contractNumber = s.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Contract price: ");
        double contractPrice = s.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractPrice);

        System.out.print("Enter the number of installments: ");
        int installmentsNumber = s.nextInt();

        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, installmentsNumber);

        System.out.println("Installments: ");
        for (int i = 0; i < contract.getInstallments().size(); i++) {
            System.out.println(contract.getInstallments().get(i));
        }

        s.close();
    }
}
