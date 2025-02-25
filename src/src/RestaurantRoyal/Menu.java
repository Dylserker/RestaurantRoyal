package RestaurantRoyal;
import java.util.*;

import java.util.ArrayList;

class Menu {
    private int id;
    private String nomMenu;
    private String dateCreation;
    private String typeMenu;
    private ArrayList<Dish> platsDisponibles;

    public Menu(int id, String nomMenu, String dateCreation, String typeMenu) {
        this.id = id;
        this.nomMenu = nomMenu;
        this.dateCreation = dateCreation;
        this.typeMenu = typeMenu;
        this.platsDisponibles = new ArrayList<>();
    }

    public void ajouterPlat(Dish plat) {
        platsDisponibles.add(plat);
    }

    public void supprimerPlat(Dish plat) {
        platsDisponibles.remove(plat);
    }

    public void afficherMenu() {
        for (Dish plat : platsDisponibles) {
            System.out.println(plat);
        }
    }

    public Dish chercherPlatParNom(String nom) {
        for (Dish plat : platsDisponibles) {
            if (plat.getNom().equalsIgnoreCase(nom)) {
                return plat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Menu #" + id + ": " + nomMenu + ", Type: " + typeMenu;
    }
}
