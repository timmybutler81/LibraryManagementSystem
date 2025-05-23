/**
 * Timothy Butler
 * CEN 3024C - Software Development 1
 * May 16, 2025,
 * Patron.java
 * This class is used to create the patron object that will be stored in memory for all patrons created
 */

public class Patron {
    private final int id;
    private final String name;
    private final String address;
    private final double overdueFine;

    public Patron(int id, String name, String address, double overdueFine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.overdueFine = overdueFine;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getOverdueFine() {
        return overdueFine;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " Name: " + getName() + " Address: " + getAddress() + " Overdue Fine: $" + getOverdueFine();
    }
}
