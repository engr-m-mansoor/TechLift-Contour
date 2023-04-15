package TechLiftProject.ATMManagementSystem.Services;

import TechLiftProject.ATMManagementSystem.Models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePinService {
    @Autowired
    AccountDataService accountDataService;
    @Autowired
    TransactionService transactionService;
    Login login;
    public String updatePin(int pin) {
        if (accountDataService.getAccountData() == null) {
            System.out.println("Please Login to continue");
        } else {
            accountDataService.findById();
            accountDataService.getAccountData().setCardPin(pin);
            accountDataService.updateAccountData();
            transactionService.recordTransaction(0L, 3);
            return pin+" updated successfully";
        }
        return null;
    }}

