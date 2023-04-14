package TechLiftProject.ATMManagementSystem.Controllers;

import TechLiftProject.ATMManagementSystem.Services.CashDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashDepositController {
    @Autowired
    CashDepositService cashDepositService;
    @PutMapping("/atm-deposit-cash/{amount}")
    public String cashDeposit(@PathVariable("amount") Long amount)
    {
        return cashDepositService.cashDeposit(amount);

    }

}
