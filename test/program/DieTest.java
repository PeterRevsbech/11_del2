package program;

import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest {

    @Test
    public void roll() {
        int sidenumber=1;
        for (int j=1; j < 50; j++) {
            sidenumber++;
            int[] X = new int[sidenumber];
            Die die = new Die(6);
            for (int i = 0; i < sidenumber * 10000; i++) {
                die.roll();
                X[die.getFaceValue() - 1]++;
            }
            for (int i = 0; i < sidenumber; i++) {
                assertTrue(X[i] < 10400 && X[i] > 9600);
            }
        }
    }



}