package Models;

import java.util.ArrayList;

public class Menu {
    private int id;
    private String nomMenu;
    private String dateCreation;
    private String typeMenu;
    private ArrayList<Plat> platsDisponibles;

    public Menu(int id, String nomMenu, String dateCreation, String typeMenu) {
        this.id = id;
        this.nomMenu = nomMenu;
        this.dateCreation = dateCreation;
        this.typeMenu = typeMenu;
        this.platsDisponibles = new ArrayList<>();
    }

    public void ajouterPlat(Plat plat) {
        platsDisponibles.add(plat);
    }

    public void supprimerPlat(Plat plat) {
        platsDisponibles.remove(plat);
    }

    public void afficherMenu() {
        System.out.println("Menu: " + nomMenu);
        for (Plat plat : platsDisponibles) {
            System.out.println(plat);
        }
    }

    public Plat chercherPlatParNom(String nom) {
        for (Plat plat : platsDisponibles) {
            if (plat.getNom().equalsIgnoreCase(nom)) {
                return plat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Menu #" + id + ": " + nomMenu + ", Type: " + typeMenu + ", Date de création: " + dateCreation;
    }
}