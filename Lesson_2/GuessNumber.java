import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    //private Player instancePlayer;
    private int mysteryNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void executGame() {
        mysteryNumber = (int) ((Math.random() * 100) + 1);
        do {
            playRound(player1);
            if (player1.isWinner()) {
                break;
            } else {
            playRound(player2);
            }
        }
        while (!player1.isWinner() && !player2.isWinner());
        player1.setWinner(false);
        player2.setWinner(false);
    }

    private void playRound(Player instancePlayer) {
        Scanner input = new Scanner(System.in);

// instancePlayer.getName() не выводит русские буквы почему-то??
        String playerName = instancePlayer.getName();
        System.out.printf("%s \nвведите целое число в полуинтервале (0, 100]: ", playerName); 
        instancePlayer.setNumber(input.nextInt());
        int playerNumber = instancePlayer.getNumber();
        if (playerNumber <= 0 || playerNumber > 100) {
            System.out.println("Переход хода!Необходимо вводить число в полуинтервале (0, 100]: ");
        } else if (playerNumber < mysteryNumber) {
            System.out.println("Число " + playerNumber + " меньше того, что загадал компьютер");
        } else if (playerNumber > mysteryNumber) {
            System.out.println("Число " + playerNumber + " больше того, что загадал компьютер");
        } else {
            instancePlayer.setWinner(true);
            System.out.println(instancePlayer.getName() + " победил!!!");
        }
    }
}