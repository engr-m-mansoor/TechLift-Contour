package TechLiftProject.ATMManagementSystem.Controllers;

import TechLiftProject.ATMManagementSystem.Services.BalanceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceCheckController {
    @Autowired
    BalanceCheckService balanceCheckService;
    @GetMapping(path = "/atm-balance-inquiry")
    public String getAvailableBalance( ) {
        System.out.println(balanceCheckService.getAvailableBalance());
        return null;
    }
}
