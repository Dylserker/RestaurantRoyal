package RestaurantRoyal;
import java.time.LocalDate;
import java.util.List;

public class Flat {
    private String name;
    private String description;
    private double price;
    private int calorie;
    private String category;
    private double serving_size;
    private LocalDate date_added;
    private boolean availabily;
    private List<String> ingredient;
    private String typeKitchen;
    private int timePreparation;
    private double specialPrice;
    private String emoji;

    public Flat(String name, String description, double price, int calorie, String category, double serving_size, LocalDate date_added, boolean availabily, List<String> ingredient, String typeKitchen, int timePreparation, double specialPrice, String emoji) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calorie = calorie;
        this.category = category;
        this.serving_size = serving_size;
        this.date_added = date_added;
        this.availabily = availabily;
        this.ingredient = ingredient;
        this.typeKitchen = typeKitchen;
        this.timePreparation = timePreparation;
        this.specialPrice = specialPrice;
        this.emoji = emoji;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public double getServing_size() {
        return serving_size;
    }

    public void setServing_size(double serving_size) {
        this.serving_size = serving_size;
    }

    public LocalDate getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDate date_added) {
        this.date_added = date_added;
    }

    public boolean isAvailabily() {
        return availabily;
    }

    public void setAvailabily(boolean availabily) {
        this.availabily = availabily;
    }

    public List<String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<String> ingredient) {
        this.ingredient = ingredient;
    }

    public String getTypeKitchen() {
        return typeKitchen;
    }

    public void setTypeKitchen(String typeKitchen) {
        this.typeKitchen = typeKitchen;
    }

    public int getTimePreparation() {
        return timePreparation;
    }

    public void setTimePreparation(int timePreparation) {
        this.timePreparation = timePreparation;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "name=" + name +
                "description=" + description +
                "price=" + price +
                "calorie=" + calorie +
                "category=" + category +
                "serving_size=" + serving_size +
                "date_added=" + date_added +
                "availabily=" + availabily +
                "ingredient=" + ingredient +
                "typeKitchen=" + typeKitchen +
                "timePreparation=" + timePreparation +
                "specialPrice=" + specialPrice +
                "emoji=" + emoji +
                "}";
    }
}
