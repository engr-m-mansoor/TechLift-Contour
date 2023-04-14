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
    public String authenticateLogin(Long modelCardNumber, Long modelCardPin) {

        Account account = accountRepository.findAccountByCardNumber(modelCardNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found" );
        } else if (!Objects.equals(account.getCardPin(), modelCardPin)){
            throw new IllegalArgumentException("Wrong Pin ");
        }
        else
        {
            Login login = Login.getInstance();
            login.setEnteredCardNumber(modelCardNumber);
            login.setEnteredCardPin(modelCardPin);
            return "Welcome you are Logged in";
        }

    }
}
