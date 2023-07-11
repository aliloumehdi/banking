package ma.enset.digital.banking.repositories;
 

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
 
import ma.enset.digital.banking.models.BankAccount; 

public interface AccountRepository extends JpaRepository<BankAccount, UUID> {

}
