package Models;

import java.util.ArrayList;

public class Restaurant {
    private int id;
    private String nomRestaurant;
    private String adresse;
    private Menu menu;
    private ArrayList<Commande> commandes;
    private ArrayList<Employe> employes;

    public Restaurant(int id, String nomRestaurant, String adresse) {
        this.id = id;
        this.nomRestaurant = nomRestaurant;
        this.adresse = adresse;
        this.commandes = new ArrayList<>();
        this.employes = new ArrayList<>();
        this.menu = new Menu(id, "Menu de " + nomRestaurant, "2024-01-01", "Standard");
    }
    
    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    public void afficherCommandes() {
        System.out.println("Commandes pour " + nomRestaurant + ":");
        for (Commande commande : commandes) {
            commande.afficherCommande();
        }
    }

    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    public void supprimerEmploye(Employe employe) {
        employes.remove(employe);
    }

    public ArrayList<Employe> chercherEmployeParRole(String role) {
        ArrayList<Employe> resultats = new ArrayList<>();
        for (Employe employe : employes) {
            if (employe.getRole().equalsIgnoreCase(role)) {
                resultats.add(employe);
            }
        }
        return resultats;
    }

    public void afficherEmployes() {
        System.out.println("Employés de " + nomRestaurant + ":");
        for (Employe employe : employes) {
            System.out.println(employe);
        }
    }

    public void afficherRestaurant() {
        System.out.println("Restaurant #" + id + ": " + nomRestaurant + ", Adresse: " + adresse);
        afficherEmployes();
    }

    @Override
    public String toString() {
        return "Restaurant #" + id + ": " + nomRestaurant + ", Adresse: " + adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nomRestaurant;
    }

    public String getAddress() {
        return adresse;
    }
}