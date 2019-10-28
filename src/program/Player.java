package program;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Player {
    private Account account = new Account(1000);
    private String name;
    private boolean won = false;
    private boolean lastSum10 = false;
    private GUI_Player guiPlayer;


    private final int MAXPOINT = 1500;

    public Player(String name,int pointStart){
        this.account.setBalance(pointStart);
        this.name = name;
        this.guiPlayer = new GUI_Player(name,pointStart);
    }

    public String playTurn(DiceCup DC){
            this.lastSum10 = false;
            String message = "";
            message = message +"\nDet er " + this.getName() + "´s tur.\n";
            DC.rollDice();
            message = message + this.getName() + " slog " + DC.getDieSum() +" ";
            switch (DC.getDieSum()) {
                case 2:
                    account.deposit(250);
                    message = message + "og ramte Tårnet: +250 point!";
                    break;
                case 3:
                    account.withdraw(100);
                    message = message + "og ramte Krateret: -100 point!";
                    break;
                case 4:
                    account.deposit(100);
                    message = message + "og ramte Paladsportene: +100 point!";
                    break;
                case 5:
                    account.withdraw(20);
                    message = message + "og ramte Den Kolde Ørken: -20 point!";
                    break;
                case 6:
                    account.deposit(180);
                    message = message + "og ramte Den Indmurede By: +180!";
                    break;
                case 7:
                    message = message + "og ramte Klosteret: 0 point!";
                    break;
                case 8:
                    account.withdraw(70);
                    message = message + "og ramte Den Sorte Hule: -70 point!!";
                    break;
                case 9:
                    account.deposit(60);
                    message = message + "og ramte Hytterne i Bjergene: +60 point!";
                    break;
                case 10:
                    account.withdraw(80);
                    message = message + "og ramte Varulvemuren: -80 point! Du får en ekstra tur!";
                    this.lastSum10=true;
                    break;
                case 11:
                    account.withdraw(50);
                    message = message + "og ramte Hullerne: -50 point!";
                    break;
                case 12:
                    account.deposit(650);
                    message = message + "og ramte Guldminen: +650 point!";
                    break;
            }
            this.getGuiPlayer().setBalance(this.getAccountBalance());

            if (this.getAccountBalance() >= MAXPOINT) {
                this.won = true;
            }

            if (this.getAccountBalance() < 0) {
                this.getAccount().setBalance(0);
            }

            return message;

    }

    public int getAccountBalance() {
        return account.getBalance();
    }

    public Account getAccount(){
        return this.account;
    }

    public void setName(String name) {
        this.name = name;
        this.getGuiPlayer().setName(name);
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
        return this.guiPlayer;
    }

    public boolean isLastSum10() {
        return lastSum10;
    }
}
