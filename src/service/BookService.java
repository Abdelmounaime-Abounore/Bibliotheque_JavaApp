package service;

import entities.Author;
import entities.Book;

import java.util.Scanner;

public class BookService {
    Scanner sc = new Scanner(System.in);

    Author author;
    Book book;
    public void save(){
        int bookId;

        System.out.println("Enter Title: ");
        String title = sc.next();

        System.out.println("Enter Isbn: ");
        String isbn = sc.next();

        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.println("Enter entities.Author name: ");
        String authorName = sc.next();

        author = new Author();
        int authorId = author.getAuthorId(authorName);

        if(authorId == 0) {
            System.out.println("entities.Author name is doest exist");
//            break;
        }else {
            book = new Book();
            book.setTitle(title);
            book.setIsbn(isbn);
            book.setQuantity(quantity);
            book.setAuteurId(authorId);

            book.addBook();
        }
    }
    public void show(){
        System.out.println("The books of Library: ");
        book = new Book();
        book.displayBook();
    }

    public void search(){
        int searchChoice;
        do {
            System.out.println("Search Menu:");
            System.out.println("1. Search by Title");
            System.out.println("2. Search by entities.Author");
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
                    System.out.println("Enter entities.Author name: ");
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
    }

    public void update(){
        System.out.println("Enter the isbn of entities.Book you want to Update: ");
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

            System.out.println("Enter name of entities.Author: ");
            String newAuthor = sc.next();
            author = new Author();
            int authorId = author.getAuthorId(newAuthor);

            if(authorId == 0) {
                System.out.println("entities.Author name is doest exist");
            } else {
                book.setTitle(newTitle);
                book.setIsbn(newIsbn);
                book.setQuantity(newQuantity);
                book.setAuteurId(authorId);

                book.updateBook(bookIsbn);
            }
        }
    }

    public void delete(){
        System.out.println("Enter the isbn of entities.Book you want to Delete: ");
        String bookIsbn = sc.next();
        book = new Book();
        Boolean checkIsbn = book.checkIsbnBook(bookIsbn);
        if (!checkIsbn){
            System.out.println("The isbn is not exist");
        }else {
            book.deleteBook(bookIsbn);
        }
    }
}
