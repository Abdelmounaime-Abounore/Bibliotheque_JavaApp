package service;

import entities.Book;
import entities.Reservation;
import entities.User;

import java.util.Scanner;

public class ReservationService {
    Book book = new Book();
    User user = new User();
    Reservation reservation;
    Scanner sc = new Scanner(System.in);
    public void save(){
        System.out.println("Enter the isbn of the book you want to borrow: ");
        String bookIsbn = sc.next();
        book = new Book();
        Boolean checkIsbn = book.checkIsbnBook(bookIsbn);
        if (!checkIsbn){
            System.out.println("The isbn is not exist");
        }else {
            boolean checkQuantity = book.checkQuatity(bookIsbn);
            if (!checkQuantity){
                System.out.println("The entities.Book is not available");
            }
            else {
                System.out.println("Enter Your name");
                String name = sc.next();
                user = new User();
                int userId = user.getUserId(name);
                if(userId == 0) {
                    System.out.println("name is doest exist");
                } else {
                    book = new Book();
                    int bookId = book.getBookId(bookIsbn);

                    Reservation reservation = new Reservation("Borrowed", userId, bookId);
                    if (reservation.checkUserReservation()){
                        System.out.println("You can't reserve this book other time");
                    }else {
                        reservation.addReservation();
                    }
                }
            }
        }
    }

    public void delete(){
        System.out.println("Enter the isbn of book");
        String bookIsbn = sc.next();
        book = new Book();
        Boolean checkIsbn = book.checkIsbnBook(bookIsbn);
        if (!checkIsbn) {
            System.out.println("the book isbn is not exist");
        }else {
            System.out.println("Enter Your name");
            String name = sc.next();
            user = new User();
            int userId = user.getUserId(name);
            if (userId == 0) {
                System.out.println("username is doest exist");

            }else {
                int bookId = book.getBookId(bookIsbn);
                Reservation reservation = new Reservation("Returned", userId, bookId);
                reservation.returBook(bookIsbn);
            }
        }
    }

    public void show(){
        reservation = new Reservation();
        reservation.displayBooks("Borrowed");
    }

    public void statistique(){
        System.out.println("Statistics: ");
        book = new Book();
        book.availableBooks();

        reservation = new Reservation();
        reservation.displayBooks("Borrowed");
        reservation.displayBooks("Lost");
    }
}
