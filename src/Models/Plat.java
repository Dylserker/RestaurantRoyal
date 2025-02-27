package Models;

public class Plat {
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

    public Plat(String nom, String description, double prix, int calories, String categorie,
                String taillePortion, String dateAjout, boolean disponibilite,
                String ingredients, String typeCuisine, int tempsPreparation,
                double prixSpecial, String imageURL) {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTaillePortion() {
        return taillePortion;
    }

    public void setTaillePortion(String taillePortion) {
        this.taillePortion = taillePortion;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTypeCuisine() {
        return typeCuisine;
    }

    public void setTypeCuisine(String typeCuisine) {
        this.typeCuisine = typeCuisine;
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public double getPrixSpecial() {
        return prixSpecial;
    }

    public void setPrixSpecial(double prixSpecial) {
        this.prixSpecial = prixSpecial;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Plat: " + nom + ", Description: " + description + ", Prix: " + prix +
                " euros, Calories: " + calories + ", Catégorie: " + categorie;
    }
}