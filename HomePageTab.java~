/** HomePageTab Class - Written by: Jabree Ellis
  * Date Modified: 4 December 2014 
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePageTab extends JPanel {
  private BookList mL; 
  
  private JLabel welcome; 
 
  private JLabel description; 
  
  private JLabel bookOfDay; 
  
  private Timer time;
  
  private final int delay; 
  
  //private JButton previous; 
  
  //private JButton next;
  
  //declare buttons and labels 
  
  public HomePageTab() {
    
    setLayout (new FlowLayout());
    
   // mL = input; 
  
    //creates the heading labels for the tab; adds the labels to the panel
    welcome = new JLabel("Welcome to Family Library!"); 
    description = new JLabel ("View the family books below.\n"
                             + "Feel free to explore the program's features.\n");
  
    add(welcome); 
    add(description);
    //add(new InputPanel()); 
    
    delay = 86400; //The number of seconds in a day
    
    ButtonListener listen = new ButtonListener(); 
      
    //This timer will perform an action 24 hours. 
    time = new Timer(delay, listen); 
    //timer.start(); 
  

  } //ends constructor
//  
//    private class InputPanel extends JPanel {
//    
////  public InputPanel(){
////    //creates the selection for the book for the day
////    //int wildcard = Math.random - indices within the masterList.length 
////    Book featured = new Book();
////    featured = masterList.getBook(wildcard);                                
////                     
////    bookOfDay = new JLabel("Today's book of the day is " + featured.getTitle() +" by " 
////                          + featured.getAuthor() + ". The book has " + featured.getNumPages() + 
////                          " pages and is a " + featured.getGenre() + " book.". 
////    //add(bookOfDay); 
////      
//    }
//    } //ends InputPanel constructor
//    
//  } //ends InputPanel class
    
//    private class DisplayPanel extends JPanel {
//      
//      public DisplayPanel(){
//        
//        setLayout(new GridLayout(1,3); 
//        //add a previous button
//                  
//        //add a next button 
//        
//        //Hopefully, we will put the animation here 
//        
//        
//      } //ends DisplayPanel constructor
//      
//    } //ends DisplayPanel class
//    
//    
  
  
    private class ButtonListener implements ActionListener {
      
      public void actionPerformed (ActionEvent event) {
        
       
      } //ends actionPerformed method
      
    } //ends ButtonListener class
    
    
    
  
} //ends HomePageTab class