package au.com.anz.service;

import au.com.anz.dao.AccountTransactionDAO;
import au.com.anz.model.AccountTransaction;
import java.util.Optional;

public interface AccountTransactionService {
  Iterable<AccountTransactionDAO> getAccountTransactionByAccountNumber(final String accountNumber);
}
