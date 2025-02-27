package DataBases;

import Models.Plat;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DbPlat extends DataBase<Plat> {
    private ArrayList<Plat> plats;

    public DbPlat() {
        this.plats = this.loadAll();
    }

    @Override
    public void create(Plat plat) {
        String filename = String.format("./plats/plat_%s.txt", plat.getNom());
        File file = new File(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(plat.getNom());
            writer.newLine();
            writer.write(plat.getDescription());
            writer.newLine();
            writer.write(Double.toString(plat.getPrix()));
            writer.newLine();
            plats.add(plat);
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du plat: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Plat> loadAll() {
        ArrayList<Plat> plats = new ArrayList<>();
        File folder = new File("./plats/");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().startsWith("plat_")) {
                    Plat plat = this.load(file);
                    if (plat != null) {
                        plats.add(plat);
                    }
                }
            }
        }
        return plats;
    }

    @Override
    public Plat load(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String nom = reader.readLine();
            String description = reader.readLine();
            double prix = Double.parseDouble(reader.readLine());

            return new Plat(nom, description, prix, 0, "", "", "", true, "", "", 0, 0, "");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier " + file.getName());
            return null;
        }
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Plat get(int id) {
        return plats.get(id);
    }

    public void add(Plat plat) {
    }
}