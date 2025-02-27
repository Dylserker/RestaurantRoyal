package Commands;

import DataBases.DbPlat;
import java.util.Scanner;

public class DeletePlat extends Command {
    private DbPlat dbPlat;
    private Scanner scanner;

    public DeletePlat(DbPlat dbPlat, Scanner scanner) {
        this.dbPlat = dbPlat;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Supprimer un plat";
    }

    @Override
    public void execute() {
        System.out.println("Suppression d'un plat");
        System.out.println("Identifiant : ");
        int id = scanner.nextInt();

        dbPlat.delete(id);
    }
}