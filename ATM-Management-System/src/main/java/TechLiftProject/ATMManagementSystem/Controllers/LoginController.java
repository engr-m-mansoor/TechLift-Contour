package TechLiftProject.ATMManagementSystem.Controllers;

import TechLiftProject.ATMManagementSystem.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(path = "/atm-login/{modelCardNumber}/{modelCardPin}")
    public String authenticateLogin(@PathVariable Long modelCardNumber, @PathVariable Long modelCardPin) {
        return loginService.authenticateLogin(modelCardNumber,modelCardPin);
    }
}