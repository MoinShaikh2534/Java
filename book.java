import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Book {
    int bookID;
    String bookName;
    String author;
    String publisher;
    int quantity;

    public Book(int bookID, String bookName, String author, String publisher, int quantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book [ID=" + bookID + ", Name=" + bookName + ", Author=" + author + ", Publisher=" + publisher + ", Quantity=" + quantity + "]";
    }
}

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a book");
            System.out.println("2. Display size of ArrayList");
            System.out.println("3. Display all books");
            System.out.println("4. Remove a book by ID");
            System.out.println("5. Display all books after removal");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter Book ID: ");
                    int bookID = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Publisher Name: ");
                    String publisher = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    bookList.add(new Book(bookID, bookName, author, publisher, quantity));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    // Display size of ArrayList
                    System.out.println("Size of the ArrayList: " + bookList.size());
                    break;

                case 3:
                    // Display all books
                    System.out.println("\nAll books in the list:");
                    for (Book book : bookList) {
                        System.out.println(book);
                    }
                    break;

                case 4:
                    // Remove a book by ID
                    System.out.print("Enter Book ID to remove: ");
                    int removeID = sc.nextInt();
                    boolean removed = bookList.removeIf(book -> book.bookID == removeID);
                    if (removed) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    // Display all books after removal
                    System.out.println("\nBooks in the list after removal:");
                    for (Book book : bookList) {
                        System.out.println(book);
                    }
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}