public class Validator {

    public Validator() {

    }

    public boolean validateIdFormat(String id) {

        try {
            Integer.parseInt(id);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("You can only enter numbers. Please try again.");
            return false;
        }

        if (id.length() != 7) {
            System.out.println("Entry can only be seven digits.");
            return false;
        }

        return true;
    }

    public boolean validateNameFormat(String name) {
        if (name == null) {
            System.out.println("Name cannot be empty");
            return false;
        }

        if (!name.matches("[a-zA-Z. ]+")) {
            System.out.println("Name can only contain letters, spaces and periods.");
            return false;
        }

        return true;
    }

    public boolean validateAddressFormat(String address) {
        if (address == null) {
            System.out.println("Address cannot be empty");
            return false;
        }

        if (!address.matches("[a-zA-Z0-9.,# ]+")) {
            System.out.println("Address can only contain letters, numbers, spaces, commas, hash marks and periods.");
            return false;
        }

        return true;
    }

    public boolean validateFineFormat(String fine) {

        if (!fine.matches("-?\\d+(\\.\\d{1,2})?")) {
            System.out.println("You can only enter numbers and up to two decimal places. Please try again.");
            return false;
        }

        double fineValue = Double.parseDouble(fine);
        if (fineValue < 0 || fineValue > 250) {
            System.out.println("Entry must be between $0 and $250");
            return false;
        }

        return true;
    }
}
