package TechLiftProject.ATMManagementSystem.Models;

import TechLiftProject.ATMManagementSystem.Entities.Account;
import lombok.Data;

@Data
public class ModelData {
    private Long modelAccountNumber;
    private Long modelCardNumber;

    private long modelAvailableBalance;
    public ModelData(Account account) {
        this.modelAccountNumber=account.getAccountNumber();
        this.modelAvailableBalance=account.getAvailableBalance();
        this.modelCardNumber=account.getCardNumber();
    }

}
