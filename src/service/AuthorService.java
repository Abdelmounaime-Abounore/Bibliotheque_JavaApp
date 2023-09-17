package service;

import entities.Author;

import java.util.Scanner;

public class AuthorService {
    Scanner sc = new Scanner(System.in);
    public void save(){
        System.out.println("Enter name: ");
        String name = sc.next();
        Author author = new Author(name);
        author.addAuthor();
    }
}
