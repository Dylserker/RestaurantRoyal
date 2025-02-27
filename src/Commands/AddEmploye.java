package Commands;

import DataBases.DbEmploye;
import Models.Employe;
import java.util.Scanner;

public class AddEmploye extends Command {
    private DbEmploye dbEmploye;
    private Scanner scanner;

    public AddEmploye(DbEmploye dbEmploye, Scanner scanner) {
        this.dbEmploye = dbEmploye;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Ajouter un employé";
    }

    @Override
    public void execute() {
        System.out.println("Ajout d'un employé");
        System.out.println("Nom : ");
        String nom = scanner.nextLine();
        System.out.println("Prénom : ");
        String prenom = scanner.nextLine();

        Employe employe = new Employe();
        dbEmploye.create(employe);
    }
}