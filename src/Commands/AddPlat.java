package Commands;

import DataBases.DbPlat;
import Models.Plat;

import java.util.Scanner;

public class AddPlat extends Command {
    private final DbPlat dbPlat;
    private final Scanner scanner;

    public AddPlat(DbPlat dbPlat, Scanner scanner) {
        this.dbPlat = dbPlat;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Ajouter un plat";
    }

    @Override
    public void execute() {
        System.out.print("Nom du plat: ");
        String nom = scanner.nextLine();

        System.out.print("Prix du plat: ");
        double prix;
        while (true) {
            try {
                prix = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Veuillez entrer un prix valide: ");
            }
        }

        System.out.print("Description du plat: ");
        String description = scanner.nextLine();

        Plat plat = new Plat(nom, prix, description);
        dbPlat.add(plat);

        System.out.println("Plat ajouté avec succès !");
    }
}