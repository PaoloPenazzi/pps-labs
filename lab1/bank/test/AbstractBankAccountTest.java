import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;
    protected static int FEE;
    private static final int INITIAL_DEPOSIT_AMOUNT = 100;
    private final int wrongID = 2;

    @BeforeEach
    void setup() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT_AMOUNT);
        assertEquals(INITIAL_DEPOSIT_AMOUNT - FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT_AMOUNT);
        bankAccount.deposit(wrongID, 50);
        assertEquals(INITIAL_DEPOSIT_AMOUNT - FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final int withdrawAmount = 70;
        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), withdrawAmount);
        assertEquals(INITIAL_DEPOSIT_AMOUNT - withdrawAmount - (FEE * 2), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), INITIAL_DEPOSIT_AMOUNT);
        bankAccount.withdraw(wrongID, 70);
        assertEquals(INITIAL_DEPOSIT_AMOUNT - FEE, bankAccount.getBalance());
    }
}
