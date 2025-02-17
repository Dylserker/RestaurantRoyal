package RestaurantRoyal;

import java.io.*;
import java.util.*;

class Restaurant {
    private int id;
    private String name, address;
    private List<Employee> employees = new ArrayList<>();

    public Restaurant(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Aucun employé enregistré pour ce restaurant.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    public static void saveRestaurantsToFile(String filename, List<Restaurant> restaurants) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Restaurant restaurant : restaurants) {
                writer.write(restaurant.id + "," + restaurant.name + "," + restaurant.address);
                writer.newLine();
            }
            System.out.println("✅ Restaurants sauvegardés avec succès dans " + filename);
        } catch (IOException e) {
            System.out.println("❌ Erreur lors de la sauvegarde des restaurants.");
        }
    }

    public static List<Restaurant> loadRestaurantsFromFile(String filename) {
        List<Restaurant> restaurants = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String address = parts[2].trim();
                    restaurants.add(new Restaurant(id, name, address));
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Erreur de format dans le fichier. Ligne ignorée.");
                }
            }
            System.out.println("✅ Restaurants chargés avec succès depuis " + filename);
        } catch (IOException e) {
            System.out.println("❌ Aucun fichier trouvé pour les restaurants.");
        }

        return restaurants;
    }

    public void saveEmployeesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees_" + id + ".txt"))) {
            for (Employee emp : employees) {
                writer.write(emp.toFile());
                writer.newLine();
            }
            System.out.println("✅ Employés du restaurant " + name + " sauvegardés !");
        } catch (IOException e) {
            System.out.println("❌ Erreur de sauvegarde des employés.");
        }
    }

    public void loadEmployeesFromFile() {
        employees.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("employees_" + id + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                employees.add(Employee.fromFile(line));
            }
            System.out.println("✅ Employés chargés avec succès pour " + name);
        } catch (IOException e) {
            System.out.println("❌ Aucun fichier trouvé pour les employés de " + name);
        }
    }
}
