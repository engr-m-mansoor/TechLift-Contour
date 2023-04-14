package TechLiftProject.ATMManagementSystem.Services;

import TechLiftProject.ATMManagementSystem.Entities.Account;
import TechLiftProject.ATMManagementSystem.Entities.Transaction;
import TechLiftProject.ATMManagementSystem.Entities.TransactionType;
import TechLiftProject.ATMManagementSystem.Models.Login;
import TechLiftProject.ATMManagementSystem.Models.ModelData;
import TechLiftProject.ATMManagementSystem.Repositories.AccountRepository;
import TechLiftProject.ATMManagementSystem.Repositories.TransactionRepository;
import TechLiftProject.ATMManagementSystem.Repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BalanceCheckService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionTypeRepository typeRepository;

    public String getAvailableBalance() {

        Login login= Login.getInstance();
        Account account = accountRepository.findAccountByCardNumber(login.getEnteredCardNumber());
        if (account == null) {
            return "Please Login to continue";
        } else if (!Objects.equals(account.getCardPin(), login.getEnteredCardPin())) {
            return "Please Login to continue";
        }
        else
        {
            ModelData modelData = new ModelData(account);
            Transaction transaction=new Transaction();
            transaction.setAmountProcessed(0L);
            transaction.setAccount(account);
            TransactionType transactionType=typeRepository.findTransactionTypeById(3);
            transaction.setTransactionType(transactionType );
            transactionRepository.save(transaction);
            return "Available Balance = " +modelData.getModelAvailableBalance();
        }
    }
}