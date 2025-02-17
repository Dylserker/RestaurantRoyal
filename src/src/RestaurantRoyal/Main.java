package RestaurantRoyal;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Restaurant> restaurants = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== MENU UTILISATEUR ===");
            System.out.println("1. Ajouter un restaurant");
            System.out.println("2. Ajouter un employé à un restaurant");
            System.out.println("3. Afficher les employés d'un restaurant");
            System.out.println("4. Sauvegarder les employés d'un restaurant");
            System.out.println("5. Charger les employés d'un restaurant");
            System.out.println("6. Sauvegarder tous les restaurants");
            System.out.println("7. Charger tous les restaurants");
            System.out.println("8. Quitter");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Éviter le problème du retour à la ligne

            switch (choice) {
                case 1:
                    System.out.print("Nom du restaurant : ");
                    String restaurantName = scanner.nextLine();
                    System.out.print("Adresse du restaurant : ");
                    String restaurantAddress = scanner.nextLine();
                    Restaurant newRestaurant = new Restaurant(restaurants.size() + 1, restaurantName, restaurantAddress);
                    restaurants.add(newRestaurant);
                    System.out.println("Restaurant ajouté avec succès !");
                    break;

                case 2:
                    if (restaurants.isEmpty()) {
                        System.out.println("Ajoutez un restaurant d'abord.");
                        break;
                    }
                    System.out.println("Choisissez un restaurant par ID : ");
                    for (Restaurant r : restaurants) {
                        System.out.println(r.getId() + ": " + r.getName());
                    }
                    System.out.print("ID du restaurant : ");
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
                        System.out.println("Restaurant non trouvé.");
                        break;
                    }

                    System.out.print("Nom de l'employé : ");
                    String name = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String firstName = scanner.nextLine();
                    System.out.print("Rôle : ");
                    String role = scanner.nextLine();
                    System.out.print("Date d'embauche : ");
                    String dateOfHire = scanner.nextLine();
                    System.out.print("Salaire : ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();

                    Employee newEmployee = new Employee(restaurantId, name, firstName, role, dateOfHire, salary);
                    selectedRestaurant.addEmployee(newEmployee);
                    System.out.println("Employé ajouté avec succès !");
                    break;

                case 3:
                    if (restaurants.isEmpty()) {
                        System.out.println("Aucun restaurant enregistré.");
                        break;
                    }
                    System.out.println("Choisissez un restaurant pour afficher ses employés :");
                    for (Restaurant r : restaurants) {
                        System.out.println(r.getId() + ": " + r.getName());
                    }
                    System.out.print("ID du restaurant : ");
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
                        System.out.println("Restaurant non trouvé.");
                    }
                    break;

                case 4:
                    if (restaurants.isEmpty()) {
                        System.out.println("Aucun restaurant enregistré.");
                        break;
                    }
                    System.out.println("Choisissez un restaurant pour sauvegarder ses employés :");
                    for (Restaurant r : restaurants) {
                        System.out.println(r.getId() + ": " + r.getName());
                    }
                    System.out.print("ID du restaurant : ");
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
                        System.out.println("Employés sauvegardés !");
                    } else {
                        System.out.println("Restaurant non trouvé.");
                    }
                    break;

                case 5:
                    if (restaurants.isEmpty()) {
                        System.out.println("Aucun restaurant enregistré.");
                        break;
                    }
                    System.out.println("Choisissez un restaurant pour charger ses employés :");
                    for (Restaurant r : restaurants) {
                        System.out.println(r.getId() + ": " + r.getName());
                    }
                    System.out.print("ID du restaurant : ");
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
                        System.out.println("Employés chargés !");
                    } else {
                        System.out.println("Restaurant non trouvé.");
                    }
                    break;

                case 6:
                    System.out.print("Nom du fichier de sauvegarde : ");
                    String saveFile = scanner.nextLine();
                    Restaurant.saveRestaurantsToFile(saveFile, restaurants);
                    System.out.println("Restaurants sauvegardés !");
                    break;

                case 7:
                    System.out.print("Nom du fichier à charger : ");
                    String loadFile = scanner.nextLine();
                    restaurants = Restaurant.loadRestaurantsFromFile(loadFile);
                    System.out.println("Restaurants chargés !");
                    break;

                case 8:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
