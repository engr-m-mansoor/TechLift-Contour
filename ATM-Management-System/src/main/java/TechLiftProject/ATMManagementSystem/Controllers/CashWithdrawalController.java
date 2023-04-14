package TechLiftProject.ATMManagementSystem.Controllers;

import TechLiftProject.ATMManagementSystem.Services.BalanceCheckService;
import TechLiftProject.ATMManagementSystem.Services.CashWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashWithdrawalController {
    @Autowired
    CashWithdrawalService cashWithdrawService;
    @Autowired
    BalanceCheckService balanceCheckService;
    @PutMapping(path="/atm-withdraw-cash/{amount}")
    public String cashWithdrawal(@PathVariable("amount")  Long amountToWithdraw)
    {
        return cashWithdrawService.cashWithdraw(amountToWithdraw);
    }
}
