/**
 * Timothy Butler
 * CEN 3024C - Software Development 1
 * May 16, 2025,
 * Main.java
 * This class is our main program that handles the core logic. The intended behavior is for the user to have
 * a menu that appears and loops until they exit. They can perform four actions add, remove, display and load from file.
 * The design is that the main is left minimal and the logic is in displayMenu() and handleUserInput() to keep
 * the logic broken out.
 */

import java.util.Scanner;

public class Main {
    public static LibrarySystem librarySystem = new LibrarySystem();
    public static Scanner scanner = new Scanner(System.in);
    public static Validator validator = new Validator();

    public static void main(String[] args) {

        displayMenu();
    }

    /**
     * method: displayMenu
     * parameters: none
     * return: void
     * purpose: Creates a looped menu that accepts user input on the menu option and sends input
     * to handleUserInput()
     */
    public static void displayMenu() {
        int selectedAction = Integer.MIN_VALUE;
        int count = 0;

        while (selectedAction != 5) {

            if (count == 0) {
                System.out.println("Welcome to the Library Management System");
            }

            System.out.println("Please type the number of the action you want to take");
            System.out.println("1. Add Patron");
            System.out.println("2. Remove Patron");
            System.out.println("3. Display Patrons");
            System.out.println("4. Load Patrons from File");
            System.out.println("5. Exit");

            if (selectedAction == 0 || selectedAction >= 6) {
                System.out.println("Please enter a valid option");
            }

            Scanner scanner = new Scanner(System.in);
            selectedAction = scanner.nextInt();
            handleUserInput(selectedAction);
            count++;
        }

        System.out.println("Thank you for using the Library Management System. Exiting...");
        scanner.close();

    }

    /**
     * method: handleUserInput
     * parameters: selection
     * return: void
     * purpose: Handles the action taken from the menu options by calling necessary functions to process
     * the users request
     */
    public static void handleUserInput(int selection) {

        switch (selection) {
            case 1: //add
                handleAddPatron();
                break;
            case 2: //remove
                System.out.println("Please enter the id to remove");
                int tempNumber = scanner.nextInt();
                librarySystem.removePatron(tempNumber);
                break;
            case 3: //display all
                librarySystem.displayAllPatrons();
                break;
            case 4: //load from file
                System.out.println("Enter the path where your file exists ");
                String filePath = scanner.nextLine();
                librarySystem.loadPatronsFromFile(filePath);
                break;
        }
    }

    /**
     * method: handleAddPatron
     * parameters: none
     * return: void
     * purpose: Handles the adding of patron on screen prompts to properly loop through options
     * and validation
     */
    public static void handleAddPatron() {
        String inputId;
        int id;
        while (true) {
            System.out.println("Please enter the ID: ");
            inputId = scanner.nextLine();
            if (validator.validateIdFormat(inputId)) {
                id = Integer.parseInt(inputId);
                if (librarySystem.findPatronById(id) != null) {
                    System.out.println("Duplicate ID found in file. ID: " + id);
                    continue;
                }
                break;
            }
        }

        String inputName;
        while (true) {
            System.out.println("Please enter the Name: ");
            inputName = scanner.nextLine();
            if (!validator.validateNameFormat(inputName)) {
                continue;
            }
            break;
        }

        String inputAddress;
        while (true) {
            System.out.println("Please enter the Address: ");
            inputAddress = scanner.nextLine();
            if (!validator.validateAddressFormat(inputAddress)) {
                continue;
            }
            break;
        }

        String inputOverdueFine;
        while (true) {
            System.out.println("Please enter the Overdue Fine Amount: ");
            inputOverdueFine = scanner.nextLine();
            if (!validator.validateFineFormat(inputOverdueFine)) {
                continue;
            }
            break;
        }

        librarySystem.addPatron(Integer.parseInt(inputId), inputName, inputAddress, Double.parseDouble(inputOverdueFine));
    }
}