package au.com.anz.service.impl;

import au.com.anz.dao.UserAccountDAO;
import au.com.anz.dao.UserDAO;
import au.com.anz.model.Account;
import au.com.anz.model.User;
import au.com.anz.repository.AccountRepository;
import au.com.anz.repository.UserAccountRepository;
import au.com.anz.repository.UserRepository;
import au.com.anz.service.UserAccountService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserAccountServiceImpl implements UserAccountService {

  @Autowired
  UserRepository userRepository;

  private AccountRepository accountRepository;

  @Autowired
  UserAccountRepository userAccountRepository;


  public Optional<User> getUserAccount(final Long userId) {

    log.info("Finding user accounts by user id '{}'", userId);

    final Set<Long> accountIds = new HashSet<>();

    final Iterable<UserAccountDAO> userAccountDAOS = userAccountRepository.findAllByUserId(userId);

    userAccountDAOS.forEach(mp -> accountIds.add(mp.getAccountId()));

    final Set<Account> userAccounts = new HashSet<>();

    accountRepository.findAllById(accountIds).forEach(p ->
        userAccounts.add(Account.builder()
            .accountId(p.getAccountId())
            .accountName(p.getAccountName())
            .accountNumber(p.getAccountNumber())
            .accountType(p.getAccountType())
            .currency(p.getCurrency())
            .openingAvailableBalance(p.getOpeningAvailableBalance())
            .balanceDate(p.getBalanceDate())
            .build()));

    final Optional<UserDAO> optionalFoundUserDAO = userRepository.findById(userId);

    final UserDAO foundUserDAO = optionalFoundUserDAO.get();

    return Optional.of(User.builder()
        .userId(userId)
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
