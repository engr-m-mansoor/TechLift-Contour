package TechLiftProject.ATMManagementSystem.Services;

import TechLiftProject.ATMManagementSystem.Models.ModelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashDepositService {
    @Autowired
    AccountDataService accountDataService;
    @Autowired
    TransactionService transactionService;
    ModelData modelData;


    public String cashDeposit(Long amount) {
        if (accountDataService.getAccountData() == null) {
            System.out.println("Please Login to continue");
        } else {
            accountDataService.findById();
            accountDataService.getAccountData().setAvailableBalance(accountDataService.getAccountData().getAvailableBalance() + amount);
            accountDataService.updateAccountData();
            transactionService.recordTransaction(amount, 3);
            return amount + " deposited successfully.Available Balance = " + modelData.getModelAvailableBalance();
        }
        return null;
    }}

