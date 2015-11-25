//User Class
//12/5/14
//Written by: Sarah Min

import java.util.*;
import java.awt.*;
import java.io.*; 

public class User {
  
  //Instance variables 
 // private BookList mL; 
  private String username;
  private String password;
  private int booksOwned;
  private int booksRead;
  private Color identifier; 
  private LinkedList<Book> myWishList;
  private LinkedList <Book> myBooks;
  
  public User (String name) {
    //mL = input; 
    username = name.toLowerCase();
    password = ""; 
    booksOwned = 0;
    booksRead = 0;
    Random generator = new Random();
    identifier = new Color(generator.nextInt(254), generator.nextInt(254), generator.nextInt(254)); 
    myBooks = new LinkedList<Book> ();
    myWishList = new LinkedList<Book>();
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setPassword(String pw) {
    password = pw; //Password is case sensitive
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setBooksOwned(int numBooks) {
    booksOwned = numBooks;
  }
  
  public int getBooksOwned() {
    return booksOwned;
  }
  
  public void setBooksRead (int numBooks) {
    booksRead = numBooks;
  }
  
  public int getBooksRead() {
    return booksRead;
  }
  
  
  public Color getIdentifier() {
    return identifier;
  }
  
  public void setOurBooks(LinkedList <Book> books) {
    myBooks = books;
  }
  
  public LinkedList <Book> getMyBooks() {
return myBooks;
  }
  
  public LinkedList<Book> getMyWishList() {
   return myWishList; 
  }
  
  public String toString () {
    String s = "Username: " + username +
               "\nNumber of Books Owned: " + booksOwned +
               "\nNumber of Books Read: " + booksRead + "\n";
    return s;
  }
  
  //for testing purposes
  public static void main (String[] args) throws IOException {
    BookList bL = new BookList(); 
      
    User test1 = new User("SweetnNSarah");
    System.out.println(test1);
    System.out.println(test1.getMyBooks());
    
    
  }  
  
}