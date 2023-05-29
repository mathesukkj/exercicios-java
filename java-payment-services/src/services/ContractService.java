package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double dividedValue = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(dividedValue, i);
            double fee = onlinePaymentService.paymentFee(dividedValue + interest);
            double totalQuota = dividedValue + interest + fee;

            Installment installment = new Installment(dueDate, totalQuota);

            contract.getInstallments().add(installment);
        }
    }
}
