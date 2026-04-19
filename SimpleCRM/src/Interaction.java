public class Interaction {
    private int interactionId;
    private int contactId;
    private String date;
    private String note;

    public Interaction(int interactionId, int contactId, String date, String note) {
        this.interactionId = interactionId;
        this.contactId = contactId;
        setDate(date);
        setNote(note);
    }

    public int getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(int interactionId) {
        if (interactionId > 0) {
            this.interactionId = interactionId;
        }
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        if (contactId > 0) {
            this.contactId = contactId;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()) {
            this.date = date.trim();
        } else {
            this.date = "No date";
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        if (note != null && !note.trim().isEmpty()) {
            this.note = note.trim();
        } else {
            this.note = "No note";
        }
    }

    @Override
    public String toString() {
        return interactionId + "," + contactId + "," + date + "," + note;
    }

    public String displayInteraction() {
        return "Interaction ID: " + interactionId +
                ", Contact ID: " + contactId +
                ", Date: " + date +
                ", Note: " + note;
    }
}