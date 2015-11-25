/** ViewOurBooksTab Class - Written by: Jabree Ellis
  * Date Modified: 16 December 2014 
  * 
  * 
  * We will be giving a lot of abbreviated information in the GUI, let's try to make it
  * possible that a user can see more information by clicking on a Book. 
  * 
  * Sources:
  * 
  * 1. http://stackoverflow.com/questions/17132452/java-check-if-jtextfield-is-empty-or-not
  * 
  *    Used as a reference to figure out if a textfield is empty. 
  * 
  * 2. http://www.coderanch.com/t/458731/GUI/java/Multi-Line-JLabel
  *     
  * 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 
import java.io.*; 

public class ViewOurBooksTab extends JPanel {
  private BookList mL; 
  private UserList uL; 
  
  private final Font large = new Font("large", Font. PLAIN, 14);
  private final Font huge = new Font("large", Font. PLAIN, 20);
  private final int searchItems = 15; 
  JLabel[] results = new JLabel[searchItems]; 
  
  private JButton next; 
  private int remainingBooks; 
  private int currentBookIndex; 
  
  private LinkedList<Book> famBooks; 
  private Book current; 
  //we need a current user variable
  
  public ViewOurBooksTab(BookList input, UserList users) {
    setLayout(new FlowLayout(FlowLayout.CENTER));
    mL = input; 
    uL = users; 
    
    add(Box.createRigidArea (new Dimension(0,20)));
    Box.createVerticalGlue();
    
    for(int i = 0; i < results.length; i++){
      results[i] = new JLabel("", SwingConstants.CENTER); 
      results[i].setFont(large);
      
    }
    
    
    try {
      LinkedList<Book> temp = mL.listLoader("MasterList.txt", new LinkedList<Book>()); 
      mL.setBookList(temp);
      System.out.println(mL.toString() + "\n"); 
      famBooks = mL.getFamilyBooks();
      System.out.println(famBooks.toString()); 
      //System.out.println(uL.findUser("test").getOurBooks()); 
      //System.out.println(mL.toString()  + "\n");
      //System.out.println(uL.toString());
      //System.out.println(uL.findUser("test").getOurBooks().toString()); 
      
      
    } catch (FileNotFoundException e){
      System.out.println("The file was not found."); 
    }
    
    current = new Book(); 
    
    remainingBooks = famBooks.size(); 
    currentBookIndex = famBooks.size() - remainingBooks; 
    
    add(new InputPanel());
    
  } //ends constructor
  
  private class InputPanel extends JPanel {
    //no instance variables, the only variables instantiated are from OurBooksTab
    
    //constructor 
    public InputPanel() {
      setLayout (new GridLayout(6,3,0,20));
      
      for(int i = 0; i < results.length; i++){
        add(results[i]); 
        //results[i].setFont(large); 
        
      }   
      
      next = new JButton("Show next books"); 
      add(next);
      next.setVisible(false); 
      
      ButtonListener listener = new ButtonListener(); 
      next.addActionListener(listener); 
 
      
      if(remainingBooks <= searchItems) {
        
        for(int i = 0; (i < remainingBooks) && (famBooks.size() != 0); i++){
          current = famBooks.get(currentBookIndex); 
          results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
          
          currentBookIndex ++; 
        } 
        
        next.setVisible(false);
        
        /************************************************************** 
          * If nothing comes up in the search, the user will be told so
          *************************************************************/
        
        if(famBooks.size() == 0) {
          results[1].setText("No books found."); 
          results[1].setFont(huge); 
        }         
        
      } else {
        
        /************************************************************** 
          * If not all of the search items can fit on the screen, these 
          * statements will be invoked
          *************************************************************/
        
        for(int i = 0; i < searchItems; i++){
          
          current = famBooks.get(currentBookIndex); 
          results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
          
          remainingBooks -- ;    
          currentBookIndex ++; 
          
          
        }
        
        next.setVisible(true);
        
      }
      
    }
  } //ends InputPanel class 
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      if(event.getSource() == next) {
        System.out.println(famBooks.toString()); 
        
        for(int i = 0; i < searchItems; i++){
          results[i].setText(""); 
        } 
        
        /************************************************************** 
          * If all of the search items can fit on the screen, these 
          * statements will be invoked
          *************************************************************/
        
        if(remainingBooks <= searchItems) {
          
          for(int i = 0; (i < remainingBooks) && (famBooks.size() != 0); i++){
            current = famBooks.get(currentBookIndex); 
            results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
            
            currentBookIndex ++; 
          } 
          
          next.setVisible(false);
          /************************************************************** 
            * If nothing comes up in the search, the user will be told so
            *************************************************************/
          
          if(famBooks.size() == 0) {
            results[1].setText("No books found."); 
            results[1].setFont(huge); 
          }         
          
        } else {
          
          /************************************************************** 
            * If not all of the search items can fit on the screen, these 
            * statements will be invoked
            *************************************************************/
          
          for(int i = 0; i < searchItems; i++){
            
            current = famBooks.get(currentBookIndex); 
            results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
            
            remainingBooks --;    
            currentBookIndex ++; 
            
          }
          
          next.setVisible(true);
          
        }
        
      }
      
    } //ends actionPerformed method
    
  } //ends ButtonListener class
  
} //ends ViewOurBooksTab