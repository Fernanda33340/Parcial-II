package model;

import java.util.Arrays;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super("Squirtle", 110, Arrays.asList(
                new Attack("Placaje", 0.9, () -> 10),
                new Attack("Pistola Agua", 0.85, () -> 15),
                new Attack("Burbuja", 0.8, () -> 20),
                new Attack("Hidrobomba", 0.6, () -> 35)
        ));
    }

    @Override
    public String getType() {
        return "Agua";
    }
}



