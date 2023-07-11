package ma.enset.digital.banking.repositories;
 

import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.digital.banking.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
