import Commands.Command;
import DataBases.DbRestaurant;
import Models.Restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbRestaurant dbRestaurant = new DbRestaurant();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu :");
            Command[] commands = {
                    new Commands.AddRestaurant(dbRestaurant, scanner),
                    new Commands.DeleteRestaurant(dbRestaurant, scanner),
                    new Commands.PrintRestaurantList(dbRestaurant),
                    new Commands.Quit()
            };

            for (int i = 0; i < commands.length; i++) {
                System.out.println((i + 1) + ". " + commands[i].getLabel());
            }

            int option = chooseOption(scanner);

            if (option < 0 || option >= commands.length) {
                System.out.println("Option inconnue, veuillez réessayer.");
                continue;
            }

            commands[option].execute();
        }
    }

    private static int chooseOption(Scanner scanner) {
        System.out.print("Veuillez choisir une option: ");
        try {
            if (scanner.hasNextInt()) {
                return scanner.nextInt() - 1;
            } else {
                scanner.next();
                return -1;
            }
        } catch (Exception e) {
            scanner.next();
            return -1;
        }
    }
}