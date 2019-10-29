import program.*;
import java.util.*;
public class MainTest {
    public static void main(String[] args) {

        Player testPlayer = new Player(".idea/test",1000);
        int fejl1Antal = 0;
        int fejl2Antal = 0;

        for (int i = 0; i<100; i++) {

            int testAmount = (int) (Math.random()*2000 - 1000);
            testPlayer.getAccount().withdraw(testAmount);
            if (testPlayer.getAccountBalance()<0) {
                System.out.println("Spillerens balance blev negativ. Fejl i test 1.");
                fejl1Antal++;
            }
        }

        for (int i = 0; i<100; i++) {
            int testAmount = (int) (Math.random()*2000) - 1000;
            testPlayer.getAccount().deposit(testAmount);
            if (testPlayer.getAccountBalance()<0) {
                System.out.println("Spillerens balance blev negativ. Fejl i test 2.");
                fejl2Antal++;
            }
        }

        if (fejl1Antal>0) {
            System.out.println("Fejl i test 1.");
        } else {
            System.out.println("Test 1 succesfuld.");
        }
        if (fejl2Antal>0) {
            System.out.println("Fejl i test 2.");
        } else {
            System.out.println("Test 2 succesfuld.");
        }

    }


}
