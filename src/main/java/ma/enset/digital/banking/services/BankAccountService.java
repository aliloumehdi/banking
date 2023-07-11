package ma.enset.digital.banking.services;

import java.util.List;

import ma.enset.digital.banking.exceptions.CustomerNotFoundException;
import ma.enset.digital.banking.models.BankAccount;
import ma.enset.digital.banking.models.CurrentAccount;
import ma.enset.digital.banking.models.Customer;
import ma.enset.digital.banking.models.Operation;
import ma.enset.digital.banking.models.SavingAccount;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);

    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId);
            // 
            // throws CustomerNotFoundException;
    BankAccount saveBankAccount(double initialBalance, String type, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId);
            
    // throws CustomerNotFoundException;

    List<Customer> listCustomers();

    BankAccount getBankAccount(String accountId) ;
    // throws BankAccountNotFoundException;

    void debit(String accountId, double amount, String description);
            
    // throws BankAccountNotFoundException, BalanceNotSufficientException;

    void credit(String accountId, double amount, String description) ;
    // throws BankAccountNotFoundException;

    void transfer(String accountIdSource, String accountIdDestination, double amount);
            
    // throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccount> bankAccountList();

    Customer getCustomer(Long customerId) ;
    // throws CustomerNotFoundException;

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long customerId);

    List<Operation> accountHistory(String accountId);

    // AccountHistory getAccountHistory(String accountId, int page, int size) ;
    // throws BankAccountNotFoundException;

    List<Customer> searchCustomers(String keyword);
}
