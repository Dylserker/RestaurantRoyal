package RestaurantRoyal;

class Dish {
    private String name, description, category, typeKitchen;
    private double price;
    private int calory, timePreparation;

    public Dish(String name, String description, String category, double price, int calory, int timePreparation) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.calory = calory;
        this.timePreparation = timePreparation;
        this.typeKitchen = typeKitchen;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + description + " - Price : " + price + "$ - calory : " + calory + " - Type : " + typeKitchen;
    }
}



