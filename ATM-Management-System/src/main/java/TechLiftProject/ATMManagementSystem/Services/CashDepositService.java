package TechLiftProject.ATMManagementSystem.Services;


import TechLiftProject.ATMManagementSystem.Entities.Account;
import TechLiftProject.ATMManagementSystem.Entities.Transaction;
import TechLiftProject.ATMManagementSystem.Entities.TransactionType;
import TechLiftProject.ATMManagementSystem.Models.Login;
import TechLiftProject.ATMManagementSystem.Repositories.AccountRepository;
import TechLiftProject.ATMManagementSystem.Repositories.TransactionRepository;
import TechLiftProject.ATMManagementSystem.Repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.*;

import java.util.Objects;

@Service
public class CashDepositService {
    @Autowired
    AccountRepository accountRepository;            ;
    @Autowired
    BalanceCheckService balanceCheckService;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionTypeRepository typeRepository;
    public String cashDeposit(Long amount) {
        Login login= Login.getInstance();
        Account account = accountRepository.findAccountByCardNumber(login.getEnteredCardNumber());
        if (account == null) {
            return "Please Login to continue" ;
        } else if (!Objects.equals(account.getCardPin(), login.getEnteredCardPin())) {
            return "Please Login to continue" ;
        }
        else {
            (accountRepository.findAccountByCardNumber(login.getEnteredCardNumber())).setAvailableBalance(amount);
            accountRepository.save(accountRepository.findAccountByCardNumber(login.getEnteredCardNumber()));
        }
        Transaction transaction=new Transaction();
        transaction.setAmountProcessed(amount);
        transaction.setAccount(account);
        TransactionType transactionType=typeRepository.findTransactionTypeById(2);
        transaction.setTransactionType(transactionType );
        transactionRepository.save(transaction);
        return amount+" deposited successfully.\nNow available balance is "+balanceCheckService.getAvailableBalance();
    }
}
