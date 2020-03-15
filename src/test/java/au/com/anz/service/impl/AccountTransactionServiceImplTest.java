package au.com.anz.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import au.com.anz.dao.AccountTransactionDAO;
import au.com.anz.repository.AccountTransactionRepository;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;

public class AccountTransactionServiceImplTest {

  private AccountTransactionServiceImpl accountTransactionServiceImplUnderTest;

  @Before
  public void setUp() {
    accountTransactionServiceImplUnderTest = new AccountTransactionServiceImpl();
    accountTransactionServiceImplUnderTest.accountTransactionRepository = mock(
        AccountTransactionRepository.class);
  }

  @Test
  public void testGetAccountTransactionByAccountNumber() {
    // Setup

    // Configure AccountTransactionRepository.findAllByAccountNumber(...).
    final Iterable<AccountTransactionDAO> accountTransactionDAOS = Arrays.asList(
        new AccountTransactionDAO(0L, "accountNumber", "accountName",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), "currency", 0.0, 0.0,
            "debitCredit", "transactionNarrative"));
    when(accountTransactionServiceImplUnderTest.accountTransactionRepository
        .findAllByAccountNumber("accountNumber")).thenReturn(accountTransactionDAOS);

    // Run the test
    final Iterable<AccountTransactionDAO> result = accountTransactionServiceImplUnderTest
        .getAccountTransactionByAccountNumber("accountNumber");

    // Verify the results
  }
}
