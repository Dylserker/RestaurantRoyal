package RestaurantRoyal;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = null;

        while (true) {
            System.out.println("Menu utilisateur :");
            System.out.println("1. Ajouter un restaurant");
            System.out.println("2. Ajouter un employé à un restaurant");
            System.out.println("3. Ajouter un plat au menu d'un restaurant");
            System.out.println("4. Supprimer un employé d'un restaurant");
            System.out.println("5. Afficher les employés d'un restaurant");
            System.out.println("6. Prendre une commande pour un restaurant");
            System.out.println("7. Afficher toutes les commandes d'un restaurant");
            System.out.println("8. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez l'ID du restaurant : ");
                    int idRestaurant = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le nom du restaurant : ");
                    String nomRestaurant = scanner.nextLine();
                    System.out.print("Entrez l'adresse du restaurant : ");
                    String adresseRestaurant = scanner.nextLine();
                    restaurant = new Restaurant(idRestaurant, nomRestaurant, adresseRestaurant);
                    System.out.println("Restaurant ajouté avec succès !");
                    break;

                case 2:
                    if (restaurant == null) {
                        System.out.println("Veuillez d'abord ajouter un restaurant.");
                        break;
                    }
                    System.out.print("Entrez l'ID de l'employé : ");
                    int idEmploye = scanner.nextInt();
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    System.out.print("Entrez le nom de l'employé : ");
                    String nomEmploye = scanner.nextLine();
                    System.out.print("Entrez le prénom de l'employé : ");
                    String prenomEmploye = scanner.nextLine();
                    System.out.print("Entrez le rôle de l'employé : ");
                    String roleEmploye = scanner.nextLine();
                    System.out.print("Entrez la date d'embauche (YYYY-MM-DD) : ");
                    String dateEmbauche = scanner.nextLine();
                    System.out.print("Entrez le salaire de l'employé : ");
                    double salaireEmploye = scanner.nextDouble();
                    Employee employe = new Employee(idEmploye, nomEmploye, prenomEmploye, roleEmploye, dateEmbauche, salaireEmploye);
                    restaurant.ajouterEmploye(employe);
                    System.out.println("Employé ajouté avec succès !");
                    break;

                case 3:
                    if (restaurant == null) {
                        System.out.println("Veuillez d'abord ajouter un restaurant.");
                        break;
                    }
                    System.out.print("Entrez le nom du plat : ");
                    String nomPlat = scanner.nextLine();
                    System.out.print("Entrez la description du plat : ");
                    String descriptionPlat = scanner.nextLine();
                    System.out.print("Entrez le prix du plat : ");
                    double prixPlat = scanner.nextDouble();
                    System.out.print("Entrez les calories du plat : ");
                    int caloriesPlat = scanner.nextInt();
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    System.out.print("Entrez la catégorie du plat : ");
                    String categoriePlat = scanner.nextLine();
                    System.out.print("Entrez la taille de portion : ");
                    String taillePortionPlat = scanner.nextLine();
                    System.out.print("Entrez la date d'ajout (YYYY-MM-DD) : ");
                    String dateAjoutPlat = scanner.nextLine();
                    System.out.print("Le plat est-il disponible ? (true/false) : ");
                    boolean disponibilitePlat = scanner.nextBoolean();
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    System.out.print("Entrez les ingrédients : ");
                    String ingredientsPlat = scanner.nextLine();
                    System.out.print("Entrez le type de cuisine : ");
                    String typeCuisinePlat = scanner.nextLine();
                    System.out.print("Entrez le temps de préparation (en minutes) : ");
                    int tempsPreparationPlat = scanner.nextInt();
                    System.out.print("Entrez le prix spécial (0 si non applicable) : ");
                    double prixSpecialPlat = scanner.nextDouble();
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    System.out.print("Entrez l'URL de l'image : ");
                    String imageURLPlat = scanner.nextLine();
                    Dish plat = new Dish(nomPlat, descriptionPlat, prixPlat, caloriesPlat, categoriePlat, taillePortionPlat, dateAjoutPlat, disponibilitePlat, ingredientsPlat, typeCuisinePlat, tempsPreparationPlat, prixSpecialPlat, imageURLPlat);
                    restaurant.menu.ajouterPlat(plat);
                    System.out.println("Plat ajouté avec succès !");
                    break;

                case 4:
                    if (restaurant == null) {
                        System.out.println("Veuillez d'abord ajouter un restaurant.");
                        break;
                    }
                    System.out.print("Entrez l'ID de l'employé à supprimer : ");
                    int idEmployeASupprimer = scanner.nextInt();
                    Employee employeASupprimer = null;
                    for (Employee emp : restaurant.employes) {
                        if (emp.getId() == idEmployeASupprimer) {
                            employeASupprimer = emp;
                            break;
                        }
                    }
                    if (employeASupprimer != null) {
                        restaurant.supprimerEmploye(employeASupprimer);
                        System.out.println("Employé supprimé avec succès !");
                    } else {
                        System.out.println("Employé non trouvé.");
                    }
                    break;

                case 5:
                    if (restaurant == null) {
                        System.out.println("Veuillez d'abord ajouter un restaurant.");
                        break;
                    }
                    restaurant.afficherEmployes();
                    break;

                case 6:
                    if (restaurant == null) {
                        System.out.println("Veuillez d'abord ajouter un restaurant.");
                        break;
                    }
                    System.out.print("Entrez le numéro de la commande : ");
                    int numeroCommande = scanner.nextInt();
                    Order commande = new Order(numeroCommande);
                    while (true) {
                        System.out.print("Entrez le nom du plat à ajouter à la commande (ou 'fin' pour terminer) : ");
                        String nomPlatCommande = scanner.nextLine();
                        if (nomPlatCommande.equalsIgnoreCase("fin")) {
                            break;
                        }
                        Dish platCommande = restaurant.menu.chercherPlatParNom(nomPlatCommande);
                        if (platCommande != null) {
                            commande.ajouterPlat(platCommande);
                            System.out.println("Plat ajouté à la commande !");
                        } else {
                            System.out.println("Plat non trouvé dans le menu.");
                        }
                    }
                    restaurant.ajouterCommande(commande);
                    System.out.println("Commande prise avec succès !");
                    break;

                case 7:
                    if (restaurant == null) {
                        System.out.println("Veuillez d'abord ajouter un restaurant.");
                        break;
                    }
                    restaurant.afficherCommandes();
                    break;

                case 8:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
}