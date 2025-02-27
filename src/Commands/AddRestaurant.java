package Commands;

import DataBases.DbRestaurant;
import Models.Restaurant;
import java.util.Scanner;

public class AddRestaurant extends Command {
    public DbRestaurant dbRestaurant;
    private Scanner scanner;

    public AddRestaurant(DbRestaurant dbRestaurant, Scanner scanner) {
        this.scanner = scanner;
        this.dbRestaurant = dbRestaurant;
    }

    @Override
    public String getLabel() {
        return "Ajouter un restaurant";
    }

    @Override
    public void execute() {
        System.out.println("Ajout d'un restaurant");
        System.out.println("Identifiant : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nom : ");
        String name = scanner.nextLine();
        System.out.println("Adresse : ");
        String address = scanner.nextLine();

        dbRestaurant.create(new Restaurant(id, name, address));
    }

}
