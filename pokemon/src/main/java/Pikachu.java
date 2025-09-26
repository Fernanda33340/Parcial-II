public class Pikachu package model;

import java.util.Arrays;

public class Pikachu extends Pokemon {
    public Pikachu() {
        super("Pikachu", 95, Arrays.asList(
                new Attack("Impactrueno", 0.9, () -> 15),
                new Attack("Rayo", 0.8, () -> 25),
                new Attack("Trueno", 0.6, () -> 40),
                new Attack("Placaje", 0.9, () -> 10)
        ));
    }

    @Override
    public String getType() { return "Eléctrico"; }
}
{
}
