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
            System.out.println("5- Update a Book");
            System.out.println("6- Delete a Book");
            System.out.println("7- Borrow a Book");
            System.out.println("8- Rerun a Book");
            System.out.println("9- Show borrowed books");
            System.out.println("10- Show Statistics");
            System.out.println("===========================");

            int ch = sc.nextInt();
            Book book;
            Reservation reservation;
            User user;
            switch (ch){
                case 1:
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    Author author = new Author(name);
                    author.addAuthor();
                    break;
                case 2:
                    int bookId;
                    System.out.println("Enter Id: ");
                    bookId = sc.nextInt();

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
                case 5:
                    System.out.println("Enter the isbn of Book you want to Update: ");
                    String bookIsbn = sc.next();
                    book = new Book();
                    boolean checkIsbn = book.checkIsbnBook(bookIsbn);
                    if (!checkIsbn){
                        System.out.println("The isbn is not exist");
                    } else {
                        System.out.println("Enter new title: ");
                        String newTitle = sc.next();

                        System.out.println("Enter new isbn: ");
                        String newIsbn = sc.next();

                        System.out.println("Enter new quantity: ");
                        int newQuantity = sc.nextInt();

                        book.setTitle(newTitle);
                        book.setIsbn(newIsbn);
                        book.setQuantity(newQuantity);

                        book.updateBook(bookIsbn);
                    }
                    break;
                case 6:
                    System.out.println("Enter the isbn of Book you want to Delete: ");
                    bookIsbn = sc.next();
                    book = new Book();
                    checkIsbn = book.checkIsbnBook(bookIsbn);
                    if (!checkIsbn){
                        System.out.println("The isbn is not exist");
                    }else {
                        book.deleteBook(bookIsbn);
                    }
                    break;
                case 7:
                    System.out.println("Enter the isbn of the book you want to borrow: ");
                    bookIsbn = sc.next();
                    book = new Book();
                    checkIsbn = book.checkIsbnBook(bookIsbn);
                    if (!checkIsbn){
                        System.out.println("The isbn is not exist");
                    }else {
                        boolean checkQuantity = book.checkQuatity(bookIsbn);
                        if (!checkQuantity){
                            System.out.println("The Book is not available");
                        } else {
                            System.out.println("Enter Your name");
                            name = sc.next();
                            user = new User();
                            int userId = user.getUserId(name);
                            if(userId == 0) {
                                System.out.println("name is doest exist");
                                break;
                            }
                            book = new Book();
                            bookId = book.getBookId(bookIsbn);

                            reservation = new Reservation("Borrowed", userId, bookId);
                            if (reservation.checkUserReservation()){
                                System.out.println("You can't reserve this book other time");
                                break;
                            }
                            reservation.addReservation();
                        }
                    }
                    break;
                case 8:
                    System.out.println("Enter the isbn of book");
                    bookIsbn = sc.next();
                    book = new Book();
                    checkIsbn = book.checkIsbnBook(bookIsbn);
                    if (!checkIsbn) {
                        System.out.println("the book isbn is not exist");
                    }else {
                        System.out.println("Enter Your name");
                        name = sc.next();
                        user = new User();
                        int userId = user.getUserId(name);
                        if (userId == 0) {
                            System.out.println("name is doest exist");
                            break;
                        }
                        bookId = book.getBookId(bookIsbn);
                        reservation = new Reservation("Returned", userId, bookId);
                        reservation.returBook(bookIsbn);
                    }
                    break;
                case 9:
                    reservation = new Reservation();
                    reservation.displayBooks("Borrowed");
                    break;
                case 10:
                    System.out.println("Statistics: ");
                    book = new Book();
                    book.availableBooks();

                    reservation = new Reservation();
                    reservation.displayBooks("Borrowed");
                    reservation.displayBooks("Lost");
                    break;
                case 12:
                    System.out.println("Thanks for Your visit");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice");
            }
        }while (true);

    }
}