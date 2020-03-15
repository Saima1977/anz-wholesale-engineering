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
@Table(name = "account")
public class AccountDAO {

  @Id
  @Column(name = "accountId", updatable = false, nullable = false)
  @NotNull
  private Long accountId;

  @NotNull
  @Column(name = "accountNumber", nullable = false)
  private String accountNumber;

  @NotNull
  @Column(name = "accountName", nullable = false)
  private String accountName;

  @NotNull
  @Column(name = "accountType", nullable = false)
  private String accountType;

  @NotNull
  @Column(name = "balanceDate", nullable = false)
  private Date balanceDate;

  @NotNull
  @Column(name = "currency", nullable = false)
  private String currency;

  @NotNull
  @Column(name = "openingAvailableBalance", nullable = false)
  private Double openingAvailableBalance;
}
