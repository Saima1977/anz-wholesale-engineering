package au.com.anz.dao;

import au.com.anz.dao.UserAccountDAO.UserAccountId;
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
@Table(name = "user_account")
@IdClass(UserAccountId.class)
public class UserAccountDAO implements Serializable {

  @Id
  @NotNull
  private Long userId;

  @Id
  @NotNull
  private Long accountId;

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class UserAccountId implements Serializable {
    @Column(name = "userId", nullable = false)
    private Long userId;
    @Column(name = "accountId", nullable = false)
    private Long accountId;
  }
}
