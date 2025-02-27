package Commands;

import DataBases.DbEmploye;
import java.util.Scanner;

public class DeleteEmploye extends Command {
    private DbEmploye dbEmploye;
    private Scanner scanner;

    public DeleteEmploye(DbEmploye dbEmploye, Scanner scanner) {
        this.dbEmploye = dbEmploye;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Supprimer un employé";
    }

    @Override
    public void execute() {
        System.out.println("Suppression d'un employé");
        System.out.println("Identifiant : ");
        int id = scanner.nextInt();

        dbEmploye.delete(id);
    }
}