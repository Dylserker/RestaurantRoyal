package RestaurantRoyal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Dish {
    private String name, description, category, typeKitchen;
    private double price;
    private int calory, timePreparation;

    public Dish(String name, String description, String category, String typeKitchen, double price, int calory, int timePreparation) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.typeKitchen = typeKitchen;
        this.price = price;
        this.calory = calory;
        this.timePreparation = timePreparation;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + description + " - Price : " + price + "$ - calory : " + calory + " - Type : " + typeKitchen;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(this.toString());
            writer.newLine();
            System.out.println("✅ Plat enregistré : " + name);
        } catch (IOException e) {
            System.err.println("❌ Erreur lors de l'écriture dans le fichier: " + e.getMessage());
        }
    }
}



