package umg.edu;

import logic.DamageRule;

public class Attack {
    private String name;
    private double accuracy;
    private DamageRule damageRule;

    public Attack(String name, double accuracy, DamageRule damageRule) {
        this.name = name;
        this.accuracy = accuracy;
        this.damageRule = damageRule;
    }

    public String getName() { return name; }
    public double getAccuracy() { return accuracy; }
    public int calculateDamage() { return damageRule.calculate(); }
}
