import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String CONTACTS_FILE = "contacts.txt";
    private static final String INTERACTIONS_FILE = "interactions.txt";

    public static void saveContacts(ArrayList<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTACTS_FILE))) {
            for (Contact contact : contacts) {
                writer.write(contact.toString());
                writer.newLine();
            }
            System.out.println("Contacts saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public static ArrayList<Contact> loadContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();

        File file = new File(CONTACTS_FILE);
        if (!file.exists()) {
            return contacts;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(CONTACTS_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 4);

                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phone = parts[2];
                    String email = parts[3];

                    contacts.add(new Contact(id, name, phone, email));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }

        return contacts;
    }

    public static void saveInteractions(ArrayList<Interaction> interactions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INTERACTIONS_FILE))) {
            for (Interaction interaction : interactions) {
                writer.write(interaction.toString());
                writer.newLine();
            }
            System.out.println("Interactions saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving interactions: " + e.getMessage());
        }
    }

    public static ArrayList<Interaction> loadInteractions() {
        ArrayList<Interaction> interactions = new ArrayList<>();

        File file = new File(INTERACTIONS_FILE);
        if (!file.exists()) {
            return interactions;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(INTERACTIONS_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 4);

                if (parts.length == 4) {
                    int interactionId = Integer.parseInt(parts[0]);
                    int contactId = Integer.parseInt(parts[1]);
                    String date = parts[2];
                    String note = parts[3];

                    interactions.add(new Interaction(interactionId, contactId, date, note));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading interactions: " + e.getMessage());
        }

        return interactions;
    }
}