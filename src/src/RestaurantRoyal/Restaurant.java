package RestaurantRoyal;

import java.io.*;
import java.util.*;

class Restaurant {
    private int id;
    private String name, address;
    private List<Employee> employees;
    private List<Dish> menu;

    public Restaurant(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employees = new ArrayList<>();
        this.menu = new ArrayList<>();
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
            System.out.println("No employees registered.");
            return;
        }
        System.out.println("\n=== Employees of " + name + " ===");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    public void displayMenu() {
        if (menu.isEmpty()) {
            System.out.println("🍽️ The menu is empty.");
        } else {
            System.out.println("🍽️ Menu:");
            for (Dish dish : menu) {
                System.out.println(dish);
            }
        }
    }

    public void saveMenuToFile() {
        String filename = "menu_" + name.replace(" ", "_") + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Dish dish : menu) {
                writer.write(dish.toString());
                writer.newLine();
            }
            System.out.println("✅ Menu saved to " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error saving menu: " + e.getMessage());
        }
    }

    public void loadMenuFromFile() {
        String filename = "menu_" + name.replace(" ", "_") + ".txt";
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            menu.clear();
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine()); // Affichage temporaire, parsing à améliorer si besoin
            }
            System.out.println("✅ Menu loaded from " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error loading menu: " + e.getMessage());
        }
    }

    public static void saveRestaurantsToFile(String filename, List<Restaurant> restaurants) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Restaurant restaurant : restaurants) {
                writer.write(restaurant.id + "," + restaurant.name + "," + restaurant.address);
                writer.newLine();
            }
            System.out.println("✅ Restaurants successfully saved in " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error saving restaurants.");
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
                    System.out.println("⚠️ Format error in file. Line ignored.");
                }
            }
            System.out.println("✅ Restaurants loaded successfully since " + filename);
        } catch (IOException e) {
            System.out.println("❌ No files found for restaurants.");
        }

        return restaurants;
    }

    public void saveEmployeesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees_" + id + ".txt"))) {
            for (Employee emp : employees) {
                writer.write(emp.toFile());
                writer.newLine();
            }
            System.out.println("✅ Restaurant employees " + name + " saved !");
        } catch (IOException e) {
            System.out.println("❌ Employee Backup Error.");
        }
    }

    public void loadEmployeesFromFile() {
        employees.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("employees_" + id + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                employees.add(Employee.fromFile(line));
            }
            System.out.println("✅ Employees successfully tasked for " + name);
        } catch (IOException e) {
            System.out.println("❌ No files found for employees of " + name);
        }
    }
}
