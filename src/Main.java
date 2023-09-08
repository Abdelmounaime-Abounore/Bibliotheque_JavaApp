import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our Library");

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("1- Add Author:");
            System.out.println("2- Add Book:");
            System.out.println("3- Show all Books:");
            System.out.println("4- Look for a book");

            int ch = sc.nextInt();
            Book book;
            switch (ch){
                case 1:
                    Author author = new Author();

                    System.out.println("Enter Id: ");
                    int authorId = sc.nextInt();

                    System.out.println("Enter name: ");
                    String name = sc.next();

                    author.setId(authorId);
                    author.setName(name);

                    author.addAuthor();
                    break;
                case 2:

                    System.out.println("Enter Id: ");
                    int bookId = sc.nextInt();

                    System.out.println("Enter Title: ");
                    String title = sc.next();

                    System.out.println("Enter Isbn: ");
                    String isbn = sc.next();

                    System.out.println("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.println("Enter Author Id: ");
                    int authorid = sc.nextInt();

                    book = new Book();
                    book.setId(bookId);
                    book.setTitle(title);
                    book.setIsbn(isbn);
                    book.setQuantity(quantity);
                    book.setAuteurId(authorid);

                    book.addBook();
                    break;
                case 3:
                    book = new Book();
                    book.displayBook();
                    break;
                case 4:
                    int searchChoice;
                    do {
                        System.out.println("Search Menu:");
                        System.out.println("1. Search by Title");
                        System.out.println("2. Search by Author");
                        System.out.println("3. Go Back");

                        searchChoice = sc.nextInt();
                        Book searchedBook;
                        switch (searchChoice) {
                            case 1:
                                System.out.println("Enter title: ");
                                String searchTitle = sc.next();
                                searchedBook=new Book();
                                searchedBook.searchByTitle(searchTitle);
                                break;
                            case 2:
                                System.out.println("Enter Author name: ");
                                String searchAuthor = sc.next();
                                searchedBook=new Book();
                                searchedBook.searchByAuthorName(searchAuthor);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (searchChoice != 3);
                    break;
                case 10:
                    System.out.println("Thanks for Your visit");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice");
            }
        }while (true);

    }
}