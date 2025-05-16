/**
 * Timothy Butler
 * CEN 3024C - Software Development 1
 * May 16, 2025,
 * Validator.java
 * This class is to abstract away the validation logic, so it can be reused in more than one place.
 * It has a list of validation methods to ensure all data excepted is properly formatted.
 */

public class Validator {

    public Validator() {

    }

    /**
     * method: validateIdFormat
     * parameters: id
     * return: boolean
     * purpose: validates that the id is a number and is 7 digits
     */
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

    /**
     * method: validateNameFormat
     * parameters: name
     * return: boolean
     * purpose: validates that the name is not null and has no special characters except "," no numbers
     */
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

    /**
     * method: validateAddressFormat
     * parameters: name
     * return: boolean
     * purpose: validates that the address is not null and has no special characters except ".,#"
     */
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

    /**
     * method: validateFineFormat
     * parameters: fine
     * return: boolean
     * purpose: validates that the fine is a number, a double, only 2 decimal places and between 0-250
     */
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
