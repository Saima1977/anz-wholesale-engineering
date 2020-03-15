package au.com.anz.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import au.com.anz.dao.UserAccountDAO;
import au.com.anz.model.Account;
import au.com.anz.model.User;
import au.com.anz.repository.AccountRepository;
import au.com.anz.repository.UserAccountRepository;
import au.com.anz.service.UserService;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceImplTest {

  @Mock
  private AccountRepository mockAccountRepository;
  @Mock
  private UserAccountRepository mockUserAccountRepository;
  @Mock
  private UserService mockUserService;

  @InjectMocks
  private UserServiceImpl userServiceImplUnderTest;

  @Before
  public void setUp() {
    initMocks(this);
  }

  @Test
  public void testGetUser() {
    // Setup
    final Optional<User> expectedResult = Optional
        .of(new User(0L, "firstName", "lastName", "addressLine1", "addressLine2", "city",
            "postcode", "state", "country", new HashSet<>(
            Arrays.asList(new Account(0L, new BigInteger("100"), "accountName", "accountType",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0)))));

    // Configure UserAccountRepository.findAllByUserId(...).
    final Iterable<UserAccountDAO> userAccountDAOS = Arrays.asList(new UserAccountDAO(0L, 0L));
    when(mockUserAccountRepository.findAllByUserId(0L)).thenReturn(userAccountDAOS);

    // Configure AccountRepository.findAllById(...).
    final List<Account> accounts = Arrays.asList(
        new Account(0L, new BigInteger("100"), "accountName", "accountType",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0));
    when(mockAccountRepository.findAllById(Arrays.asList())).thenReturn(accounts);

    // Run the test
    final Optional<User> result = userServiceImplUnderTest.getUser(0L);

    // Verify the results
    assertEquals(expectedResult, result);
  }
}
