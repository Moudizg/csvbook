/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mouhammad
 */
public class Book {
    private String name;
    private String authorname;
    private int year;
    private String isbn;

    public Book(String name, String authorname, int year, String isbn) {
        this.name = name;
        this.authorname = authorname;
        this.year = year;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "name=" + name + "\nauthorname=" + authorname + "\nyear=" + year + "\nisbn=" + isbn;
    }
    
    
}
