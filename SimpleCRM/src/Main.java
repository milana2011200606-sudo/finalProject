import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CRMManager crm = new CRMManager();
        Scanner scanner = new Scanner(System.in);

        crm.setContacts(FileManager.loadContacts());
        crm.setInteractions(FileManager.loadInteractions());

        int choice;

        do {
            System.out.println("\n=== SIMPLE CRM MENU ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Add Interaction");
            System.out.println("6. View Interactions");
            System.out.println("7. Save Data");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter ID: ");
                    }
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Contact newContact = new Contact(id, name, phone, email);
                    crm.addContact(newContact);
                    break;

                case 2:
                    crm.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter Contact ID to update: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter Contact ID to update: ");
                    }
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("New Phone: ");
                    String newPhone = scanner.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = scanner.nextLine();

                    crm.updateContact(updateId, newName, newPhone, newEmail);
                    break;

                case 4:
                    System.out.print("Enter Contact ID to delete: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter Contact ID to delete: ");
                    }
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    crm.deleteContact(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Interaction ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter Interaction ID: ");
                    }
                    int interId = scanner.nextInt();

                    System.out.print("Enter Contact ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter Contact ID: ");
                    }
                    int contactId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Date: ");
                    String date = scanner.nextLine();

                    System.out.print("Enter Note: ");
                    String note = scanner.nextLine();

                    Interaction interaction = new Interaction(interId, contactId, date, note);
                    crm.addInteraction(interaction);
                    break;

                case 6:
                    System.out.print("Enter Contact ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter Contact ID: ");
                    }
                    int viewId = scanner.nextInt();
                    scanner.nextLine();

                    crm.viewInteractionsByContactId(viewId);
                    break;

                case 7:
                    FileManager.saveContacts(crm.getContacts());
                    FileManager.saveInteractions(crm.getInteractions());
                    break;

                case 0:
                    FileManager.saveContacts(crm.getContacts());
                    FileManager.saveInteractions(crm.getInteractions());
                    System.out.println("Data saved. Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}