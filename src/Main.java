import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our Library");

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("1- Add Author: \n");
            System.out.println("2- Add Book: \n");

            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    Author author = new Author();

                    System.out.println("Enter Id: ");
                    int authorId = sc.nextInt();

                    System.out.println("Enter name: ");
                    String name = sc.next();

                    author.setId(authorId);
                    author.setName(name);

                    author.addAuthor(author);
                    break;
                case 2:
                    Book book = new Book();

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

                    book.setId(bookId);
                    book.setTitle(title);
                    book.setIsbn(isbn);
                    book.setQuantity(quantity);
                    book.setAuteurId(authorid);

                    book.addBook(book);
                    break;
                case 3:
                    System.out.println("Thanks for Your visit");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice");
            }
        }while (true);

    }
}