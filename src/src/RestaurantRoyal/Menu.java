package RestaurantRoyal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int idMenu;
    private String nameMenu;
    private LocalDate creationDate;
    private String typeMenu;
    private List<Flat> flatList;

    public Menu(int idMenu, String nameMenu, LocalDate creationDate, String typeMenu) {
        this.idMenu = idMenu;
        this.nameMenu = nameMenu;
        this.creationDate = creationDate;
        this.typeMenu = typeMenu;
        this.flatList = new ArrayList<>();
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }

    public void addFlat(Flat flat) {
        flatList.add(flat);
    }

    public void deleteFlat(Flat flat) {
        flatList.remove(flat);
    }

    public void printMenu() {
        if (flatList.isEmpty()) {
            System.out.println("Menu empty");
        } else {
            System.out.println("Menu: + nameMenu");
            for (Flat flat : flatList) {
                System.out.println(flat.toString());
            }
        }
    }

    public Flat searchFlatByName(String name) {
        for (Flat flat : flatList) {
            if (flat.getName().equalsIgnoreCase(name)) {
                return flat;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                "nameMenu=" + nameMenu +
                "creationDate=" + creationDate +
                "typeMenu=" + typeMenu +
                "flatList=" + flatList.size() + "flat" +
                '}';
    }
}
