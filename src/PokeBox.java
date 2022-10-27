import java.util.Scanner;
import java.io.IOException;

public class PokeBox {

    static Player player = new Player("hoge");

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("================================");
            System.out.println("turning on the PokeBox...");
            System.out.println("================================");
            while (true) {
                clrscr();
                System.out.println("What is your name?");
                String user = input.nextLine();
                if (user.equals(player.getUserName())) {
                    System.out.println(user + "accessed someone's PC." + user + " accessed POK'eMON storage System.");
                    break;
                }
                System.out.println("Invalid, try again or press [Q] to quit.");
                if (input.nextLine().toLowerCase().equals("q")) {
                    System.out.println(user + "turned off the PokeBox.");
                    System.exit(0);
                }
            }
            clrscr();
            showMenu();
        }
    }

    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
            System.out.println("\033\143");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void showMenu() {
        char option;
        try (Scanner input = new Scanner(System.in)) {
            do {
                System.out.println(
                        "****************************************************\n" +
                        "----------------------MAIN MENU---------------------\n" +
                        "****************************************************\n" +
                                "What?\n" +
                                "a. Player Storage\n" +
                                "b. BALANCE\n" +
                                "c. DEPOSIT\n" +
                                "d. WITHDRAW\n" +
                                "e. RELEASE\n" +
                                "f. SEE YA!\n" +
                        "****************************************************");
                option = input.next().charAt(0);
                clrscr();
                switch (Character.toLowerCase(option)) {
                    case 'a':
                        System.out.println("====================================================");
                        System.out.println("--------------------PLAYER STORAGE------------------");
                        System.out.println("====================================================");
                        System.out.println(player.checkPlayerStorage());
                        System.out.println("====================================================");
                        break;
                    case 'b':
                        System.out.println("====================================================");
                        System.out.println("---------------------BANK STORAGE-------------------");
                        System.out.println("====================================================");
                        System.out.println(player.bank.checkBankStorage());
                        System.out.println("====================================================");
                        break;
                    case 'c':
                        System.out.println("====================================================");
                        System.out.println("Which POK'eMON do you deposit?");
                        System.out.println("====================================================");
                        System.out.println(player.depositPokemon(input));
                        break;
                    case 'd':
                        System.out.println("====================================================");
                        System.out.println("Which POK'eMON do you withdraw?");
                        System.out.println("====================================================");
                        System.out.println(player.withdrawPokemon(input));
                        break;
                    case 'e':
                        System.out.println("====================================================");
                        System.out.println("Which POK'eMON do you release?");
                        System.out.println("====================================================");

                        break;
                    case 'f':
                        break;
                    default:
                        System.out.println("invalid. try again.");
                        break;
                }
            } while (Character.toLowerCase(option) != 'f');
            System.out.println(player.getUserName() + " turned off the PC.");
            System.exit(0);
        }
    }

    /***** error message *****/
    public static void errorMessage(String message) {
        System.out.println(message);
    }
}