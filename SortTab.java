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
  * We used the information provided by user SeanF (on Aug. 23, 2012 at 3:22) to center 
  * align the content in the JComboBox instances. 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList; 
import java.io.*;

import javafoundations.*;
import javafoundations.exceptions.*;

public class SortTab extends JPanel {
  private BookList mL; 
  
  private JLabel typeLabel; 
  
  private JLabel noResults; 
  
  private JComboBox categories; 
  
  String[] categoryList = { "Title", "Author", "Number of Pages", "Owner" };
  
  private JButton submitButton; 
  
  private JButton next;
  
  private int remainingBooks;  
  private Book current; 
  private int currentBookIndex; 
  private LinkedList<Book> list; 
  private Font large = new Font("large", Font.PLAIN, 16);
  private final int searchItems = 15; 
  
  JLabel[] results = new JLabel[searchItems]; 
  
  public SortTab(BookList input) {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); 
    add(Box.createRigidArea (new Dimension(20,0)));
    
    //include a basic grid format   
    
    mL = input;
    
    for(int i = 0; i < results.length; i++){
      results[i] = new JLabel("", SwingConstants.CENTER); 
      
    }
    
    add(new InputPanel());  
    
    add(Box.createRigidArea (new Dimension(20,0)));
    
    add(new ResultPanel()); 
    
    ButtonListener listen = new ButtonListener();
    
    submitButton.addActionListener(listen);
    
    next.addActionListener(listen); 
    
  } //ends constructor
  private class InputPanel extends JPanel {
    
    public InputPanel(){
      setLayout (new GridLayout(3,2,5,5));
      
      DefaultListCellRenderer aligner = new DefaultListCellRenderer(); 
      aligner.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
      
      typeLabel = new JLabel("Choose your search type: "); 
      
      add(typeLabel); 
      typeLabel.setFont(large); 
      
      categories = new JComboBox(categoryList); 
      categories.setRenderer(aligner); 
      
      add(categories);
      
      submitButton = new JButton("Submit");  
      add(submitButton);
      
      noResults = new JLabel("", SwingConstants.CENTER); 
      add(noResults); 
      
    } //ends InputPanel constructor
    
  } //ends Panel class
  
  
  private class ResultPanel extends JPanel {
    
    public ResultPanel(){
      setLayout (new GridLayout(6,3,10,10)); 
      
      for(int i = 0; i < results.length; i++){
        add(results[i]); 
        results[i].setFont(large); 
        
      }   
      
      next = new JButton("Show next books");
      
      add(next);
      
      next.setVisible(false); 
      
    } //ends InputPanel constructor
    
  } //ends InputPanel class
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      if(event.getSource() == submitButton){
        
        //every time the submit button if pressed, 
        //the search results will be cleared. 
        for(int i = 0; i < searchItems; i++){
          results[i].setText(""); 
        }
        try {
          mL.setBookList("MasterList.txt"); 
          
        } catch (FileNotFoundException e) {
          System.out.println("Error"); 
          
        }
        //Stores the user input values
        String type = categoryList[categories.getSelectedIndex()]; 
        
        if(type.equals("Title")){
          list = mL.sortedTreeList(mL.sortByTitle());
        } else if (type.equals("Author")){
          list = mL.sortedTreeList(mL.sortByAuthor());
        } else if (type.equals("Number of Pages")){
          list = mL.sortedTreeList(mL.sortByPageLength());    
        } else if (type.equals("Genre")){
          list = mL.genreSorter(); 
        }
        
        remainingBooks = list.size(); 
        currentBookIndex = list.size() - remainingBooks; 
        
        if((remainingBooks < searchItems) && (list.size() != 0)) {
          
          for(int i = 0; (i < remainingBooks) && (list.size() != 0); i++){
            //This is where the problem is
            current = list.get(currentBookIndex); 
            results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
            
            currentBookIndex ++; 
          }
          
        } else if (list.size() != 0) {
           //This is where the problem is
          for(int i = 0; i < searchItems; i++){
            current = list.get(currentBookIndex); 
            results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
            
            remainingBooks -- ;    
            currentBookIndex ++; 
          }
          
          next.setVisible(true);
          
        }
      
      
      //If nothing comes up in the search, the user will be told so 
      if(list.size() == 0) {
        noResults.setText("No books found of that type.");     
      }
      
    } else if (event.getSource() == next){//so, like, if someone clicks the next button 
      
      
      for(int i = 0; i < searchItems; i++){
        results[i].setText(""); 
      } 
      
      if(remainingBooks < searchItems) {
         //This is where the problem is
        for(int i = 0; i < remainingBooks; i++){ 
          current = list.get(currentBookIndex); //need a traversal
          results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
          
          currentBookIndex ++; 
        } 
        
        next.setVisible(false); 
        
      } else {
         //This is where the problem is
        for(int i = 0; i < searchItems; i++){
          current = list.get(currentBookIndex); //need a traversal 
          results[i].setText(current.getTitle() + " by " + current.getAuthFirst() + " " + current.getAuthLast());
          
          remainingBooks --;   
          currentBookIndex ++; 
          
        } //ends the for loop 
        
        next.setVisible(true); 
        
      } //ends the set of methods to be perform if there are at least 10 
      //remaining books
      
    } //ends the set out methods to be perform if the pressed button is next
    
  } //ends the actionPerformed method
  
} //ends ButtonListener class

} //ends SortTab class