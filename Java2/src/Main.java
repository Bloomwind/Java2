public class Main {
    public static void main(String[] args) {
        new HearthstoneGame().simulateGame();
    }
}
/*伪代码
class Role {
    int health
    int attack
    method takeDamage()
    method isDead()
}
class Hero extends Role {
    constructor()
}
class Servant extends Role {
    constructor(attack, health)
}
class Player {
    Hero hero
    List<Servant> servants
    method summon(servant, position)
    method attack(attackerIndex, opponent, defenderIndex)
}
class HearthstoneGame {
    method simulateGame() {
        Loop until game end:
            Read action
            if action is "summon":
                summon servant
            else if action is "attack":
                make attack
            else if action is "end":
                switch player
        print result
    }
}

 */