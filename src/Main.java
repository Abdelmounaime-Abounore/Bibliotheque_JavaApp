import entities.User;
import service.AuthorService;
import service.BookService;
import service.ReservationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our Library");

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("1- Add entities.Author:");
            System.out.println("2- Add entities.Book:");
            System.out.println("3- Show all Books:");
            System.out.println("4- Look for a book");
            System.out.println("5- Update a entities.Book");
            System.out.println("6- Delete a entities.Book");
            System.out.println("7- Borrow a entities.Book");
            System.out.println("8- Rerun a entities.Book");
            System.out.println("9- Show borrowed books");
            System.out.println("10- Show Statistics");
            System.out.println("11- Exit");
            System.out.println("===========================");

            int ch = sc.nextInt();
            BookService bookService;
            AuthorService authorService;
            ReservationService reservationService;
            User user;
            switch (ch){
                case 1:
                    authorService = new AuthorService();
                    authorService.save();
                    break;
                case 2:
                bookService = new BookService();
                bookService.save();
                    break;
                case 3:
                    bookService = new BookService();
                    bookService.show();
                    break;
                case 4:
                    bookService = new BookService();
                    bookService.search();
                    break;
                case 5:
                    bookService = new BookService();
                    bookService.update();
                    break;
                case 6:
                    bookService = new BookService();
                    bookService.delete();
                    break;
                case 7:
                    reservationService = new ReservationService();
                    reservationService.save();
                    break;
                case 8:
                    reservationService = new ReservationService();
                    reservationService.delete();
                    break;
                case 9:
                    reservationService = new ReservationService();
                    reservationService.show();
                    break;
                case 10:
                    reservationService = new ReservationService();
                    reservationService.statistique();
                    break;
                case 11:
                    System.out.println("Thanks for Your visit");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice");
            }
        }while (true);
    }
}