import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class LibraryItem {
    String title;
    String author;
    String publicationDate;
    String ISBN;
    int availableQuantity;

    public LibraryItem(String title, String author, String publicationDate, String ISBN, int availableQuantity) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.ISBN = ISBN;
        this.availableQuantity = availableQuantity;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void validate() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        do {
            System.out.print("Enter ISBN (alphanumeric, specific length): ");
            String newISBN = scanner.nextLine();
            if (newISBN.matches("^[a-zA-Z0-9]{10}$")) {
                ISBN = newISBN;
                valid = true;
            } else {
                System.out.println("ISBN should be alphanumeric and have a length of 10 characters.");
            }
        } while (!valid);

        valid = false;
        do {
            System.out.print("Enter Publication Date (yyyy-mm-dd): ");
            String newPublicationDate = scanner.nextLine();
            if (newPublicationDate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                publicationDate = newPublicationDate;
                valid = true;
            } else {
                System.out.println("Publication date must be in the format yyyy-mm-dd.");
            }
        } while (!valid);

        valid = false;
        do {
            System.out.print("Enter Available Quantity (non-negative integer): ");
            String newAvailableQuantityStr = scanner.nextLine();
            if (newAvailableQuantityStr.matches("\\d+")) {
                int newAvailableQuantity = Integer.parseInt(newAvailableQuantityStr);
                if (newAvailableQuantity >= 0) {
                    availableQuantity = newAvailableQuantity;
                    valid = true;
                } else {
                    System.out.println("Available quantity should be a non-negative integer.");
                }
            } else {
                System.out.println("Available quantity should be a non-negative integer.");
            }
        } while (!valid);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publication Date: " + publicationDate
                + ", ISBN: " + ISBN + ", Available Quantity: " + availableQuantity;
    }
}

class Book extends LibraryItem {
    private String genre;

    public Book(String title, String author, String publicationDate, String ISBN, int availableQuantity, String genre) {
        super(title, author, publicationDate, ISBN, availableQuantity);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}

class Magazine extends LibraryItem {
    private String edition;

    public Magazine(String title, String author, String publicationDate, String ISBN, int availableQuantity, String edition) {
        super(title, author, publicationDate, ISBN, availableQuantity);
        this.edition = edition;
    }

    @Override
    public String toString() {
        return super.toString() + ", Edition: " + edition;
    }
}

class Newspaper extends LibraryItem {
    private String publisher;

    public Newspaper(String title, String author, String publicationDate, String ISBN, int availableQuantity, String publisher) {
        super(title, author, publicationDate, ISBN, availableQuantity);
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return super.toString() + ", Publisher: " + publisher;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();

        // Add sample items to the library
        libraryItems.add(new Book("Java Programming", "John Smith", "2022-10-15", "1234567890", 10, "Programming"));
        libraryItems.add(new Magazine("Tech Weekly", "Tech Publishing", "2022-10-21", "9876543210", 5, "October 2022"));
        libraryItems.add(new Newspaper("Daily News", "News Corp", "2022-10-20", "5432109876", 20, "Daily Times"));

        while (true) {
            System.out.println("1. Add Library Item");
            System.out.println("2. List Library Items (by Title)");
            System.out.println("3. List Library Items (by Publication Date)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Select item type:");
                    System.out.println("1. Book");
                    System.out.println("2. Magazine");
                    System.out.println("3. Newspaper");
                    System.out.print("Enter your choice: ");
                    int itemType = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    LibraryItem newItem = null;
                    switch (itemType) {
                        case 1:
                            System.out.print("Enter Genre: ");
                            String genre = scanner.nextLine();
                            newItem = new Book(title, author, "", "", 0, genre);
                            break;
                        case 2:
                            System.out.print("Enter Edition: ");
                            String edition = scanner.nextLine();
                            newItem = new Magazine(title, author, "", "", 0, edition);
                            break;
                        case 3:
                            System.out.print("Enter Publisher: ");
                            String publisher = scanner.nextLine();
                            newItem = new Newspaper(title, author, "", "", 0, publisher);
                            break;
                        default:
                            System.out.println("Invalid item type.");
                            continue;
                    }

                    newItem.validate();
                    libraryItems.add(newItem);
                    System.out.println("Item added to the library.");
                    break;

                case 2:
                    System.out.println("Library Items (by Title):");
                    Collections.sort(libraryItems, (a, b) -> a.getTitle().compareTo(b.getTitle()));
                    for (LibraryItem item : libraryItems) {
                        System.out.println(item);
                    }
                    break;

                case 3:
                    System.out.println("Library Items (by Publication Date):");
                    Collections.sort(libraryItems, (a, b) -> a.getPublicationDate().compareTo(b.getPublicationDate()));
                    for (LibraryItem item : libraryItems) {
                        System.out.println(item);
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}

