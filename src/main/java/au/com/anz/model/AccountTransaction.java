package au.com.anz.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "account_transaction")
@SequenceGenerator(name="accountTransactionIdGenerator", initialValue=1900100030, allocationSize=100)
@JsonPropertyOrder({
    "accountNumber",
    "accountName",
    "valueDate",
    "currency",
    "debitAmount",
    "creditAmount",
    "debitCredit",
    "transactionNarrative"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountTransaction implements Serializable {
  @Id
  @GeneratedValue(generator = "accountTransactionIdGenerator")
  @Column(name = "accountTransactionId", updatable = false, nullable = false)
  @NotNull
  private Long accountTransactionId;

  @JsonCreator
  public AccountTransaction(
      @JsonProperty("accountNumber") String accountNumber,
      @JsonProperty("accountName") String accountName,
      @JsonProperty("valueDate") Date valueDate,
      @JsonProperty("currency") String currency,
      @JsonProperty("debitAmount") Double debitAmount,
      @JsonProperty("creditAmount") Double creditAmount,
      @JsonProperty("debitCredit") String debitCredit,
      @JsonProperty("transactionNarrative") String transactionNarrative
  ) {
    this.accountNumber = accountNumber;
    this.accountName = accountName;
    this.valueDate = valueDate;
    this.currency = currency;
    this.debitAmount = debitAmount;
    this.creditAmount= creditAmount;
    this.debitCredit = debitCredit;
    this.transactionNarrative = transactionNarrative;
  }

  private String accountNumber;

  private String accountName;

  private Date valueDate;

  private String currency;

  private Double debitAmount;

  private Double creditAmount;

  private String debitCredit;

  private String transactionNarrative;
}
