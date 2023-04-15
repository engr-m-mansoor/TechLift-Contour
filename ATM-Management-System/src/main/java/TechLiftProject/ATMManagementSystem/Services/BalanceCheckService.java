package TechLiftProject.ATMManagementSystem.Services;


import TechLiftProject.ATMManagementSystem.Models.ModelData;
import TechLiftProject.ATMManagementSystem.Repositories.AccountRepository;
import TechLiftProject.ATMManagementSystem.Repositories.TransactionRepository;
import TechLiftProject.ATMManagementSystem.Repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BalanceCheckService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionTypeRepository typeRepository;
    @Autowired
    TransactionService transactionService;
    @Autowired
    AccountDataService accountDataService;
    ModelData modelData;

    public String getAvailableBalance() {
        if(accountDataService.getAccountData()==null) {
        System.out.println("Please Login to continue");
        }
        else {
            accountDataService.findById();
            modelData = new ModelData(accountDataService.getAccountData().getAvailableBalance());

            transactionService.recordTransaction(0L, 3);
            return "Available Balance = " + modelData.getModelAvailableBalance();
        }
        return null;
    }
}