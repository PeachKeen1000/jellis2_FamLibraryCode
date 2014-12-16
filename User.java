//User Class
//12/5/14
//Written by: Sarah Min

public class User {
  
  //Instance variables 
  private String username;
  private String password;
  private int booksOwned;
  private int booksRead;
  //private random identifier; //what is this...?
  private WishList wishlist;
  
  public User (String name, String pw) {
    username = name.toLowerCase();
    password = pw; //Password is case sensitive
    booksOwned = 0;
    booksRead = 0;
  }
  
  public String getUsername() {
    return username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public int getBooksOwned() {
    return booksOwned;
  }
  
  public int getBooksRead() {
    return booksRead;
  }
  
  public WishList getWishList() {
    return wishlist;
  }
  
  public String toString () {
    String s = "Username: " + username +
               "\nNumber of Books Owned: " + booksOwned +
               "\nNumber of Books Read: " + booksRead + "\n";
    return s;
  }
  
  //for testing purposes
  public static void main (String[] args) {
    User test1 = new User("SweetnNSarah", "myPAssword");
    System.out.println(test1);
  }  
  
}