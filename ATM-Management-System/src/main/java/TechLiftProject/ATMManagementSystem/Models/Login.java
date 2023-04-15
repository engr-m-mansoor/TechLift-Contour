package TechLiftProject.ATMManagementSystem.Models;

import lombok.Data;

@Data
public class Login {
    private Long enteredCardNumber;
    private Long enteredCardPin;
    private Long accountNumber;
    private static Login instance;
    private Login() {

    }
    public static Login getInstance() {
        if(instance == null) {
            instance = new Login();
        }
        return instance;
    }
    public static void setInstance(Login instance) {
        Login.instance = instance;
    }
}


