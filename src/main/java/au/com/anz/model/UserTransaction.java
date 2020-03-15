package au.com.anz.model;

import au.com.anz.model.UserTransaction.UserTransactionId;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "user_transaction")
@IdClass(UserTransactionId.class)
public class UserTransaction implements Serializable {

  @Id
  @NotNull
  private Long accountId;

  @Id
  @NotNull
  private Long accountTransactionId;

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class UserTransactionId implements Serializable {
    @Column(name = "accountId", nullable = false)
    private Long accountId;
    @Column(name = "accountTransactionId", nullable = false)
    private Long accountTransactionId;
  }
}
