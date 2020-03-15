package au.com.anz.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import au.com.anz.model.Account;
import au.com.anz.model.User;
import au.com.anz.service.UserService;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class UserControllerTest {

  private UserController userControllerUnderTest;

  @Before
  public void setUp() {
    userControllerUnderTest = new UserController();
    userControllerUnderTest.userService = mock(UserService.class);
  }

  @Test
  public void testGetUser() throws Exception {
    // Setup
    final User expectedResult = new User(0L, "firstName", "lastName", "addressLine1",
        "addressLine2", "city", "postcode", "state", "country", new HashSet<>(
        Arrays.asList(new Account(0L, new BigInteger("100"), "accountName", "accountType",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0))));

    // Configure UserService.getUser(...).
    final Optional<User> user = Optional
        .of(new User(0L, "firstName", "lastName", "addressLine1", "addressLine2", "city",
            "postcode", "state", "country", new HashSet<>(
            Arrays.asList(new Account(0L, new BigInteger("100"), "accountName", "accountType",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0)))));
    when(userControllerUnderTest.userService.getUser(0L)).thenReturn(user);

    // Run the test
    final User result = userControllerUnderTest.getUser(0L);

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test(expected = Exception.class)
  public void testGetUser_ThrowsException() throws Exception {
    // Setup

    // Configure UserService.getUser(...).
    final Optional<User> user = Optional
        .of(new User(0L, "firstName", "lastName", "addressLine1", "addressLine2", "city",
            "postcode", "state", "country", new HashSet<>(
            Arrays.asList(new Account(0L, new BigInteger("100"), "accountName", "accountType",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0)))));
    when(userControllerUnderTest.userService.getUser(0L)).thenReturn(user);

    // Run the test
    userControllerUnderTest.getUser(0L);
  }
}
