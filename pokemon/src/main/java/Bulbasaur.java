package Bulbasaur;

import java.util.Arrays;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super("Bulbasaur", 105, Arrays.asList(
                new Attack("Placaje", 0.9, () -> 10),
                new Attack("Látigo Cepa", 0.85, () -> 15),
                new Attack("Hoja Afilada", 0.75, () -> 25),
                new Attack("Rayo Solar", 0.5, () -> 40)
        ));
    }

    @Override
    public String getType() { return "Planta"; }
}

