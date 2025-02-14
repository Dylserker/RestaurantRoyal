package RestaurantRoyal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = null;
        Menu menu = null;

        while (true) {
            System.out.println("\n Restaurant Manager");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Employe a restaurant");
            System.out.println("3. Add Menu");
            System.out.println("4. Take an order");
            System.out.println("5. Display employe");
            System.out.println("6. Display orders");
            System.out.println("7. Save order");
            System.out.println("8. Load order");
            System.out.println("9. View restaurant details");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID a restaurant: ");
                    int idRestaurant = scanner.nextInt();
                    String fileName = "restaurant"+ idRestaurant +".txt";
                    Restaurant.createOrder(fileName);
                    System.out.print("Create restaurant!");
                    scanner.nextLine();
                    System.out.print("Enter restaurant name: ");
                    String restaurantName = scanner.nextLine();
                    System.out.print("Enter restaurant address: ");
                    String restaurantAddress = scanner.nextLine();
                    System.out.print("Enter menu name: ");
                    String menuName = scanner.nextLine();
                    menu = new Menu(1, menuName, LocalDate.now(), "Generaly");
                    restaurant = new Restaurant(idRestaurant, restaurantName, restaurantAddress, menu);

                    System.out.println("Restaurant create successfully !");
                    break;

                case 2:
                    if (restaurant != null) {
                        System.out.print("Enter add a restaurant: ");
                        break;
                    }
                    System.out.print("Enter ID a employe: ");
                    int idEmployee = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("name: ");
                    String employeeName = scanner.nextLine();
                    System.out.print("first name: ");
                    String employeeFirstName = scanner.nextLine();
                    System.out.print("role: ");
                    String employeeRole = scanner.nextLine();
                    System.out.print("salary: ");
                    double employeeSalary = scanner.nextDouble();
                    scanner.nextLine();
                    Employe employe = new Employe(idEmployee, employeeName, employeeFirstName, employeeRole, "Today", employeeSalary);
                    restaurant.addEmployee(employe);
                    System.out.println("Employee create successfully !");
                    break;

                case 3:
                    if (restaurant == null) {
                        System.out.print("Add first of all a restaurant: ");
                        break;
                    }
                    System.out.print("Name a flat : ");
                    String flatName = scanner.nextLine();
                    System.out.print("Description a flat : ");
                    String flatDescription = scanner.nextLine();
                    System.out.print("Price a flat : ");
                    double flatPrice = scanner.nextDouble();
                    scanner.nextLine();
                    Flat flat= new Flat (flatName, flatDescription, flatPrice, 500, "Categorie", 500.0, LocalDate.now(), true, Arrays.asList("Ingredient1", "Ingredient2"), "Kitchen", 15,0, "🍽️");
                    restaurant.getMenu().addFlat(flat);
                    System.out.println("Flat add successfully !");
                    break;

                case 4:
                    if (restaurant == null) {
                        System.out.print("Add first of all a restaurant: ");
                        break;
                    }
                    System.out.print("Number order : ");
                    int orderNumber = scanner.nextInt();
                    scanner.nextLine();
                    Order order = new Order(orderNumber);
                    String answer;
                    do {
                        System.out.print("Name a added flat: ");
                        String nameFlatOrder = scanner.nextLine();
                        Flat flatOrder = restaurant.getMenu().searchFlatByName(nameFlatOrder);
                        if (flatOrder != null) {
                            order.addFlat(flatOrder);
                            System.out.println("Flat add a order !");
                        } else {
                            System.out.println("Flat doesn't exist !");
                        }
                        System.out.print("Add a other flat ? (yes/no) ");
                        answer = scanner.nextLine();
                    } while (answer.equalsIgnoreCase("yes"));
                    restaurant.addOrder(order);
                    System.out.println("Order saved !");
                    break;

                case 5:
                    if (restaurant == null) {
                        System.out.print("Add first of all a restaurant: ");
                        break;
                    }
                    restaurant.displayEmploye();
                    break;

                case 6:
                    if (restaurant == null) {
                        System.out.print("Add first of all a restaurant: ");
                        break;
                    }
                    restaurant.displayOrder();
                    break;

                case 7:
                    if (restaurant == null) {
                        System.out.print("Add first of all a restaurant: ");
                        break;
                    }
                    restaurant.saveOrder("order.txt");
                    break;

                case 8:
                    if (restaurant == null) {
                        System.out.print("Add first of all a restaurant: ");
                        break;
                    }
                    restaurant.changeOrder("order.txt");
                    break;

                case 9:
                    if (restaurant == null) {
                        System.out.print("Add first of all a restaurant: ");
                        break;
                    }
                    restaurant.displayRestaurant();
                    break;

                case 10:
                    System.out.print("Program closing");
                    scanner.close();
                    return;

                default:
                    System.out.print("Invalid choice, please try again.");
            }
        }
    }
}
