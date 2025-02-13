package RestaurantRoyal;

public class Employe {
    private int idEmploye;
    private String name;
    private String first_name;
    private String role;
    private String date_of_hire;
    private double salary;


    public Employe(int idEmploye, String name, String first_name, String role, String date_of_hire, double salary) {
        this.idEmploye = idEmploye;
        this.name = name;
        this.first_name = first_name;
        this.role = role;
        this.date_of_hire = date_of_hire;
        this.salary = salary;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getFirst_Name() {
        return first_name;
    }

    public void setFirst_Name(String first_name) {
        this.first_name = first_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDate_of_hire() {
        return date_of_hire;
    }

    public void setDate_of_hire() {
        this.date_of_hire = date_of_hire;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "idEmploye=" + idEmploye +
                "name=" + name +
                "first_name=" + first_name +
                "date_of_hire=" + date_of_hire +
                "salary=" + salary +
                '}';
    }
}