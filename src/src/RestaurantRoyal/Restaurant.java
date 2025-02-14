package RestaurantRoyal;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int idRestaurant;
    private String nameRestaurant;
    private String addressRestaurant;
    private Menu menu;
    private List<Order> orders;
    private List<Employe> employe;

    public Restaurant(int idRestaurant, String nameRestaurant, String addressRestaurant, Menu menu) {
        this.idRestaurant = idRestaurant;
        this.nameRestaurant = nameRestaurant;
        this.addressRestaurant = addressRestaurant;
        this.menu = menu;
        this.orders = new ArrayList<>();
        this.employe = new ArrayList<>();
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(String addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Employe> getEmploye() {
        return employe;
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public void displayOrder() {
        if (orders.isEmpty()) {
            System.out.println("There is no order");
        } else {
            System.out.println("Restaurant orders" + nameRestaurant + ":");
            for (Order o : orders) {
                System.out.println(o);
            }
        }
    }

    public void addEmployee(Employe e) {
        employe.add(e);
    }

    public void deleteEmployee(Employe e) {
        employe.remove(e);
    }

    public List<Employe> searchEmployeForRole(String role) {
        List<Employe> resultat = new ArrayList<>();
        for (Employe e : employe) {
            if (e.getRole().equalsIgnoreCase(role)) {
                resultat.add(e);
            }
        }
        return resultat;
    }

    public void displayEmploye() {
        if (employe.isEmpty()) {
            System.out.println("There is no employee");
        } else {
            System.out.println("Restaurant employees" + nameRestaurant + ":");
            for (Employe e : employe) {
                System.out.println(e);
            }
        }
    }

    public static void createOrder(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File create : " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error while creating file :" + e.getMessage());
        }
    }

    public void saveOrder(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Order o : orders) {
                writer.write(orders.toString());
                writer.newLine();
            }
            System.out.println("Order saved successfully !!");
        } catch (IOException e) {
            System.out.println("Error while saving order : " + e.getMessage());
        }
    }

    public void changeOrder(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Order loaded : " + line);
            }
            System.out.println("Order loaded successfully !!");
        } catch (IOException e) {
            System.out.println("Error while loading order : " + e.getMessage());
        }
    }

    public double totalSalaryEmploye() {
        double total = 0;
        for (Employe e : employe) {
            total += e.getSalary();
        }
        return total;
    }

    public double totalTurnover() {
        double total = 0;
        for (Order o : orders) {
            total += o.getTotal();
        }
        return total;
    }

    public void displayRestaurant() {
        System.out.println("Restaurant: " + nameRestaurant);
        System.out.println("Address: " + addressRestaurant);
        System.out.println("Menu: " + menu.getNameMenu());
        System.out.println("Number of employe: " + employe.size());
        System.out.println("Number of orders: " + orders.size());
        System.out.println("Total salary employe: " + totalSalaryEmploye() + " $");
        System.out.println("Total turnover employe: " + totalTurnover() + " $");
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "idRestaurnant=" + idRestaurant +
                "nameRestaurant=" + nameRestaurant +
                "address=" + addressRestaurant +
                "menu=" + menu.getNameMenu() +
                "number Order=" + orders.size() +
                "number employe=" + employe.size() +
                '}';
    }
}
