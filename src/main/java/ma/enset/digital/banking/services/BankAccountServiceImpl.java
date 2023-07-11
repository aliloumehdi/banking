package ma.enset.digital.banking.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.digital.banking.exceptions.CustomerNotFoundException;
import ma.enset.digital.banking.models.BankAccount;
import ma.enset.digital.banking.models.CurrentAccount;
import ma.enset.digital.banking.models.Customer;
import ma.enset.digital.banking.models.Operation;
import ma.enset.digital.banking.models.SavingAccount;
import ma.enset.digital.banking.repositories.AccountRepository;
import ma.enset.digital.banking.repositories.CustomerRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        log.info("Saving new customer");

        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public BankAccount saveBankAccount(double initialBalance, String type, Long customerId)
            throws CustomerNotFoundException { 
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (Objects.isNull(customer))
            throw new CustomerNotFoundException("Customer not found");

        BankAccount bankAccount;
        if ("current".equals(type)) {
            bankAccount = new CurrentAccount();
        } else {
            bankAccount = new SavingAccount();
        }
        bankAccount.setCustomer(customer);
        bankAccount.setBalance(initialBalance);
        bankAccount.setCreatedAt(LocalDate.now());

        BankAccount savedBankAccount=accountRepository.save(bankAccount);
        return savedBankAccount;
    }

    @Override
    public CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) {
        throw new UnsupportedOperationException("Unimplemented method 'saveCurrentBankAccount'");
    }

    @Override
    public SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveSavingBankAccount'");
    }

    @Override
    public List<Customer> listCustomers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listCustomers'");
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBankAccount'");
    }

    @Override
    public void debit(String accountId, double amount, String description) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'debit'");
    }

    @Override
    public void credit(String accountId, double amount, String description) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'credit'");
    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transfer'");
    }

    @Override
    public List<BankAccount> bankAccountList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bankAccountList'");
    }

    @Override
    public Customer getCustomer(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomer'");
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }

    @Override
    public void deleteCustomer(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }

    @Override
    public List<Operation> accountHistory(String accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accountHistory'");
    }

    @Override
    public List<Customer> searchCustomers(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchCustomers'");
    }

}
