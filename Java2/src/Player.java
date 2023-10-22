import java.util.ArrayList;
import java.util.List;

public class Player {
    Hero hero;
    List<Servant> servants;

    public Player() {
        hero = new Hero();
        servants = new ArrayList<>();
    }

    public void summon(Servant servant, int position) {
        servants.add(position - 1, servant);
    }

    public void attack(int attackerIndex, Player opponent, int defenderIndex) {
        Servant attacker = servants.get(attackerIndex - 1);
        if (defenderIndex == 0) {  // Attack hero
            opponent.hero.takeDamage(attacker.getAttack());
            attacker.takeDamage(opponent.hero.getAttack());
        } else {  // Attack servant
            Servant defender = opponent.servants.get(defenderIndex - 1);
            attacker.takeDamage(defender.getAttack());
            defender.takeDamage(attacker.getAttack());
        }
        servants.removeIf(Servant::isDead);
        opponent.servants.removeIf(Servant::isDead);
    }
}
