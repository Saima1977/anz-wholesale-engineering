package au.com.anz.controller;

import au.com.anz.model.User;
import au.com.anz.model.UserAccount;
import au.com.anz.service.UserAccountService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/useraccount")
public class UserAccountController {

  @Autowired
  UserAccountService userAccountService;

  @Autowired
  UserAccountController(final UserAccountService userAccountService) {
    this.userAccountService = userAccountService;
  }

  @GetMapping(value = "/{userId}")
  public User getUserAccount(@PathVariable final Long userId) throws Exception {

    final Optional<User> foundUser = userAccountService.getUserAccount(userId);

    if (!foundUser.isPresent()) {
      throw new Exception("No user exists with userId=" + userId);
    }

    return foundUser.get();
  }

}
