public class MyFirstGame {

    public static void main(String[] args) {
        // Целое число в полуинтервале (0, 100]
        int mysteryNum = 10;
        int playerNum = 1;

        if (playerNum <= 0 || playerNum > 100) {
            System.out.println("Введите целое число в полуинтервале (0, 100]"); 
        } else {
            while (playerNum != mysteryNum) {
                if (playerNum < mysteryNum) {
                    System.out.println("Число " + playerNum + " меньше того, что загадал компьютер");
                    playerNum++;
                } else {
                    System.out.println("Число " + playerNum + " больше того, что загадал компьютер");
                    playerNum--;
                }
            }
            System.out.println("Вы победили!"); 
        }
    }
}