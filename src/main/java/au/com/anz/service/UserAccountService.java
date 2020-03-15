package au.com.anz.service;

import au.com.anz.model.User;
import java.util.Optional;

public interface UserAccountService {
  Optional<User> getUserAccount(final Long userId);
}
