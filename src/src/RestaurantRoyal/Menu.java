package RestaurantRoyal;
import java.util.*;

import java.util.ArrayList;

class Menu {
    private List<Dish> dishAvailable = new ArrayList<>();

    public void addDish(Dish dish) {
        dishAvailable.add(dish);
    }

    public void displayMenu() {
        for (Dish dish : dishAvailable) {
            System.out.println(dish);
        }
    }
}
