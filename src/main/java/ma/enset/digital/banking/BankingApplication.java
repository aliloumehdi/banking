package ma.enset.digital.banking;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.enset.digital.banking.models.CurrentAccount;
import ma.enset.digital.banking.models.Customer;
import ma.enset.digital.banking.models.Operation;
import ma.enset.digital.banking.models.SavingAccount;
import ma.enset.digital.banking.models.enums.AccountStatus;
import ma.enset.digital.banking.models.enums.OperationType;
import ma.enset.digital.banking.repositories.AccountRepository;
import ma.enset.digital.banking.repositories.CustomerRepository;
import ma.enset.digital.banking.repositories.OperationRepository;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,AccountRepository accountRepository,OperationRepository operationRepository) {
		return args->{
		     Stream.of("Hassan","Imane","Mohamed").forEach(name->{
	               Customer customer=new Customer();
	               customer.setName(name);
	               customer.setEmail(name+"@gmail.com");
	               customerRepository.save(customer);
	           });
		     customerRepository.findAll().forEach(customer->{
		         CurrentAccount currentAccount=new CurrentAccount(); 
		         currentAccount.setCreatedAt( LocalDate.now());
		         currentAccount.setBalance(Math.random()*90000);
		         currentAccount.setOverDraft(9000);
		         currentAccount.setCustomer(customer);
		         currentAccount.setStatus(AccountStatus.ACTIVATED);
		         accountRepository.save(currentAccount);
		         SavingAccount savingAccount=new SavingAccount(); 
		         savingAccount.setCreatedAt( LocalDate.now());
		         savingAccount.setBalance(Math.random()*90000);
		         savingAccount.setInterestRate(5.5);
		         savingAccount.setStatus(AccountStatus.ACTIVATED);
		         savingAccount.setCustomer(customer);
		         accountRepository.save(savingAccount);
	           });

		      accountRepository.findAll().forEach(acc->{
                for (int i = 0; i <10 ; i++) {
                    Operation operation=new Operation();
                    operation.setOperationDate( LocalDate.now());
                    operation.setAmount(Math.random()*12000);
                    operation.setOperationType(Math.random()>0.5? OperationType.DEBIT: OperationType.CREDIT);
                    operation.setAccount(acc);
                    operationRepository.save(operation);
                }

            });
	      accountRepository.findAll().forEach(acc->{
          
System.out.println(acc.toString());
            });
 
		};
	}
}
