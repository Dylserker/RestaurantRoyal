package Models;

import java.util.ArrayList;

public class Commande {
    private int numeroCommande;
    private ArrayList<Plat> plats;
    private double total;

    public Commande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
        this.plats = new ArrayList<>();
        this.total = 0.0;
    }

    public void ajouterPlat(Plat plat) {
        plats.add(plat);
        calculerTotal();
    }

    public double calculerTotal() {
        total = 0.0;
        for (Plat plat : plats) {
            total += plat.getPrix();
        }
        return total;
    }

    public void afficherCommande() {
        System.out.println("Commande #" + numeroCommande + ":");
        for (Plat plat : plats) {
            System.out.println(plat.getNom());
        }
        System.out.println("Total : " + total + " euros");
    }

    @Override
    public String toString() {
        return "Commande #" + numeroCommande + ", Total: " + total + " euros";
    }
}