import java.util.Scanner;

class Author {
    private String name, email, gender;

    public Author(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + " (" + gender + "), Email: " + email;
    }
}

class Book {
    private String title;
    private double price;
    private Author author;

    public Book(String title, double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book: " + title + "\nPrice: " + format(price)
                + "\nAuthor: " + author;
    }

    private String format(double value) {
        return value == (long) value ? String.valueOf((long) value) : String.valueOf(value);
    }
}

public class Q6_LibraryBookAuthor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] p = sc.nextLine().split(",", 5);

        Author author = new Author(p[2].trim(), p[3].trim(), p[4].trim());
        Book book = new Book(p[0].trim(), Double.parseDouble(p[1].trim()), author);

        System.out.println(book);
        sc.close();
    }
}
