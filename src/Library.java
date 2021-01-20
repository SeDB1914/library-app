import java.lang.String;
import java.util.ArrayList;


public class Library {

        String libraryAddress;
         ArrayList<Book> books;

    public Library(String address) {
        libraryAddress = address;
        books = new ArrayList<>();
    }

    public static void printOpeningHours() {
        System.out.println("Monday thru Friday 9AM - 6PM, Saturday 10AM - 4PM, Closed Sunday");
    }


    public void addBook(Book book) {
        books.add(book);
    }

    public void printAddress() {
        System.out.println(libraryAddress);
    }


    public void borrowBook(String bookTitle) {
        Book libBook;
        String libBookTitle;

        for (Book book : books) {
            libBook = book;
          libBookTitle = libBook.getTitle();
            if (bookTitle.equals(libBookTitle)) {
                if (!(libBook.isBorrowed())) {
                    libBook.isBorrowed();
                    System.out.printf("You have checked out %s.\n", libBookTitle);
                } else {
                    System.out.printf("Sorry, %s is not available right now.\n", libBookTitle);
                }
            }
        }
            }

    public void returnBook(String bookTitle) {
        Book libBook;
        String libBookTitle;
        boolean available = false;
        for (Book book : books) {
            libBook = book;
            libBookTitle = libBook.getTitle();
            if (libBookTitle.equals(bookTitle)) {
                if (libBook.isBorrowed()) {
                    libBook.returned();
                    System.out.printf("Thank you for returning %s.", libBookTitle);
                    available = true;
                    break;
                }
            }
        }
        if(!available) {
            System.out.println(" Sorry, that is not in our catalog.");

        }

    }

    public void printAvailableBooks() {
       Book libBook;
       boolean bookUnavailable = true;

        for (Book book : books) {
            libBook = book;
            if (!(libBook.isBorrowed())) {
                System.out.println(libBook.getTitle());
                bookUnavailable = false;
            }
        }
        if (bookUnavailable) {
            System.out.println("No available books in catalog.");
        }
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryAddress='" + libraryAddress + '\'' +
                ", books=" + books +
                '}';
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours: ");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }




}