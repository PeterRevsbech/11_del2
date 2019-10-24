package program;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Player {
    private Account account = new Account(1000);
    private String name = "ukendt";
    private boolean won = false;
    private GUI_Player guiPlayer;

    private final int MAXPOINT = 3000;

    public Player(String name,int pointStart){
        account.setBalance(pointStart);
        this.name = name;
        this.guiPlayer = new GUI_Player(name,pointStart);
    }

    public void playTurn(DiceCup DC){
        while(true) {
            System.out.println("\nDet er " + this.getName() + "´s tur.");
            DC.rollDice();
            System.out.println(this.getName() + " slog " + DC.getDieSum());
            switch (DC.getDieSum()) {
                case 2:
                    account.deposit(250);
                    System.out.println("Du ramte Tower: +250 point!");
                    break;
                case 3:
                    account.withdraw(100);
                    System.out.println("Du ramte Crater: -100 point!");
                    break;
                case 4:
                    account.deposit(100);
                    System.out.println("Du ramte Palace Gates: +100 point!");
                    break;
                case 5:
                    account.withdraw(20);
                    System.out.println("Du ramte Cold Desert: -20 point!");
                    break;
                case 6:
                    account.deposit(180);
                    System.out.println("Du ramte Walled City: +180!");
                    break;
                case 7:
                    System.out.println("Du ramte Monastery: 0 point!");
                    break;
                case 8:
                    account.withdraw(70);
                    System.out.println("Du ramte Black Cave: -70 point!");
                    break;
                case 9:
                    account.deposit(60);
                    System.out.println("Du ramte Huts in the mountain: +60 point!");
                    break;
                case 10:
                    account.withdraw(80);
                    System.out.println("Du ramte The Werewall: -80 point! Du får en ekstra tur!");
                    break;
                case 11:
                    account.withdraw(50);
                    System.out.println("Du ramte The Pitts: -50 point!");
                    break;
                case 12:
                    account.deposit(650);
                    System.out.println("Du ramte Goldmine: +650 point!");
                    break;
            }
            this.guiPlayer.setBalance(this.getAccountBalance());

            System.out.println("Du har nu " + this.getAccountBalance() + " point.");

            if (this.getAccountBalance() >= MAXPOINT) {
                this.won = true;
            }

            if(DC.getDieSum() != 10){
                break;
            }



        }
    }

    public int getAccountBalance() {
        return account.getBalance();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getWon() {
        return this.won;
    }

    public void setWon(boolean x) {
        this.won = x;
    }

    public GUI_Player getGuiPlayer() {
        return guiPlayer;
    }
}
