
import java.util.*;

class DigitalLibrary {
    private static Scanner scanner = new Scanner(System.in);

    
    private static List<Book> books = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    private static User loggedInUser = null;

    
    static class Book {
        int id;
        String title;
        String author;
        boolean isIssued;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }
    }

    
    static class User {
        String name;
        String email;

        User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    
    private static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List All Books");
            System.out.println("4. Add User");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 4:
                    addUser();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int id = scanner.nextInt();

        books.removeIf(book -> book.id == id);
        System.out.println("Book removed successfully (if it existed).\n");
    }

    private static void listBooks() {
        System.out.println("\n--- List of Books ---");
        for (Book book : books) {
            System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author + ", Issued: " + (book.isIssued ? "Yes" : "No"));
        }
    }

    private static void addUser() {
        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter User Email: ");
        String email = scanner.nextLine();

        users.add(new User(name, email));
        System.out.println("User added successfully.");
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Email Query");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    emailQuery();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void searchBook() {
        System.out.print("Enter Book Title to Search: ");
        String title = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found - ID: " + book.id + ", Author: " + book.author + ", Issued: " + (book.isIssued ? "Yes" : "No"));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with the given title.");
        }
    }

    private static void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.id == id && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued successfully.");
                return;
            }
        }

        System.out.println("Book not found or already issued.");
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.id == id && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Book not found or not issued.");
    }

    private static void emailQuery() {
        System.out.print("Enter your query: ");
        String query = scanner.nextLine();
        System.out.println("Your query has been sent: " + query);
    }

    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Digital Library Management ---");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Admin logged in successfully.");
                    adminMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
