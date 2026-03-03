public class Book {
    protected String title;
    protected String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getFormat() {
        return "Generic book format";
    }
}