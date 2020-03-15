package au.com.anz.controller;

import au.com.anz.dao.AccountTransactionDAO;
import au.com.anz.model.User;
import au.com.anz.service.AccountTransactionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounttransaction")
public class AccountTransactionController {
  @Autowired
  AccountTransactionService accountTransactionService;

  @GetMapping(value = "/{accountNumber}")
  public Iterable<AccountTransactionDAO> getAccountTransactionByAccount(@PathVariable final String accountNumber) throws Exception {
    return accountTransactionService.getAccountTransactionByAccountNumber(accountNumber);
  }
}
