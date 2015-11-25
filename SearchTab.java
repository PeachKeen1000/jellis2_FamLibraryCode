/** SearchTab Class - Written by: Jabree Ellis
  * Date Modified: 4 December 2014 
  * 
  * 
  * 
  * Sources:
  * 1. http://stackoverflow.com/questions/6770266/java-radio-buttons
  * - Used to figure out a JRadioButton bug
  * 
  * 2. http://www.homeandlearn.co.uk/java/java_radio_buttons.html
  * - Used to figure out a JRadioButton bug
  * 
  * 3. http://stackoverflow.com/questions/5307283/exception-in-thread-awt-eventqueue-0
  * 
  * Used to help debug an AWT-EventQueue-error
  * 
  * 4. http://stackoverflow.com/questions/847652/bad-version-in-class-file
  * 
  * Used to help debug a bad class file error. 
  * 
  * 5. http://stackoverflow.com/questions/2536873/how-can-i-set-size-of-a-button
  * 
  * Used to figure out how to set the default size of a button
  * 
  * 6. From StackOverFlow 
  * URL: http://stackoverflow.com/questions/12084188/how-to-let-the-content-in-jcombobox-display-in-the-center
  * I used the information provided by user SeanF (on Aug. 23, 2012 at 3:22) to center 
  * align the content in the JComboBox instances. 
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList; 
import java.io.*;

import javafoundations.*;
import javafoundations.exceptions.*;

public class SearchTab extends JPanel {
  private BookList mL; 
  
  //private JLabel welcome; 
  
  //private JLabel description; 
  
  private JLabel typeLabel; 
  
  private JComboBox categories; 
  
  String[] categoryList = { "Title", "Author", "Owner", "Other"};
  
  private JLabel searchLabel; 
  private JLabel resultsSection; 
  private JTextField searchTextField;
  
  private JButton submitButton; 
  
  private JButton next;
  private JButton previous; 
  
  private int remainingBooks;  
  private Book current; 
  private int currentBookIndex; 
  private LinkedList<Book> list; 
  private JLabel noResults; 
  private Font large = new Font("large", Font.PLAIN, 16);
  private final int searchItems = 10; 
  
  JLabel[] results = new JLabel[searchItems]; 
  
  public SearchTab(BookList input, UserList users) {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); 
    add(Box.createRigidArea (new Dimension(0,10)));
    
    //include a basic grid format   
    
    mL = input;
    
    for(int i = 0; i < results.length; i++){
      results[i] = new JLabel("", SwingConstants.CENTER); 
      
    }
    
    
    add(Box.createRigidArea (new Dimension(0,25)));
    
    add(new InputPanel());  
    
    add(Box.createRigidArea (new Dimension(0,50)));
    
    add(new ResultPanel()); 
    
    add(Box.createRigidArea (new Dimension(0,50)));
    
    ButtonListener listen = new ButtonListener();
    
    submitButton.addActionListener(listen);
    
    next.addActionListener(listen); 
    
  } //ends constructor
  
  /************************************************************
    * 
    * This panel holds the GUI Components related to user input 
    * 
    **********************************************************/
  private class InputPanel extends JPanel {
    
    public InputPanel(){
      setLayout (new GridLayout(3,2));
      
      DefaultListCellRenderer aligner = new DefaultListCellRenderer(); 
      aligner.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
      
      typeLabel = new JLabel("Choose your search type: "); 
      typeLabel.setFont(large); 
      add(typeLabel); 
  
      categories = new JComboBox(categoryList); 
      categories.setRenderer(aligner); 
      
      add(categories);
      
      searchLabel = new JLabel("Search: ");  add(searchLabel);
      searchLabel.setFont(large); 
      searchTextField = new JTextField();    add(searchTextField);
      
      submitButton = new JButton("Submit"); 
      add(submitButton);
      
      noResults = new JLabel("", SwingConstants.CENTER); 
      add(noResults); 
      
      
    } //ends InputPanel constructor
    
  } //ends Panel class
  
  /************************************************************
    * 
    * This panel holds the GUI Components related to the search 
    * results 
    * 
    **********************************************************/
  
  private class ResultPanel extends JPanel {
    
    public ResultPanel(){
      setLayout (new GridLayout(6,2,20,20)); 
      
      for(int i = 0; i < results.length; i++){
        add(results[i]); 
        results[i].setFont(large); 
       
      }   
      
      next = new JButton("Next");
      
      previous = new JButton("Previous"); 
      
      add(next);
      add(previous); 
      
      next.setVisible(false); 
      previous.setVisible(false); 
      
    } //ends InputPanel constructor
    
  } //ends InputPanel class
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      
      
      if(event.getSource() == submitButton){
        
        
        /*******************************************************
          * These statements will run if submitButton is pressed 
          ********************************************************/
        
        /*******************************************************
          * every time the submit button is pressed the items in
          * the search display are cleared
          * 
          * And the noResults label is not displayed
          ********************************************************/
        
        for(int i = 0; i < searchItems; i++){
          results[i].setText(""); 
        } 
        
        noResults.setVisible(false); 
        
        if(!searchTextField.equals("")) {  
          
          //Stores the user input values
          String type = categoryList[categories.getSelectedIndex()]; 
          String term = searchTextField.getText();
          
          try {
            
            LinkedList<Book> temp = new LinkedList<Book>();
            temp = mL.listLoader("MasterList.txt", new LinkedList<Book>());                 
            mL.setFamBooks(temp); 
            list = mL.search(type, term); 
       
          } catch (FileNotFoundException e) {
            System.out.println("The txt file containing the collection of" + 
                               "books could not be found.");
            noResults.setText("BOOK COLLECTION FILE NOT FOUND"); 
            noResults.setVisible(true); 
          }
          
          remainingBooks = list.size(); 
          currentBookIndex = list.size() - remainingBooks; 
          
          /************************************************************** 
            * If all of the search items can fit on the screen, these 
            * statements will be invoked
            *************************************************************/
          
          if(remainingBooks <= searchItems) {
            
            for(int i = 0; (i < remainingBooks) && (list.size() != 0); i++){
              current = list.get(currentBookIndex); 
              results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
              
              currentBookIndex ++; 
            } 
            
            /************************************************************** 
              * If nothing comes up in the search, the user will be told so
              *************************************************************/
            
            if(list.size() == 0) {
              noResults.setText("No books found."); 
              noResults.setVisible(true); 
            } 
            
            next.setVisible(false); 
            
          } else {
            
            /************************************************************** 
              * If not all of the search items can fit on the screen, these 
              * statements will be invoked
              *************************************************************/
            
            for(int i = 0; i < searchItems; i++){
              
              current = list.get(currentBookIndex); 
              results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
              
              remainingBooks -- ;    
              currentBookIndex ++; 
              
            }
            
            next.setVisible(true);
            
          }
          
        }    
        
      } else if (event.getSource() == next){
        
        /*******************************************************
          * These statements will run if the addButton is pressed 
          ********************************************************/
        
        
        /*******************************************************
          * every time addButton is pressed the items in
          * the search display are cleared
          * 
          * And the noResults label is not displayed
          ********************************************************/
        
        for(int i = 0; i < searchItems; i++){
          results[i].setText(""); 
        } 
        
        /************************************************************** 
          * If all of the search items can fit on the screen, these 
          * statements will be invoked
          *************************************************************/
        
        if(remainingBooks < searchItems) {
          
          for(int i = 0; i < remainingBooks; i++){ 
            current = list.get(currentBookIndex); 
            results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
            
            currentBookIndex ++; 
          } 
          
          /* If all the search items fit on the screen, there is no 
           * need to display the next button.*/
          
          next.setVisible(false); 
          
        } else {
          
          /************************************************************** 
            * If not all of the search items can fit on the screen, these 
            * statements will be invoked
            *************************************************************/
          
          /*The labels for the found book items are reset.
           *The next button also needs to be display, since
           *not all of the buttons can fit on the screen.*/
          
          for(int i = 0; i < searchItems; i++){
            current = list.get(currentBookIndex); 
            results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
            
            remainingBooks --;   
            currentBookIndex ++; 
            
          } //ends the for loop 
          
          next.setVisible(true); 
          
        } //ends the set of methods to be perform if there are at least 10 
        //remaining books
        
      } else if (event.getSource() == previous){
   



      } //ends the set out methods to be perform if the pressed button is next
      
    } //ends the actionPerformed method
    
  } //ends ButtonListener class
  
} //ends SearchTab class