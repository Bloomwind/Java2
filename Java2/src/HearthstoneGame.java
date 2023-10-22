import java.util.Scanner;

public class HearthstoneGame {
    public void simulateGame() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Player player1 = new Player();
        Player player2 = new Player();
        Player current = player1;
        Player opponent = player2;

        for (int i = 0; i < n; i++) {
            String action = scanner.next();
            switch (action) {
                case "summon":
                    int position = scanner.nextInt();
                    int attack = scanner.nextInt();
                    int health = scanner.nextInt();
                    current.summon(new Servant(attack, health), position);
                    break;
                case "attack":
                    int attackerIndex = scanner.nextInt();
                    int defenderIndex = scanner.nextInt();
                    current.attack(attackerIndex, opponent, defenderIndex);
                    break;
                case "end":
                    Player temp = current;
                    current = opponent;
                    opponent = temp;
                    break;
            }
        }

        int result = 0;
        if (player1.hero.isDead() && player2.hero.isDead()) {
            result = 0;
        } else if (player1.hero.isDead()) {
            result = -1;
        } else if (player2.hero.isDead()) {
            result = 1;
        }

        System.out.println(result);
        printPlayerState(player1);
        printPlayerState(player2);
    }

    private void printPlayerState(Player player) {
        System.out.println(player.hero.getHealth());
        System.out.print(player.servants.size());
        for (Servant servant : player.servants) {
            System.out.print(" " + servant.getHealth());
        }
        System.out.println();
    }
}
