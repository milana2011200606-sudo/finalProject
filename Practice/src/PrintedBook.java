public class PrintedBook extends Book {

    public PrintedBook(String title, String author) {
        super(title, author);
    }

    @Override
    public String getFormat() {
        return "Paper format";
    }
}