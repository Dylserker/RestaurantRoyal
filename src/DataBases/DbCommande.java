package DataBases;

import Models.Commande;

import java.io.*;
import java.util.ArrayList;

public class DbCommande extends DataBase<Commande> {
    private ArrayList<Commande> commandes;

    public DbCommande() {
        this.commandes = this.loadAll();
    }

    @Override
    public void create(Commande commande) {
        String filename = String.format("./commandes/commande_%d.txt", commande.getNumeroCommande());
        File file = new File(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(Integer.toString(commande.getNumeroCommande()));
            writer.newLine();
            commandes.add(commande);
        } catch (IOException e) {
            System.out.println("Erreur lors de la création de la commande: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Commande> loadAll() {
        ArrayList<Commande> commandes = new ArrayList<>();
        File folder = new File("./commandes/");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().startsWith("commande_")) {
                    Commande commande = this.load(file);
                    if (commande != null) {
                        commandes.add(commande);
                    }
                }
            }
        }
        return commandes;
    }

    @Override
    public Commande load(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int numeroCommande = Integer.parseInt(reader.readLine());

            return new Commande(numeroCommande);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier " + file.getName());
            return null;
        }
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Commande get(int id) {
        return commandes.get(id);
    }
}