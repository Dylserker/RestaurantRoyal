package RestaurantRoyal;
import java.util.*;

class Order {
    private int numberOrder;
    private List<Dish> dishes = new ArrayList<>();

    public Order(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public double calculateTotal() {
        return dishes.stream().mapToDouble(p -> p.getPrice()).sum();
    }

    @Override
    public String toString() {
        return "Order #" + numberOrder + " - Total : " + calculateTotal() + "$";
    }
}
