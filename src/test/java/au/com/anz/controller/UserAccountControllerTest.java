package au.com.anz.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import au.com.anz.model.Account;
import au.com.anz.model.User;
import au.com.anz.service.UserAccountService;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class UserAccountControllerTest {

  @Mock
  private UserAccountService mockUserAccountService;

  private UserAccountController userAccountControllerUnderTest;

  @Before
  public void setUp() {
    initMocks(this);
    userAccountControllerUnderTest = new UserAccountController(mockUserAccountService);
  }

  @Test
  public void testGetUserAccount() throws Exception {
    // Setup
    final User expectedResult = new User(0L, "firstName", "lastName", "addressLine1",
        "addressLine2", "city", "postcode", "state", "country", new HashSet<>(
        Arrays.asList(new Account(0L, new BigInteger("100"), "accountName", "accountType",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0))));

    // Configure UserAccountService.getUserAccount(...).
    final Optional<User> user = Optional
        .of(new User(0L, "firstName", "lastName", "addressLine1", "addressLine2", "city",
            "postcode", "state", "country", new HashSet<>(
            Arrays.asList(new Account(0L, new BigInteger("100"), "accountName", "accountType",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0)))));
    when(mockUserAccountService.getUserAccount(0L)).thenReturn(user);

    // Run the test
    final User result = userAccountControllerUnderTest.getUserAccount(0L);

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test(expected = Exception.class)
  public void testGetUserAccount_ThrowsException() throws Exception {
    // Setup

    // Configure UserAccountService.getUserAccount(...).
    final Optional<User> user = Optional
        .of(new User(0L, "firstName", "lastName", "addressLine1", "addressLine2", "city",
            "postcode", "state", "country", new HashSet<>(
            Arrays.asList(new Account(0L, new BigInteger("100"), "accountName", "accountType",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0)))));
    when(mockUserAccountService.getUserAccount(0L)).thenReturn(user);

    // Run the test
    userAccountControllerUnderTest.getUserAccount(0L);
  }
}
