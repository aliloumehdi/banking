package ma.enset.digital.banking.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue("SA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SavingAccount extends BankAccount {
	private double interestRate;
}
