package Commands;
import DataBases.DbRestaurant;
import Models.Restaurant;

import java.util.ArrayList;

public class PrintRestaurantList extends Command {
    public DbRestaurant dbRestaurant;

    public PrintRestaurantList(DbRestaurant dbRestaurant) {
        this.dbRestaurant = dbRestaurant;
    }

    @Override
    public String getLabel() {
        return "Lister les restaurants";
    }

    @Override
    public void execute() {
        ArrayList<Restaurant> restaurants = dbRestaurant.getRestaurants();

        for (int i = 0; i < restaurants.size(); i++) {
            System.out.printf("%d. %s\n", i+1, restaurants.get(i).getName());
        }
    }
}
