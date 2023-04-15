package TechLiftProject.ATMManagementSystem.Services;


import TechLiftProject.ATMManagementSystem.Entities.Account;
import TechLiftProject.ATMManagementSystem.Models.Login;
import TechLiftProject.ATMManagementSystem.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    @Autowired
    AccountRepository accountRepository;
    Account account;
    Login login;
    public String authenticateLogin(Long modelCardNumber, Long modelCardPin) {
        account = accountRepository.findAccountByCardNumber(modelCardNumber);
        if (account == null) {
           System.out.println("Account not found");
        } else if (!Objects.equals(account.getCardPin(), modelCardPin)){
            System.out.println("Wrong Pin ");
        }
        else
        {
            login = Login.getInstance();
            login.setEnteredCardNumber(modelCardNumber);
            login.setEnteredCardPin(modelCardPin);
            login.setAccountNumber(account.getAccountNumber());
            return "Welcome you are Logged in";
        }
        return null;
    }
}
