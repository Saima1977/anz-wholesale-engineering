package au.com.anz.dao;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_transaction")
public class AccountTransactionDAO {
  @Id
  @Column(name = "accountTransactionId", updatable = false, nullable = false)
  @NotNull
  private Long accountTransactionId;

  @NotNull
  @Column(name = "accountNumber", nullable = false)
  private String accountNumber;

  @NotNull
  @Column(name = "accountName", nullable = false)
  private String accountName;

  @NotNull
  @Column(name = "valueDate", nullable = false)
  private Date valueDate;

  @NotNull
  @Column(name = "currency", nullable = false)
  private String currency;

  @Column(name = "debitAmount", nullable = false)
  private Double debitAmount;

  @Column(name = "creditAmount", nullable = false)
  private Double creditAmount;

  @NotNull
  @Column(name = "debitCredit", nullable = false)
  private String debitCredit;

  @Column(name = "transactionNarrative", nullable = false)
  private String transactionNarrative;
}
