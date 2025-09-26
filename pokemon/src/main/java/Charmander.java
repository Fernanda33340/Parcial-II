package Charmander;

import java.util.Arrays;

public class Charmander extends Pokemon {
    public Charmander() {
        super("Charmander", 100, Arrays.asList(
                new Attack("Arañazo", 0.9, () -> 10),
                new Attack("Ascuas", 0.8, () -> 15),
                new Attack("Lanzallamas", 0.7, () -> 25),
                new Attack("Garra Dragón", 0.6, () -> 30)
        ));
    }

    @Override
    public String getType() { return "Fuego"; }
}

