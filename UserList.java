//UserList Class
//12/7/14
//Written by: Sarah Min

import java.util.*;

public class UserList {
  
  //instance variables
  private LinkedList<User> list;
  
  public UserList () {
    list = new LinkedList<User>();
  }
  
  public void addUser(User u) {
    list.addFirst(u);
  }
  
  public void removeUser(User u) {
    if (list.contains(u)) {
      list.remove(u);
    } else {
      System.out.println("User does not exist");
    }
  }
  
  public boolean containsUser(String username) {
    for (int i = 0; i < list.size(); i++) {
      if (username.equals(list.get(i).getUsername())) {
        return true;
      } 
    }
    return false;
  }
  
  public User findUser(String username) {
    for (int i = 0; i < list.size(); i++) {
      if (username.equals(list.get(i).getUsername())) {
        return list.get(i);
      } 
    }
    return null;
  }
    
  public int getSize() {
    return list.size();
  }
  
  public LinkedList<User> getList() {
   return list; 
  }
  
  public String toString () {
    String s = "There are " + getSize() + " users.\n";
    for (int i = 0; i < list.size(); i++) {
      s += list.get(i).toString();
    }
    return s;
  }
  
  //for testing purposes
  public static void main (String[] args) {
    User sarah = new User ("sweetnsarah");
    User anita = new User ("anitacarnita");
    UserList test = new UserList();
    test.addUser(sarah);
    test.addUser(anita);
    System.out.println(test.toString());
    test.removeUser(sarah);
    System.out.println(test.toString());
  }

}
    