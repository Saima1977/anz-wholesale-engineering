package au.com.anz.service.impl;

import au.com.anz.dao.AccountTransactionDAO;
import au.com.anz.model.AccountTransaction;
import au.com.anz.repository.AccountTransactionRepository;
import au.com.anz.service.AccountTransactionService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {
  @Autowired
  AccountTransactionRepository accountTransactionRepository;

  public Iterable<AccountTransactionDAO> getAccountTransactionByAccountNumber(final String accountNumber) {
    return accountTransactionRepository.findAllByAccountNumber(accountNumber);
  }
}
