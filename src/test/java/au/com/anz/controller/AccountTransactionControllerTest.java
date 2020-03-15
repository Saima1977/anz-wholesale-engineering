package au.com.anz.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import au.com.anz.dao.AccountTransactionDAO;
import au.com.anz.service.AccountTransactionService;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;

public class AccountTransactionControllerTest {

  private AccountTransactionController accountTransactionControllerUnderTest;

  @Before
  public void setUp() {
    accountTransactionControllerUnderTest = new AccountTransactionController();
    accountTransactionControllerUnderTest.accountTransactionService = mock(
        AccountTransactionService.class);
  }

  @Test
  public void testGetAccountTransactionByAccount() throws Exception {
    // Setup

    // Configure AccountTransactionService.getAccountTransactionByAccountNumber(...).
    final Iterable<AccountTransactionDAO> accountTransactionDAOS = Arrays.asList(
        new AccountTransactionDAO(0L, "accountNumber", "accountName",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0, 0.0,
            "debitCredit", "transactionNarrative"));
    when(accountTransactionControllerUnderTest.accountTransactionService
        .getAccountTransactionByAccountNumber("accountNumber")).thenReturn(accountTransactionDAOS);

    // Run the test
    final Iterable<AccountTransactionDAO> result = accountTransactionControllerUnderTest
        .getAccountTransactionByAccount("accountNumber");

    // Verify the results
  }

  @Test(expected = Exception.class)
  public void testGetAccountTransactionByAccount_ThrowsException() throws Exception {
    // Setup

    // Configure AccountTransactionService.getAccountTransactionByAccountNumber(...).
    final Iterable<AccountTransactionDAO> accountTransactionDAOS = Arrays.asList(
        new AccountTransactionDAO(0L, "accountNumber", "accountName",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0, 0.0,
            "debitCredit", "transactionNarrative"));
    when(accountTransactionControllerUnderTest.accountTransactionService
        .getAccountTransactionByAccountNumber("accountNumber")).thenReturn(accountTransactionDAOS);

    // Run the test
    accountTransactionControllerUnderTest.getAccountTransactionByAccount("accountNumber");
  }
}
