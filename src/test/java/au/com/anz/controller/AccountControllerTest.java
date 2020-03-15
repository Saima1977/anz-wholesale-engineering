package au.com.anz.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import au.com.anz.model.Account;
import au.com.anz.service.AccountService;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AccountControllerTest {

  @Mock
  private AccountService mockAccountService;

  private AccountController accountControllerUnderTest;

  @Before
  public void setUp() {
    initMocks(this);
    accountControllerUnderTest = new AccountController(mockAccountService);
  }

  @Test
  public void testGetAccount() throws Exception {
    // Setup
    final Account expectedResult = new Account(0L, new BigInteger("100"), "accountName",
        "accountType", new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0);

    // Configure AccountService.getAccountById(...).
    final Optional<Account> account = Optional
        .of(new Account(0L, new BigInteger("100"), "accountName", "accountType",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0));
    when(mockAccountService.getAccountById(0L)).thenReturn(account);

    // Run the test
    final Account result = accountControllerUnderTest.getAccount(0L);

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test(expected = Exception.class)
  public void testGetAccount_ThrowsException() throws Exception {
    // Setup

    // Configure AccountService.getAccountById(...).
    final Optional<Account> account = Optional
        .of(new Account(0L, new BigInteger("100"), "accountName", "accountType",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0));
    when(mockAccountService.getAccountById(0L)).thenReturn(account);

    // Run the test
    accountControllerUnderTest.getAccount(0L);
  }
}
