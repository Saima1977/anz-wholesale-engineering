package au.com.anz.service.impl;

import au.com.anz.model.Account;
import au.com.anz.service.AccountService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  AccountService accountService;

  @Override
  public Optional<Account> getAccountById(@PathVariable Long accountId) {
    return accountService.getAccountById(accountId);
  }
}