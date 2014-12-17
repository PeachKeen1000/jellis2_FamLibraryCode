//User Class
//12/5/14
//Written by: Sarah Min

import java.util.*;
import java.awt.*;

public class User {
  
  //Instance variables 
  private String username;
  private String password;
  private int booksOwned;
  private int booksRead;
  private Color identifier; 
  private WishList wishlist;
  private LinkedList <Book> ourBooks;
  
  public User (String name) {
    username = name.toLowerCase();
    password = ""; 
    booksOwned = 0;
    booksRead = 0;
    Random generator = new Random();
    identifier = new Color(generator.nextInt(254), generator.nextInt(254), generator.nextInt(254)); 
    ourBooks = new LinkedList<Book> ();
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
  
  public WishList getWishList() {
    return wishlist;
  }
  
  public Color getIdentifier() {
    return identifier;
  }
  
  public void setOurBooks(LinkedList <Book> books) {
    ourBooks = books;
  }
  
  public LinkedList <Book> getOurBooks() {
    return ourBooks;
  }
  
  public String toString () {
    String s = "Username: " + username +
               "\nNumber of Books Owned: " + booksOwned +
               "\nNumber of Books Read: " + booksRead + "\n";
    return s;
  }
  
  //for testing purposes
  public static void main (String[] args) {
    User test1 = new User("SweetnNSarah");
    System.out.println(test1);
  }  
  
}