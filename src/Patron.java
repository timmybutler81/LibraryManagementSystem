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
