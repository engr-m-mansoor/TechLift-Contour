package TechLiftProject.ATMManagementSystem.Services;

import TechLiftProject.ATMManagementSystem.Models.Login;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UpdatePinService {
    @Autowired
    AccountDataService accountDataService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    LoginService loginService;
    Login login;
    public String updatePin(int pin) {
        accountDataService.passToAccountData();
        if (accountDataService.getAccountData() == null) {
            return("Please Login to continue");
        }
        else if (pin == accountDataService.getAccountData().getCardPin())
        {
            return("Pin already exists");
        }

        else
        {
            accountDataService.getAccountData().setCardPin(pin);
            accountDataService.updateAccountData();
            transactionService.recordTransaction(0L,4);
            loginService.exit();
            return "Pin updated successfully";
        }
    }}

