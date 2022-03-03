import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
class SimpleBankAccountWithAtmTest  extends AbstractBankAccountTest {

    @BeforeEach
    void setup() {
        super.setup();
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
        FEE = 1;
    }

}
