import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        books.add(new EBook("Java Basics", "Milana"));
        books.add(new PrintedBook("OOP Guide", "Ali"));

        for (Book book : books) {
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Format: " + book.getFormat());
            System.out.println();
        }
    }
}