/** Michelle Gao and Jabree Ellis
 * Assignment 4 
 * Date Modified: 4 October 2014 
 * File Name: GradSchoolsGUI.java 
 * Purpose: Organizes and displays each of the panels within the tabs
 * inside of the main frame
 * 
 * 
 * To do: 
 * Have an option in the JComboBox so that a user can also have the option to
 * 
 * 
 */

import javax.swing.*;

public class FamilyLibraryGUI {
  
  public static void main (String[] args){
    JFrame frame = new JFrame("Family Library");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    BookList masterList = new BookList();
    
    //adds the tabbed panes and passes prospects as a parameter 
    JTabbedPane tp = new JTabbedPane(); 
    tp.addTab ("HomePage", new HomePageTab(/*masterList*/)); 
    //tp.addTab ("Users", new UsersTab(/*masterList*/));
   // tp.addTab ("My Books", new MyBooksTab(masterList)); 
    tp.addTab ("Our Books", new OurBooksTab(masterList)); 
    tp.addTab ("Search Books", new SearchTab(masterList));
    //tp.addTab ("Sort Books", new SortTab(masterList)); 
    tp.addTab ("WishList", new WishListTab()); 
   
    frame.getContentPane().add(tp); 
    frame.pack();
    frame.setVisible(true);
    
  }
  
}