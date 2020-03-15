package au.com.anz.service;

import au.com.anz.model.Account;
import java.util.List;
import java.util.Optional;

public interface AccountService {
  Optional<Account> getAccountById(final Long accountId);
}