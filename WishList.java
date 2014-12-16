//Wishlist Class
//12/9/14
//Written by: Sarah Min

import java.util.*;
import java.io.*;

public class WishList {
  
  //Instance variables 
  protected LinkedList <Book> wishList;
  private String outFileName; //where results are written to
  //private User owner;
  
  public WishList() {
    wishList = new LinkedList<Book>(); 
  }
  
  public void addBookToWishList (Book newBook) {
    wishList.add(newBook);
  }
  
  public int getSizeWishList () {
    return wishList.size();
  }
  
  public String toString () {
    String s = "There are " + getSizeWishList() + " books in this WishList. They include:";
    for (int i = 0; i < getSizeWishList(); i++) {
      s += "\n" + wishList.get(i).toString();
    }
    return s;
  }
  
  public void writeToFile (String out) {
    outFileName = out; 
    try {
      //Sets up the output file stream
      PrintWriter writer = new PrintWriter (new File (outFileName));
      
      //Prints a header to the output file
      writer.println("Wishlist"); //for " + getUsername());
      
      //Prints out books from wishlist
      for (int i = 0; i < getSizeWishList(); i++) {
        writer.println("\n" + wishList.get(i).toString());
      }
      
      writer.close();
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }
      
  //for testing purposes
  public static void main (String[] args) {
    WishList test = new WishList();
    Book b1 = new Book();
    Book b2 = new Book();
    Book b3 = new Book();
    b1.setTitle("Frindle");
    b2.setTitle("When You Give A Mouse A Cookie");
    b3.setTitle("The Heart is A Lonely Hunter");
    test.addBookToWishList(b1);
    test.addBookToWishList(b2);
    test.addBookToWishList(b3);
    System.out.println(test);
    test.writeToFile("TestWishList");
  }
  
}
    