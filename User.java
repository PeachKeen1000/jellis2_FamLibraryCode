//User Class
//12/5/14
//Written by: Sarah Min

import java.util.*;
import java.awt.*;
import java.io.*; 

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
  
  public LinkedList <Book> getOurBooks() throws IOException {
    Scanner listReader = new Scanner(new File("MasterList.txt"));
    LinkedList<Book> loadedList=new LinkedList<Book>();
    
    try {
      while(listReader.hasNext()) {
        Book newbook= new Book();
        reverseString(listReader, newbook);    
        loadedList.add(newbook);
      }
      
      for(int i = 0; i < loadedList.size(); i++){
        if(!loadedList.get(i).getUser().equals(username)){
          loadedList.remove(i); 
        }
      }
    } catch (RuntimeException e) {
      System.out.println("Error reading the file");
      throw e;
    } finally {
      listReader.close();
    }
    
    return loadedList;
  }
  
  public Book reverseString(Scanner scanny, Book tempBook) {
    tempBook.setTitle(scanny.nextLine());
    tempBook.setAuthFirst(scanny.nextLine());
    tempBook.setAuthLast(scanny.nextLine());
    tempBook.setPageLength(Integer.parseInt(scanny.nextLine()));
    tempBook.setYear(Integer.parseInt(scanny.nextLine()));
    
    String genreFind = scanny.nextLine();
    String[] temp = tempBook.getGenreCollection();
    for (int x=0; x<temp.length; x++) {
      if (temp[x].equals(genreFind)) {
        tempBook.setGenre(x);
      }
    }
    
    String readingStatfind = scanny.nextLine();
    for (int x=0; x<tempBook.getReadingStatCollection().length; x++) {
      if (tempBook.readingStatCollection[x].equals(readingStatfind)) {
        tempBook.setReadingStat(x);
      }
    }
    
    String ownTF = scanny.nextLine();
    if (ownTF.equals("true")) {
      tempBook.setOwn(true);
    } else {
      tempBook.setOwn(false);
    }
    
    String wantOwnTF = scanny.nextLine();
    if (wantOwnTF.equals("true")) {
      tempBook.setWantOwn(true);
    } else {
      tempBook.setWantOwn(false);
    } 
    tempBook.setUser(scanny.nextLine());
    tempBook.setSecondAuthor(scanny.nextLine());
    tempBook.setTranslator(scanny.nextLine());
    tempBook.setEditorName(scanny.nextLine());
    tempBook.setTag1(scanny.nextLine());
    tempBook.setTag2(scanny.nextLine());
    tempBook.setTag3(scanny.nextLine());
    tempBook.setTag4(scanny.nextLine());
    tempBook.setTag5(scanny.nextLine());
    scanny.nextLine();
    
    return tempBook;
  }

  //Jabree: I added this method
  public void addBook(Book input){
    ourBooks.add(input); 

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