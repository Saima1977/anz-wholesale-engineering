package au.com.anz.repository;

import au.com.anz.dao.UserAccountDAO;
import au.com.anz.dao.UserAccountDAO.UserAccountId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserAccountRepository extends CrudRepository<UserAccountDAO, UserAccountId> {
  @Query("SELECT ua FROM UserAccountDAO ua WHERE ua.userId = :userId")
  Iterable<UserAccountDAO> findAllByUserId(@Param("userId") final Long userId);
}
