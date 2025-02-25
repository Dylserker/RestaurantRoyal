package RestaurantRoyal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Dish {
    private String nom;
    private String description;
    private double prix;
    private int calories;
    private String categorie;
    private String taillePortion;
    private String dateAjout;
    private boolean disponibilite;
    private String ingredients;
    private String typeCuisine;
    private int tempsPreparation;
    private double prixSpecial;
    private String imageURL;

    public Dish(String nom, String description, double prix, int calories, String categorie, String taillePortion, String dateAjout, boolean disponibilite, String ingredients, String typeCuisine, int tempsPreparation, double prixSpecial, String imageURL) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.calories = calories;
        this.categorie = categorie;
        this.taillePortion = taillePortion;
        this.dateAjout = dateAjout;
        this.disponibilite = disponibilite;
        this.ingredients = ingredients;
        this.typeCuisine = typeCuisine;
        this.tempsPreparation = tempsPreparation;
        this.prixSpecial = prixSpecial;
        this.imageURL = imageURL;
    }

    public String getNom() { return nom; }
    public double getPrix() { return prix; }

    @Override
    public String toString() {
        return nom + " - " + description + " (" + prix + " euros)";
    }
}