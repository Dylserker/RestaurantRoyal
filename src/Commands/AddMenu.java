package Commands;

import DataBases.DbMenu;
import Models.Menu;
import java.util.Scanner;

public class AddMenu extends Command {
    private DbMenu dbMenu;
    private Scanner scanner;

    public AddMenu(DbMenu dbMenu, Scanner scanner) {
        this.dbMenu = dbMenu;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Ajouter un menu";
    }

    @Override
    public void execute() {
        System.out.println("Ajout d'un menu");
        System.out.println("Nom du menu : ");
        String name = scanner.nextLine();
        System.out.println("Type de menu : ");
        String type = scanner.nextLine();

        Menu menu = new Menu(/* id, name, dateCreation, type */);
        dbMenu.create(menu);
    }
}