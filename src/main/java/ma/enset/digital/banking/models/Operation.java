package ma.enset.digital.banking.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.digital.banking.models.enums.OperationType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private LocalDate operationDate;
	private Double amount;
	@Enumerated(EnumType.STRING)
	private OperationType operationType;
	@ManyToOne
	@JoinColumn(name = "account")
	private BankAccount account;
	
}
