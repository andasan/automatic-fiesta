import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Player {

    String userName;
    TreeMap<String, Integer[][]> userStorage = new TreeMap<>();
    Bank bank;

    public Player(String name) {
        this.userName = name;
        bank = new Bank();
    }

    public String getUserName() {
        return userName;
    }

    public String checkPlayerStorage() {
        if (userStorage.size() == 0) {
            return "You do not have any POK'eMON in your storage";
        } else {
            String output = "";
            for (Map.Entry<String, Integer[][]> entry : userStorage.entrySet()) {
                output += "\n - " + entry.getKey().toUpperCase() + "\n";
                output += printArt(entry.getValue());
                output += "\n\n"; // 2 new line
            }
            return output;
        }
    }

    public String depositPokemon(Scanner input) {
        checkPlayerStorage();

        System.out.print("Type the name here: ");
        String pokeName = input.next();

        Integer[][] pokeMon = userStorage.get(pokeName);

        if (pokeMon == null) {
            return "You do not have that POK'eMON!";
        } else {
            userStorage.remove(pokeName);
            bank.pokeStorage.put(pokeName, pokeMon);
            return "\n\nYou have deposited: " + pokeName.toUpperCase();
        }

    }

    public String withdrawPokemon(Scanner input) {
        System.out.println(bank.checkBankStorage());

        System.out.print("Type the name here: ");
        String pokeName = input.next();

        Integer[][] pokeMonFromBank = bank.pokeStorage.get(pokeName);

        if (pokeMonFromBank == null) {
            return "You do not have that POK'eMON!";
        } else {
            bank.pokeStorage.remove(pokeName);
            userStorage.put(pokeName, pokeMonFromBank);
            return "\n\nYou have withdrawn: " + pokeName.toUpperCase();
        }
    }

    public String printArt(Integer[][] pokemonArt) {
        String output = "";
        for (Integer[] line : pokemonArt) {
            output += "     ";
            for (int dot : line) {
                if (dot == 1) {
                    output += "□";
                } else {
                    output += "■";
                }
            }
            output += "\n";
        }
        return output;
    }

}