/**
 * Timothy Butler
 * CEN 3024C - Software Development 1
 * May 16, 2025,
 * LibrarySystem.java
 * This class is where the main crud operations happen. The goal is abstraction from the main method and
 * this class can be instantiated from main to perform these functions.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    List<Patron> patronList = new ArrayList<>();
    Validator validator = new Validator();

    /**
     * method: addPatron
     * parameters: id, name, address, overdueFine
     * return: void
     * purpose: adds a patron object to the patronList
     */
    public void addPatron(int id, String name, String address, double overdueFine) {

        Patron patron = new Patron(id, name, address, overdueFine);
        patronList.add(patron);
        System.out.println(patron.toString());
        System.out.println();
        displayAllPatrons();
    }

    /**
     * method: removePatron
     * parameters: id
     * return: void
     * purpose: removes a patron object from the patronList
     */
    public void removePatron(int id) {

        if (findPatronById(id) == null) {
            System.out.println("Patron does not exist in the system");
            return;
        }

        Patron tempPatron = findPatronById(id);

        patronList.remove(tempPatron);
        System.out.println("Patron ID: " + id + " has been removed.");
        System.out.println();
        displayAllPatrons();
    }

    /**
     * method: displayAllPatrons
     * parameters:
     * return: void
     * purpose: displays a list of patron objects in patronList
     */
    public void displayAllPatrons() {
        if (patronList.isEmpty()) {
            System.out.println("No Patrons exist in the system");
            return;
        }

        System.out.println("Here is a list of all Patrons:");
        System.out.println();
        for (Patron patron : patronList) {
            System.out.println(patron.toString());
        }
        System.out.println();

    }

    /**
     * method: loadPatronsFromFile
     * parameters: filePath
     * return: boolean
     * purpose: reads a file for data and loads patrons into the patronList
     */
    public boolean loadPatronsFromFile(String filePath) {
        List<Patron> tempList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length != 4) {
                    System.out.println("File has incorrect data formatting - missing data");
                    bufferedReader.close();
                    return false;
                }
                String idStr = parts[0].trim();
                String name = parts[1].trim();
                String address = parts[2].trim();
                String fine = parts[3].trim();

                if (!validator.validateIdFormat(idStr) || !validator.validateNameFormat(name) || !validator.validateAddressFormat(address) || !validator.validateFineFormat(fine)) {
                    System.out.println("File has incorrect data formatting");
                    bufferedReader.close();
                    return false;
                }

                if (findPatronById(Integer.parseInt(idStr)) != null) {
                    System.out.println("Duplicate ID found in file. ID: " + Integer.parseInt(idStr));
                    return false;
                }

                Patron addPatron = new Patron(Integer.parseInt(idStr), name, address, Double.parseDouble(fine));
                tempList.add(addPatron);

            }
            bufferedReader.close();
            patronList.addAll(tempList);
            displayAllPatrons();
            return true;

        } catch (IOException ioException) {
            System.out.println("Could not find file.");
            return false;
        }

    }

    /**
     * method: findPatronById
     * parameters: id
     * return: Patron object
     * purpose: looks up patron by id in the patronList
     */
    public Patron findPatronById(int id) {
        for (Patron patron : patronList) {
            if (patron.getId() == id) {
                return patron;
            }
        }
        return null;
    }
}
