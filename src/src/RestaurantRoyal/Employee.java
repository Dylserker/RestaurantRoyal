package RestaurantRoyal;

import java.util.ArrayList;

class Employee {
    private int id;
    private String nom;
    private String prenom;
    private String role;
    private String dateEmbauche;
    private double salaire;

    public Employee(int id, String nom, String prenom, String role, String dateEmbauche, double salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getRole() { return role; }
    public String getDateEmbauche() { return dateEmbauche; }
    public double getSalaire() { return salaire; }

    @Override
    public String toString() {
        return "Employé #" + id + ": Nom: " + nom + ", Prénom: " + prenom + ", Rôle: " + role + ", Salaire: " + salaire + ", Date d'embauche: " + dateEmbauche;
    }
}