public class Contact extends Person {
    private String phone;
    private String email;

    public Contact(int id, String name, String phone, String email) {
        super(id, name);
        setPhone(phone);
        setEmail(email);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone.trim();
        } else {
            this.phone = "No phone";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && !email.trim().isEmpty()) {
            this.email = email.trim();
        } else {
            this.email = "Invalid email";
        }
    }

    @Override
    public String displayInfo() {
        return "ID: " + getId() +
                ", Name: " + getName() +
                ", Phone: " + phone +
                ", Email: " + email;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + phone + "," + email;
    }
}