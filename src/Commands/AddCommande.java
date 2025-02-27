package Commands;

import DataBases.DbCommande;
import Models.Commande;
import java.util.Scanner;

public class AddCommande extends Command {
    private DbCommande dbCommande;
    private Scanner scanner;

    public AddCommande(DbCommande dbCommande, Scanner scanner) {
        this.dbCommande = dbCommande;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Ajouter une commande";
    }

    @Override
    public void execute() {
        System.out.println("Ajout d'une commande");
        System.out.println("Numéro de commande : ");
        int numero = scanner.nextInt();

        Commande commande = new Commande(numero);
        dbCommande.create(commande);
    }
}