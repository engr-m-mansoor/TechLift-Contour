package TechLiftProject.ATMManagementSystem.Services;

import TechLiftProject.ATMManagementSystem.Entities.Account;
import TechLiftProject.ATMManagementSystem.Entities.Transaction;
import TechLiftProject.ATMManagementSystem.Entities.TransactionType;
import TechLiftProject.ATMManagementSystem.Models.Login;
import TechLiftProject.ATMManagementSystem.Repositories.AccountRepository;
import TechLiftProject.ATMManagementSystem.Repositories.TransactionRepository;
import TechLiftProject.ATMManagementSystem.Repositories.TransactionTypeRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UpdatePinService {
    @Autowired
    BalanceCheckService balanceCheckService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionTypeRepository typeRepository;

    public String updatePin(int pin)
    {
        Login login= Login.getInstance();
        Account account = accountRepository.findAccountByCardNumber(login.getEnteredCardNumber());
        if (account == null) {
            return "Please Login to continue" ;
        } else if (!Objects.equals(account.getCardPin(), login.getEnteredCardPin())) {
            return "Please Login to continue" ;
        }
        else {
            (accountRepository.findAccountByCardNumber(login.getEnteredCardNumber())).setCardPin(pin);
            accountRepository.save(accountRepository.findAccountByCardNumber(login.getEnteredCardNumber()));
        }
        Transaction transaction=new Transaction();
        transaction.setAmountProcessed(0L);
        transaction.setAccount(account);
        TransactionType transactionType=typeRepository.findTransactionTypeById(4);
        transaction.setTransactionType(transactionType );
        return "Pin updated successfully";
    }
}

