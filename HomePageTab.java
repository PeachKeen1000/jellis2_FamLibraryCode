/** HomePageTab Class - Written by: Jabree Ellis
  * Date Modified: 4 December 2014 
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.LinkedList; 

public class HomePageTab extends JPanel {
  private BookList mL; 
  
  private final Font huge = new Font("large", Font. PLAIN, 32);
  private final Font large = new Font("large", Font. PLAIN, 24);
  
  private JLabel welcome; 
  
  private JLabel description; 
  
  private JLabel bookOfDayPt1;
  private JLabel bookOfDayPt2; 
  
  public HomePageTab(BookList input) {
    
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    
    mL = input; 
    
    //creates the heading labels for the tab; adds the labels to the panel
    welcome = new JLabel("Welcome to Family Library!"); 
    welcome.setFont(huge); 
    
    
    add(welcome);
    
    add(Box.createRigidArea (new Dimension(0,20)));
    
    
    description = new JLabel("Make your own book collection!"); 
    description.setFont(large); 
    
    
    add(description); 
    
    add(Box.createRigidArea (new Dimension(0,20)));
    
    try{
      mL.setBookList("MasterList.text"); 
      
    } catch (IOException e) {
      System.out.println("Input/Output Exception."); 
      
    }
    
    if (mL.getBookList().size() != 0) {
      bookOfDayPt1 = new JLabel("Today's book of the day is " + mL.getBookOfTheDay().getTitle() +" by " 
                                  + mL.getBookOfTheDay().getAuthFirst() + " " + mL.getBookOfTheDay().getAuthLast() + ".");
      
      bookOfDayPt2 = new JLabel("The book has " + mL.getBookOfTheDay().getPageLength() + 
                                " pages and is a " + mL.getBookOfTheDay().getGenre() + " book."); 
      bookOfDayPt1.setFont(large);
      bookOfDayPt2.setFont(large);
      
    } else {
      bookOfDayPt1 = new JLabel("Please add books to your collection to see a Book of the Day."); 
      bookOfDayPt1 = new JLabel(""); 
      bookOfDayPt1.setFont(large);
      bookOfDayPt2.setFont(large);
      
    }
    
    add(bookOfDayPt1); 
    add(bookOfDayPt2); 
  }
  
  
}//ends HomePageTab class
