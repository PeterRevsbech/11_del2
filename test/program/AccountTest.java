package program;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void withdraw() {
        Account account = new Account(1000);
        for (int i=0; i<1000; i++){
            int X = (int) (Math.random()*2000-1000);
            account.withdraw(X);
            assertTrue(!(account.getBalance()<0));
        }
    }

    @Test
    public void deposit() {
        Account account = new Account(1000);
        for (int i=0; i<1000; i++){
            int X = (int) (Math.random()*2000-1000);
            account.deposit(X);
            assertTrue(!(account.getBalance()<0));
        }
    }
}