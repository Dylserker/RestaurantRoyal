package Commands;

import DataBases.DbCommande;
import java.util.Scanner;

public class DeleteCommande extends Command {
    private DbCommande dbCommande;
    private Scanner scanner;

    public DeleteCommande(DbCommande dbCommande, Scanner scanner) {
        this.dbCommande = dbCommande;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Supprimer une commande";
    }

    @Override
    public void execute() {
        System.out.println("Suppression d'une commande");
        System.out.println("Identifiant : ");
        int id = scanner.nextInt();

        dbCommande.delete(id);
    }
}