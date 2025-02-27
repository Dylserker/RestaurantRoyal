package DataBases;

import Models.Menu;

import java.io.*;
import java.util.ArrayList;

public class DbMenu extends DataBase<Menu> {
    private ArrayList<Menu> menus;

    public DbMenu() {
        this.menus = this.loadAll();
    }

    @Override
    public void create(Menu menu) {
        String filename = String.format("./menus/menu_%d.txt", menu.getId());
        File file = new File(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(Integer.toString(menu.getId()));
            writer.newLine();
            writer.write(menu.getNomMenu());
            writer.newLine();
            writer.write(menu.getDateCreation());
            writer.newLine();
            writer.write(menu.getTypeMenu());
            menus.add(menu);
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du menu: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Menu> loadAll() {
        ArrayList<Menu> menus = new ArrayList<>();
        File folder = new File("./menus/");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().startsWith("menu_")) {
                    Menu menu = this.load(file);
                    if (menu != null) {
                        menus.add(menu);
                    }
                }
            }
        }
        return menus;
    }

    @Override
    public Menu load(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int id = Integer.parseInt(reader.readLine());
            String nomMenu = reader.readLine();
            String dateCreation = reader.readLine();
            String typeMenu = reader.readLine();

            return new Menu(id, nomMenu, dateCreation, typeMenu);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier " + file.getName());
            return null;
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Menu get(int id) {
        return menus.get(id);
    }
}