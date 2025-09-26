package game;

import model.*;
import exceptions.*;
import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Pokemon player;
    private Pokemon cpu;
    private List<String> battleLog = new ArrayList<>();
    private List<Integer> damages = new ArrayList<>();

    public void start() throws InvalidChoiceException {
        System.out.println("=== Bienvenido al Juego Pokémon ===");
        System.out.print("Ingresa tu nombre: ");
        String name = scanner.nextLine();

        List<Pokemon> pokemons = Arrays.asList(
                new Charmander(), new Squirtle(), new Bulbasaur(), new Pikachu()
        );

        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println((i+1) + ". " + pokemons.get(i).getName());
        }
        System.out.print("Elige tu Pokémon: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > pokemons.size()) {
            throw new InvalidChoiceException("Opción inválida.");
        }

        player = pokemons.get(choice - 1);
        cpu = pokemons.get(new Random().nextInt(pokemons.size()));
        while (cpu.getName().equals(player.getName())) {
            cpu = pokemons.get(new Random().nextInt(pokemons.size()));
        }

        System.out.println(name + " eligió a " + player.getName());
        System.out.println("CPU eligió a " + cpu.getName());

        playBattle();
        showSummary();
    }

    private void playBattle() {
        Random rand = new Random();
        while (player.isAlive() && cpu.isAlive()) {
            System.out.println("\nTu turno. HP " + player.getCurrentHp() +
                    " vs " + cpu.getName() + " HP " + cpu.getCurrentHp());

            for (int i = 0; i < player.getAttacks().size(); i++) {
                System.out.println((i+1) + ". " + player.getAttacks().get(i).getName());
            }
            int choice = scanner.nextInt() - 1;

            try {
                executeAttack(player, cpu, player.getAttacks().get(choice));
            } catch (AttackMissedException | IndexOutOfBoundsException e) {
                System.out.println("¡Fallo! " + e.getMessage());
            }

            if (!cpu.isAlive()) break;

            try {
                Attack cpuAttack = cpu.getAttacks().get(rand.nextInt(cpu.getAttacks().size()));
                executeAttack(cpu, player, cpuAttack);
            } catch (AttackMissedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void executeAttack(Pokemon attacker, Pokemon defender, Attack attack) throws AttackMissedException {
        if (Math.random() > attack.getAccuracy()) {
            battleLog.add(attacker.getName() + " falló " + attack.getName());
            throw new AttackMissedException(attacker.getName() + " falló!");
        }
        int damage = attack.calculateDamage();
        defender.receiveDamage(damage);
        damages.add(damage);
        battleLog.add(attacker.getName() + " usó " + attack.getName() + " e hizo " + damage + " de daño.");
        System.out.println(attacker.getName() + " usó " + attack.getName() + " → daño: " + damage);
    }

    private void showSummary() {
        System.out.println("\n--- Resumen de la Batalla ---");
        battleLog.forEach(System.out::println);

        System.out.println("\nTop 3 golpes más fuertes: " +
                damages.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));

        System.out.println("Promedio de daño: " +
                damages.stream().mapToInt(Integer::intValue).average().orElse(0));

        System.out.println("Ganador: " + (player.isAlive() ? player.getName() : cpu.getName()));
    }

    public static void main(String[] args) {
        try {
            new Game().start();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
