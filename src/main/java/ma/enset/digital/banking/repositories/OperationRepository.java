package ma.enset.digital.banking.repositories;
 

import org.springframework.data.jpa.repository.JpaRepository;
 
import ma.enset.digital.banking.models.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
