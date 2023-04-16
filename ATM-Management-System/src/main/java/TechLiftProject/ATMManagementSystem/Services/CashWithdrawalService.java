package TechLiftProject.ATMManagementSystem.Services;



import TechLiftProject.ATMManagementSystem.Models.Login;
import TechLiftProject.ATMManagementSystem.Models.ModelData;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CashWithdrawalService {
    @Autowired
    AccountDataService accountDataService;
    @Autowired
    TransactionService transactionService;
    ModelData modelData;
    Login login= Login.getInstance();

    public String cashWithdraw(Long amount) {
            accountDataService.passToAccountData();
        if (accountDataService.getAccountData() == null) {
            return("Please Login to continue");
        }
        else if (amount>accountDataService.getAccountData().getAvailableBalance()) {
            return "Not enough funds";
        }
        else if (amount>25000) {
            return "Withdrawal Limit exceeds for one transaction";
        }
        else
        {

            accountDataService.getAccountData().setAvailableBalance(accountDataService.getAccountData().getAvailableBalance()-amount);
            accountDataService.updateAccountData();
            transactionService.recordTransaction(amount, 1);
            return amount+" withdrawan successfully";
        }
    }
}

