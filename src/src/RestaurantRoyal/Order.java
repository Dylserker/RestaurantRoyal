package RestaurantRoyal;
import java.util.*;

class Order {
    private int numeroCommande;
    private ArrayList<Dish> plats;
    private double total;

    public Order(int numeroCommande) {
        this.numeroCommande = numeroCommande;
        this.plats = new ArrayList<>();
        this.total = 0;
    }

    public void ajouterPlat(Dish plat) {
        plats.add(plat);
        total += plat.getPrix();
    }

    public double calculerTotal() {
        return total;
    }

    public void afficherCommande() {
        System.out.println("Commande #" + numeroCommande + ":");
        for (Dish plat : plats) {
            System.out.println(plat);
        }
        System.out.println("Total : " + total + " euros");
    }

    @Override
    public String toString() {
        return "Commande #" + numeroCommande + " - Total: " + total + " euros";
    }
}
