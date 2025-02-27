package Commands;

import DataBases.DbMenu;
import java.util.Scanner;

public class DeleteMenu extends Command {
    private DbMenu dbMenu;
    private Scanner scanner;

    public DeleteMenu(DbMenu dbMenu, Scanner scanner) {
        this.dbMenu = dbMenu;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Supprimer un menu";
    }

    @Override
    public void execute() {
        System.out.println("Suppression d'un menu");
        System.out.println("Identifiant : ");
        int id = scanner.nextInt();

        dbMenu.delete(id);
    }
}