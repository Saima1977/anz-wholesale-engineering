package au.com.anz.repository;

import au.com.anz.dao.AccountTransactionDAO;
import au.com.anz.model.AccountTransaction;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountTransactionRepository extends CrudRepository<AccountTransactionDAO, String> {
  @Query("SELECT at FROM AccountTransaction at WHERE at.accountNumber = :accountNumber")
  Iterable<AccountTransactionDAO> findAllByAccountNumber(@Param("accountNumber") final String accountNumber);
}