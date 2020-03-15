package au.com.anz.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import au.com.anz.dao.UserAccountDAO;
import au.com.anz.dao.UserDAO;
import au.com.anz.model.Account;
import au.com.anz.model.User;
import au.com.anz.repository.UserAccountRepository;
import au.com.anz.repository.UserRepository;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class UserAccountServiceImplTest {

  private UserAccountServiceImpl userAccountServiceImplUnderTest;

  @Before
  public void setUp() {
    userAccountServiceImplUnderTest = new UserAccountServiceImpl();
    userAccountServiceImplUnderTest.userRepository = mock(UserRepository.class);
    userAccountServiceImplUnderTest.userAccountRepository = mock(UserAccountRepository.class);
  }

  @Test
  public void testGetUserAccount() {
    // Setup
    final Optional<User> expectedResult = Optional
        .of(new User(0L, "firstName", "lastName", "addressLine1", "addressLine2", "city",
            "postcode", "state", "country", new HashSet<>(
            Arrays.asList(new Account(0L, new BigInteger("100"), "accountName", "accountType",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0)))));

    // Configure UserAccountRepository.findAllByUserId(...).
    final Iterable<UserAccountDAO> userAccountDAOS = Arrays.asList(new UserAccountDAO(0L, 0L));
    when(userAccountServiceImplUnderTest.userAccountRepository.findAllByUserId(0L))
        .thenReturn(userAccountDAOS);

    // Configure UserRepository.findById(...).
    final Optional<UserDAO> userDAO = Optional
        .of(new UserDAO(0L, "givenName", "surname", "addressLine1", "addressLine2", "city",
            "postcode", "state", "country"));
    when(userAccountServiceImplUnderTest.userRepository.findById(0L)).thenReturn(userDAO);

    // Run the test
    final Optional<User> result = userAccountServiceImplUnderTest.getUserAccount(0L);

    // Verify the results
    assertEquals(expectedResult, result);
  }
}
