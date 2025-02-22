package RestaurantRoyal;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Restaurant> restaurants = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== MENU UTILISATEUR ===");
            System.out.println("1. Add a restaurant");
            System.out.println("2. Add an employee to a restaurant");
            System.out.println("3. Show restaurant employees");
            System.out.println("4. Safeguard restaurant employees");
            System.out.println("5. Charge restaurant employees");
            System.out.println("6. Save all restaurants");
            System.out.println("7. Load all restaurants");
            System.out.println("8. Exit");
            System.out.print("Choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name restaurant : ");
                    String restaurantName = scanner.nextLine();
                    System.out.print("Adress restaurant : ");
                    String restaurantAddress = scanner.nextLine();
                    Restaurant newRestaurant = new Restaurant(restaurants.size() + 1, restaurantName, restaurantAddress);
                    restaurants.add(newRestaurant);
                    System.out.println("Restaurant added successfully !");
                    break;

                case 2:
                    if (restaurants.isEmpty()) {
                        System.out.println("Add a restaurant first.");
                        break;
                    }
                    System.out.println("Choose a restaurant by ID : ");
                    for (Restaurant r : restaurants) {
                        System.out.println(r.getId() + ": " + r.getName());
                    }
                    System.out.print("ID restaurant : ");
                    int restaurantId = scanner.nextInt();
                    scanner.nextLine();

                    Restaurant selectedRestaurant = null;
                    for (Restaurant r : restaurants) {
                        if (r.getId() == restaurantId) {
                            selectedRestaurant = r;
                            break;
                        }
                    }

                    if (selectedRestaurant == null) {
                        System.out.println("Restaurant not found.");
                        break;
                    }

                    System.out.print("Employee name : ");
                    String name = scanner.nextLine();
                    System.out.print("First name : ");
                    String firstName = scanner.nextLine();
                    System.out.print("Role : ");
                    String role = scanner.nextLine();
                    System.out.print("Date of hire : ");
                    String dateOfHire = scanner.nextLine();
                    System.out.print("Salary : ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();

                    Employee newEmployee = new Employee(restaurantId, name, firstName, role, dateOfHire, salary);
                    selectedRestaurant.addEmployee(newEmployee);
                    System.out.println("\n" + "Employee added successfully !");
                    break;

                case 3:
                    if (restaurants.isEmpty()) {
                        System.out.println("No registered restaurants.");
                        break;
                    }
                    System.out.println("\n" + "Choose a restaurant to display its employees :");
                    for (Restaurant r : restaurants) {
                        System.out.println(r.getId() + ": " + r.getName());
                    }
                    System.out.print("ID restaurant : ");
                    int restId = scanner.nextInt();
                    scanner.nextLine();

                    Restaurant restaurantToShow = null;
                    for (Restaurant r : restaurants) {
                        if (r.getId() == restId) {
                            restaurantToShow = r;
                            break;
                        }
                    }

                    if (restaurantToShow != null) {
                        restaurantToShow.displayEmployees();
                    } else {
                        System.out.println("\n" + "Restaurant not found.");
                    }
                    break;

                case 4:
                    if (restaurants.isEmpty()) {
                        System.out.println("\n" + "No registered restaurants.");
                        break;
                    }
                    System.out.println("\n" + "Choose a restaurant to safeguard its employees :");
                    for (Restaurant r : restaurants) {
                        System.out.println(r.getId() + ": " + r.getName());
                    }
                    System.out.print("ID restaurant : ");
                    int restToSaveId = scanner.nextInt();
                    scanner.nextLine();

                    Restaurant restaurantToSave = null;
                    for (Restaurant r : restaurants) {
                        if (r.getId() == restToSaveId) {
                            restaurantToSave = r;
                            break;
                        }
                    }

                    if (restaurantToSave != null) {
                        restaurantToSave.saveEmployeesToFile();
                        System.out.println("\n" + "Saved employees !");
                    } else {
                        System.out.println("\n" + "Restaurant not found.");
                    }
                    break;

                case 5:
                    if (restaurants.isEmpty()) {
                        System.out.println("No registered restaurants.");
                        break;
                    }
                    System.out.println("Choose a restaurant to charge its employees :");
                    for (Restaurant r : restaurants) {
                        System.out.println(r.getId() + ": " + r.getName());
                    }
                    System.out.print("ID restaurant : ");
                    int restToLoadId = scanner.nextInt();
                    scanner.nextLine();

                    Restaurant restaurantToLoad = null;
                    for (Restaurant r : restaurants) {
                        if (r.getId() == restToLoadId) {
                            restaurantToLoad = r;
                            break;
                        }
                    }

                    if (restaurantToLoad != null) {
                        restaurantToLoad.loadEmployeesFromFile();
                        System.out.println("Employés load !");
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;

                case 6:
                    System.out.print("Name save file : ");
                    String saveFile = scanner.nextLine();
                    Restaurant.saveRestaurantsToFile(saveFile, restaurants);
                    System.out.println("Restaurants save !");
                    break;

                case 7:
                    System.out.print("Name load file : ");
                    String loadFile = scanner.nextLine();
                    restaurants = Restaurant.loadRestaurantsFromFile(loadFile);
                    System.out.println("Restaurants load !");
                    break;

                case 8:
                    System.out.println("Byebye !");
                    break;

                default:
                    System.out.println("Invalid Choice, try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
