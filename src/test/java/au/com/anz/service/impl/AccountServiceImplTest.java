package au.com.anz.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import au.com.anz.model.Account;
import au.com.anz.service.AccountService;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class AccountServiceImplTest {

  private AccountServiceImpl accountServiceImplUnderTest;

  @Before
  public void setUp() {
    accountServiceImplUnderTest = new AccountServiceImpl();
    accountServiceImplUnderTest.accountService = mock(AccountService.class);
  }

  @Test
  public void testGetAccountById() {
    // Setup
    final Optional<Account> expectedResult = Optional
        .of(new Account(0L, new BigInteger("100"), "accountName", "accountType",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0));

    // Configure AccountService.getAccountById(...).
    final Optional<Account> account = Optional
        .of(new Account(0L, new BigInteger("100"), "accountName", "accountType",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0));
    when(accountServiceImplUnderTest.accountService.getAccountById(0L)).thenReturn(account);

    // Run the test
    final Optional<Account> result = accountServiceImplUnderTest.getAccountById(0L);

    // Verify the results
    assertEquals(expectedResult, result);
  }
}
