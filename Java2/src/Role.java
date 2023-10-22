public class Role {
    protected int health;
    protected int attack;

    public Role(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }
}

class Hero extends Role {
    public Hero() {
        super(30, 0);
    }
}

class Servant extends Role {
    public Servant(int attack, int health) {
        super(health, attack);
    }
}
