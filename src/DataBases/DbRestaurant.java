package DataBases;

import Models.Restaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DbRestaurant extends DataBase<Restaurant> {
    public ArrayList<Restaurant> restaurants;
    public DbRestaurant() {
        this.restaurants = this.loadAll();
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public Restaurant load(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            String address = reader.readLine();
            reader.close();

            return new Restaurant(id, name, address);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier " + file.getName());
            return null;
        }
    }

    @Override
    public ArrayList<Restaurant> loadAll() {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        File folder = new File("./restaurants/");
        File[] listOfFiles = folder.listFiles();

        for (File file: listOfFiles) {
            if (file.isFile() && file.getName().startsWith("restaurant_")) {
                Restaurant restaurant = this.load(file);
                restaurants.add(restaurant);
            }
        }

        return restaurants;
    }

    @Override
    public void delete(int id) {
        String filename = String.format("./restaurants/restaurant_%d.txt", id);
        File file = new File(filename);

        if (file.delete()) {
            Iterator<Restaurant> iterator = restaurants.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getId() == id) {
                    iterator.remove();
                    break;
                }
            }
            System.out.println("Le restaurant a été supprimé avec succès.");
        } else {
            System.out.println("Échec de la suppression du restaurant.");
        }
    }

    @Override
    public Restaurant get(int id) {
        return restaurants.get(id);
    }

    @Override
    public void create(Restaurant restaurant) {
        String filename = String.format("./restaurants/restaurant_%d.txt", restaurant.getId());
        File f = new File(filename);

        System.out.println("Sauvegarde du restaurant dans " + filename);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));

            writer.append(Integer.toString(restaurant.getId()));
            writer.append("\n");
            writer.append(restaurant.getName());
            writer.append("\n");
            writer.append(restaurant.getAddress());
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde du restaurant");
        }
    }
}
