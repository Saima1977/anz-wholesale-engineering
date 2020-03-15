package au.com.anz.service;

import au.com.anz.model.AccountTransaction;
import au.com.anz.model.User;
import java.util.Optional;

public interface UserService {
  Optional<User> getUser(final Long userId);
}
