package au.com.anz.service.impl;

import au.com.anz.dao.UserAccountDAO;
import au.com.anz.dao.UserDAO;
import au.com.anz.model.Account;
import au.com.anz.model.User;
import au.com.anz.repository.AccountRepository;
import au.com.anz.repository.UserAccountRepository;
import au.com.anz.repository.UserRepository;
import au.com.anz.service.UserService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private UserAccountRepository userAccountRepository;

  @Autowired
  public UserService userService;

  public Optional<User> getUser(final Long userId) {

    log.info("Finding a user by id '{}'", userId);

    final Optional<UserDAO> optionalFoundUserDAO = userRepository.findById(userId);

    if (!optionalFoundUserDAO.isPresent()) {
      return Optional.empty();
    }

    log.info("Found a user by id '{}'", userId);

    final UserDAO foundUserDAO = optionalFoundUserDAO.get();

    final Set<Long> accountNumbers = new HashSet<>();

    final Iterable<UserAccountDAO> userAccountDAOS = userAccountRepository.findAllByUserId(foundUserDAO.getUserId());

    userAccountDAOS.forEach(mp -> accountNumbers.add(mp.getAccountId()));

    final Set<Account> userAccounts = new HashSet<>();

    accountRepository.findAllById(accountNumbers).forEach(p ->
        userAccounts.add(Account.builder()
            .accountId(p.getAccountId())
            .accountName(p.getAccountName())
            .accountType(p.getAccountType())
            .balanceDate(p.getBalanceDate())
            .currency(p.getCurrency())
            .accountNumber(p.getAccountNumber())
            .openingAvailableBalance(p.getOpeningAvailableBalance())
            .build()));

    return Optional.of(User.builder()
        .userId(foundUserDAO.getUserId())
        .firstName(foundUserDAO.getGivenName())
        .lastName(foundUserDAO.getSurname())
        .addressLine1(foundUserDAO.getAddressLine1())
        .addressLine2(foundUserDAO.getAddressLine2())
        .city(foundUserDAO.getCity())
        .postcode(foundUserDAO.getPostcode())
        .state(foundUserDAO.getState())
        .country(foundUserDAO.getCountry())
        .userAccounts(userAccounts)
        .build());
  }
}
