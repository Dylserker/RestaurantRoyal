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
            System.out.println("No employees registered for this restaurant.");
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
