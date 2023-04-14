package TechLiftProject.ATMManagementSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="transaction_type")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "transactionType")
    private Transaction transaction;
}
