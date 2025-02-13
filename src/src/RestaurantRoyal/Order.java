package RestaurantRoyal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int numberOrder;
    private List<Flat> flat;
    private double total;

    public Order(int numberOrder) {
        this.numberOrder = numberOrder;
        this.flat = new ArrayList<>();
        this.total = 0.0;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public List<Flat> getFlat() {
        return flat;
    }

    public void setFlat(List<Flat> flat) {
        this.flat = flat;
    }

    public double getTotal() {
        return total;
    }

    public void addFlat(Flat f) {
        flat.add(f);
        calculateTotal();
    }

    public void calculateTotal() {
        total = 0.0;
        for (Flat flat : flat) {
            total += flat.getSpecialPrice() > 0 ? flat.getSpecialPrice() : flat.getPrice();
        }
    }

    public void displayOrder() {
        if (flat.isEmpty()) {
            System.out.println("No order found");
        } else {
            System.out.println("Number of order: " + numberOrder);
            for (Flat flat : flat) {
                System.out.println(flat);
            }
            System.out.println("Total price: " + total + " $");
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "numberOrder=" + numberOrder +
                "number_of_flat=" + flat.size() +
                "total=" + total +
                '}';
    }
}
