import java.util.ArrayList;

public class CRMManager {
    private ArrayList<Contact> contacts;
    private ArrayList<Interaction> interactions;

    public CRMManager() {
        contacts = new ArrayList<>();
        interactions = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n--- Contact List ---");
        for (Contact contact : contacts) {
            System.out.println(contact.displayInfo());
        }
    }

    public Contact findContactById(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    public void updateContact(int id, String newName, String newPhone, String newEmail) {
        Contact contact = findContactById(id);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        contact.setName(newName);
        contact.setPhone(newPhone);
        contact.setEmail(newEmail);
        System.out.println("Contact updated successfully.");
    }

    public void deleteContact(int id) {
        Contact contact = findContactById(id);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        contacts.remove(contact);

        interactions.removeIf(interaction -> interaction.getContactId() == id);

        System.out.println("Contact deleted successfully.");
    }

    public void addInteraction(Interaction interaction) {
        Contact contact = findContactById(interaction.getContactId());

        if (contact == null) {
            System.out.println("Cannot add interaction. Contact not found.");
            return;
        }

        interactions.add(interaction);
        System.out.println("Interaction added successfully.");
    }

    public void viewInteractionsByContactId(int contactId) {
        boolean found = false;

        System.out.println("\n--- Interactions for Contact ID: " + contactId + " ---");
        for (Interaction interaction : interactions) {
            if (interaction.getContactId() == contactId) {
                System.out.println(interaction.displayInteraction());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No interactions found for this contact.");
        }
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setInteractions(ArrayList<Interaction> interactions) {
        this.interactions = interactions;
    }
}