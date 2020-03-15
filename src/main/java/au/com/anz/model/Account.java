package au.com.anz.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "Account")
@SequenceGenerator(name="accountIdGenerator", initialValue=1900100030, allocationSize=100)
@JsonPropertyOrder({
    "accountNumber",
    "accountName",
    "accountType",
    "balanceDate",
    "currency",
    "openingAvailableBalance"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable {
  @Id
  @GeneratedValue(generator = "accountIdGenerator")
  @Column(name = "accountId", updatable = false, nullable = false)
  @NotNull
  private Long accountId;

  private BigInteger accountNumber;

  private String accountName;

  private String accountType;

  private Date balanceDate;

  private String currency;

  private Double openingAvailableBalance;
}
