package RestaurantRoyal;

import java.util.ArrayList;

class Employee {
    private int id;
    private String name, first_name, role, date_of_hire;
    private double salary;

    public Employee(int id, String name, String first_name, String role, String date_of_hire, double salary) {
        this.id = id;
        this.name = name;
        this.first_name = first_name;
        this.role = role;
        this.date_of_hire = date_of_hire;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employé #" + id + " : " + name + " " + first_name + " (" + role + "), Salary : " + salary + "$, Date of hire : " + date_of_hire;
    }

    public String toFile() {
        return id + "," + name + "," + first_name + "," + role + "," + date_of_hire + "," + date_of_hire + "," + salary;
    }

    public static Employee fromFile(String file) {
        String[] parts = file.split(",");
        return new Employee(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], Double.parseDouble(parts[5]));
    }
}
