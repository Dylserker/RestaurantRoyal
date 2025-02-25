package RestaurantRoyal;

import java.io.*;
import java.util.*;

class Restaurant {
    private int id;
    private String nomRestaurant;
    private String adresse;
    Menu menu;
    private ArrayList<Order> commandes;
    ArrayList<Employee> employes;

    public Restaurant(int id, String nomRestaurant, String adresse) {
        this.id = id;
        this.nomRestaurant = nomRestaurant;
        this.adresse = adresse;
        this.menu = new Menu(id, "Menu du " + nomRestaurant, "2023-10-01", "Standard");
        this.commandes = new ArrayList<>();
        this.employes = new ArrayList<>();
    }

    public void ajouterCommande(Order commande) {
        commandes.add(commande);
    }

    public void afficherCommandes() {
        for (Order commande : commandes) {
            commande.afficherCommande();
        }
    }

    public void ajouterEmploye(Employee employe) {
        employes.add(employe);
    }

    public void supprimerEmploye(Employee employe) {
        employes.remove(employe);
    }

    public void chercherEmployeParRole(String role) {
        for (Employee employe : employes) {
            if (employe.getRole().equalsIgnoreCase(role)) {
                System.out.println(employe);
            }
        }
    }

    public void afficherEmployes() {
        for (Employee employe : employes) {
            System.out.println(employe);
        }
    }

    public void afficherRestaurant() {
        System.out.println("Restaurant #" + id + ": " + nomRestaurant + ", Adresse: " + adresse);
        System.out.println("Employés : ");
        afficherEmployes();
    }
}
