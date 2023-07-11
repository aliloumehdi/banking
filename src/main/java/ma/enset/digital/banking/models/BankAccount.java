package ma.enset.digital.banking.models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; 
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.digital.banking.models.enums.AccountStatus;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4,discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate createdAt;
	private Double balance ;
	@Enumerated(EnumType.STRING)
	private AccountStatus status;
	private String currency;
	@OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
	private List<Operation>operations;
	@ManyToOne
	@JoinColumn(name = "customer")
	private Customer customer;
	
}
