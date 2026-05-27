import java.util.ArrayList;
import java.util.Scanner;

class Book {

    int id;
    String name;
    String author;
    boolean issued;

    Book(int id, String name, String author) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.issued = false;
    }
}

public class LibraryManagement {

    static ArrayList<Book> books = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    searchBook();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, name, author));

        System.out.println("Book Added Successfully");
    }

    static void viewBooks() {

        if (books.isEmpty()) {

            System.out.println("No Books Available");
            return;
        }

        for (Book b : books) {

            System.out.println("\n---------------------");

            System.out.println("Book ID: " + b.id);
            System.out.println("Book Name: " + b.name);
            System.out.println("Author: " + b.author);

            if (b.issued) {
                System.out.println("Status: Issued");
            } else {
                System.out.println("Status: Available");
            }
        }
    }

    static void issueBook() {

        System.out.print("Enter Book ID to Issue: ");

        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (!b.issued) {

                    b.issued = true;

                    System.out.println("Book Issued Successfully");

                } else {

                    System.out.println("Book Already Issued");
                }

                return;
            }
        }

        System.out.println("Book Not Found");
    }

    static void returnBook() {

        System.out.print("Enter Book ID to Return: ");

        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (b.issued) {

                    b.issued = false;

                    System.out.println("Book Returned Successfully");

                } else {

                    System.out.println("Book Was Not Issued");
                }

                return;
            }
        }

        System.out.println("Book Not Found");
    }

    static void searchBook() {

        sc.nextLine();

        System.out.print("Enter Book Name: ");

        String search = sc.nextLine();

        for (Book b : books) {

            if (b.name.equalsIgnoreCase(search)) {

                System.out.println("\nBook Found");
                System.out.println("Book ID: " + b.id);
                System.out.println("Book Name: " + b.name);
                System.out.println("Author: " + b.author);

                return;
            }
        }

        System.out.println("Book Not Found");
    }
}
