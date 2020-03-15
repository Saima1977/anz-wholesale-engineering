package au.com.anz.controller;

import au.com.anz.model.User;
import au.com.anz.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  public UserService userService;

  @GetMapping(value = "/{userId}")
  public User getUser(@PathVariable final Long userId) throws Exception {

    final Optional<User> foundUser = userService.getUser(userId);

    if (!foundUser.isPresent()) {
      throw new Exception("No user exists with userId=" + userId);
    }

    return foundUser.get();
  }

}
