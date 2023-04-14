package TechLiftProject.ATMManagementSystem.Repositories;

import TechLiftProject.ATMManagementSystem.Entities.Customer;
import TechLiftProject.ATMManagementSystem.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Customer findCustomerById(Long id);
   Customer findCustomerByContact(Long contact);
}
