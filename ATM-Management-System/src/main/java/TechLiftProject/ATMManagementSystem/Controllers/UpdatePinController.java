package TechLiftProject.ATMManagementSystem.Controllers;

import TechLiftProject.ATMManagementSystem.Services.UpdatePinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UpdatePinController {
    @Autowired
    UpdatePinService changePinService;
    @PutMapping("/atm-update-pin/{pin}")
    public String updatePin(@PathVariable("pin") int pin)
    {
        return changePinService.updatePin(pin);
    }

}