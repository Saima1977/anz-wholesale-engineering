package au.com.anz.controller;

import au.com.anz.model.Account;
import au.com.anz.service.AccountService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

  private final AccountService accountService;

  @Autowired
  AccountController(final AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping(value = "/{accountId}")
  public Account getAccount(@PathVariable final Long accountId) throws Exception {

    final Optional<Account> foundAccount = accountService.getAccountById(accountId);

    if (!foundAccount.isPresent()) {
      throw new Exception("No account exists with accountId=" + accountId);
    }

    return foundAccount.get();
  }

}
