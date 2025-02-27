package Commands;

import DataBases.DbRestaurant;
import java.util.Scanner;

public class DeleteRestaurant extends Command {
    public DbRestaurant dbRestaurant;
    Scanner scanner;

    public DeleteRestaurant(DbRestaurant dbRestaurant, Scanner scanner) {
        this.scanner = scanner;
        this.dbRestaurant = dbRestaurant;
    }

    @Override
    public String getLabel() {
        return "Supprimer un restaurant";
    }

    @Override
    public void execute() {
        System.out.println("Suppression d'un restaurant");
        System.out.println("Identifiant : ");
        int id = scanner.nextInt();

        dbRestaurant.delete(id);
    }
}
