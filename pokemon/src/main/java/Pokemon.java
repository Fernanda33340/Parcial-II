package Pokemon;

import java.util.List;

public abstract class Pokemon {
    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected List<Attack> attacks;

    public Pokemon(String name, int maxHp, List<Attack> attacks) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attacks = attacks;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public void receiveDamage(int damage) {
        currentHp = Math.max(0, currentHp - damage);
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public abstract String getType();
}

