public class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            this.name = "Unknown";
        }
    }

    public String displayInfo() {
        return "ID: " + id + ", Name: " + name;
    }
}