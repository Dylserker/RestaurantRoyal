package DataBases;

import Models.Employe;

import java.io.*;
import java.util.ArrayList;

public class DbEmploye extends DataBase<Employe> {
    private ArrayList<Employe> employes;

    public DbEmploye() {
        this.employes = this.loadAll();
    }

    @Override
    public void create(Employe employe) {
        String filename = String.format("./employes/employe_%d.txt", employe.getId());
        File file = new File(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(Integer.toString(employe.getId()));
            writer.newLine();
            writer.write(employe.getNom());
            writer.newLine();
            writer.write(employe.getPrenom());
            writer.newLine();
            writer.write(employe.getRole());
            writer.newLine();
            writer.write(employe.getDateEmbauche().toString());
            writer.newLine();
            writer.write(Double.toString(employe.getSalaire()));
            employes.add(employe);
        } catch (IOException e) {
            System.out.println("Erreur lors de la création de l'employé: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Employe> loadAll() {
        ArrayList<Employe> employes = new ArrayList<>();
        File folder = new File("./employes/");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().startsWith("employe_")) {
                    Employe employe = this.load(file);
                    if (employe != null) {
                        employes.add(employe);
                    }
                }
            }
        }
        return employes;
    }

    @Override
    public Employe load(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int id = Integer.parseInt(reader.readLine());
            String nom = reader.readLine();
            String prenom = reader.readLine();
            String role = reader.readLine();
            LocalDate dateEmbauche = LocalDate.parse(reader.readLine());
            double salaire = Double.parseDouble(reader.readLine());

            return new Employe(id, nom, prenom, role, dateEmbauche, salaire);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier " + file.getName());
            return null;
        }
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Employe get(int id) {
        return employes.get(id);
    }
}