package program;

public class Player {
    private int point;
    private String name;

    public Player(String name,int pointStart){
        this.point =pointStart;
        this.name = name;

    }

    public void playTurn(int sideNumber1, int diceNumber1){
        while(true) {
            System.out.println("Det er " + this.getName() + "´s tur.");
            DiceCup DC = new DiceCup(diceNumber1, sideNumber1);
            DC.rollDice();
            System.out.println(this.getName() + " slog " + DC.getDieSum());
            switch (DC.getDieSum()) {
                case 2:
                    this.setPoint(this.getPoint() + 250);
                    System.out.println("Du ramte Tower: +250 point!");
                    break;
                case 3:
                    this.setPoint(this.getPoint() - 100);
                    System.out.println("Du ramte Crater: -100 point!");
                    break;
                case 4:
                    this.setPoint(this.getPoint() + 100);
                    System.out.println("Du ramte Palace Gates: +100 point!");
                    break;
                case 5:
                    this.setPoint(this.getPoint() - 20);
                    System.out.println("Du ramte Cold Desert: -20 point!");
                    break;
                case 6:
                    this.setPoint(this.getPoint() + 180);
                    System.out.println("Du ramte Walled City: +180!");
                    break;
                case 7:
                    this.setPoint(this.getPoint());
                    System.out.println("Du ramte Monastery: 0 point!");
                    break;
                case 8:
                    this.setPoint(this.getPoint() - 70);
                    System.out.println("Du ramte Black Cave: -70 point!");
                    break;
                case 9:
                    this.setPoint(this.getPoint() + 60);
                    System.out.println("Du ramte Huts in the mountain: +60 point!");
                    break;
                case 10:
                    this.setPoint(this.getPoint() - 80);
                    System.out.println("Du ramte The Werewall: -80 point! Du får en ekstra tur!");
                    break;
                case 11:
                    this.setPoint(this.getPoint() - 50);
                    System.out.println("Du ramte The Pitts: -50 point!");
                    break;
                case 12:
                    this.setPoint(this.getPoint() + 650);
                    System.out.println("Du ramte Goldmine: +650 point!");
                    break;
            }
            if(DC.getDieSum() != 10){
                break;
            }

        }
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
