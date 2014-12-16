/** OurBooksTab Class - Written by: Jabree Ellis
  * Date Modified: 4 December 2014 
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
  * 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 
import java.io.*; 

public class OurBooksTab extends JPanel {
  private BookList mL; 
  
  //private JButton previous; 
  
  //private JButton next;
  
  //declare buttons and labels 
  
  //variables for adding a book
  private JLabel titleAddLabel;        private JTextField titleAddTextField;
  private JLabel authLastAddLabel;     private JTextField authLastAddTextField;
  private JLabel authFirstAddLabel;    private JTextField authFirstAddTextField;
  private JLabel yearLabel;            private JTextField yearTextField;
  private JLabel genreLabel;           private JComboBox  genreBox;
  private JLabel pageNumLabel;         private JTextField pageNumTextField; 
  private JLabel isOwned;              private JComboBox  isOwnedBox; 
  
  private String[] yes_no = {"Choose an option", "Yes, this book should be my book collection.", 
    "No, I want this book in my wishlist."}; 
  private String[] genreChoices = { "Reference", "Fantasy", "Science-Fiction", "Fiction/Novels", 
    "Historical-Fiction", "Humor", "Classics", "Biography", "Non-fiction", "Theater", "Poetry", "Comic Books", 
    "Romance", "Miscellaneous"} ;
  
  private JButton addButton; 
  
  private JLabel titleRemoveLabel;     private JTextField titleRemoveTextField;
  private JLabel authorRemoveLabel;    private JTextField authorRemoveTextField;
  private JLabel removeListTypeLabel;  private JComboBox  removeListTypeBox; 
  
  private JButton removeButton; 
  
  private JLabel result; 
  
  private int componentCount; 
  
  private LinkedList<Book> inputCollection;
  
  public OurBooksTab(BookList input) {
    setLayout(new FlowLayout(FlowLayout.CENTER)); 
    
    mL = input; 
    componentCount = 0; 
    inputCollection = new LinkedList<Book>(); 
    
    add(new InputPanel()); 
    
    
    //initialization of labels, buttons, and boxes to remove a book
//    titleRemoveLabel = new JLabel("Title: "); 
//    authorRemoveLabel = new JLabel("Author: "); 
//    removeListTypeLabel = new JLabel("From which list should this book be removed?");
//     
//    titleRemoveTextField = new JTextField(); 
//    authorRemoveTextField = new JTextField(); 
//    removeListTypeBox = new JComboBox(lists); 
//    
//    removeButton = new JButton("Remove Book");
//    
//    //add the labels, buttons, and boxes for the removing a book to the panel
//    add(titleRemoveLabel);
//    add(titleRemoveTextField);
//    add(authorRemoveLabel);
//    add(authorRemoveTextField);
//    add(removeListTypeLabel);
//    add(removeListTypeBox);
//    
//    add(removeButton); 
    
    
  } //ends constructor
  
  private class InputPanel extends JPanel {
    //no instance variables, the only variables instantiated are from OurBooksTab
    
    //constructor 
    public InputPanel() {
      setLayout (new GridLayout(8,2));
      
      //initialization of labels, buttons, and boxes to add a book 
      titleAddLabel = new JLabel("Title: "); 
      authFirstAddLabel = new JLabel("Author's First Name: "); 
      authLastAddLabel = new JLabel("Author's Last Name: "); 
      yearLabel = new JLabel("Year: "); 
      genreLabel = new JLabel ("Genre: "); 
      pageNumLabel = new JLabel ("Number of Pages: "); 
      isOwned = new JLabel("Is the book owned?");
      
      titleAddTextField = new JTextField(); 
      authFirstAddTextField = new JTextField(); 
      authLastAddTextField = new JTextField(); 
      yearTextField = new JTextField(); 
      genreBox = new JComboBox(genreChoices); 
      pageNumTextField = new JTextField(); 
      isOwnedBox = new JComboBox(yes_no); 
      
      addButton = new JButton("Add Book");
      
      result = new JLabel("Result", SwingConstants.CENTER); 
      
      //add the labels, buttons, and boxes for the adding a book to the panel
      add(titleAddLabel); 
      add(titleAddTextField); 
      add(authFirstAddLabel); 
      add(authFirstAddTextField);
      add(authLastAddLabel); 
      add(authLastAddTextField);
      add(yearLabel); 
      add(yearTextField); 
      add(genreLabel); 
      add(genreBox); 
      add(pageNumLabel); 
      add(pageNumTextField); 
      add(isOwned); 
      add(isOwnedBox); 
      add(addButton);
      
      
      add(result);
      
      ButtonListener listen = new ButtonListener();
      
      addButton.addActionListener(listen);
      
    } //ends InputPanel constructor
  } //ends InputPanel class
  
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
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      if(event.getSource() == addButton){
        
        Book userBook = new Book(); 
        
        //first, make sure the fields are not empty 
        
        //Holds the values of all the user input fields. 
        String titleInput = titleAddTextField.getText();
        String authFirstInput = authFirstAddTextField.getText();
        String authLastInput = authLastAddTextField.getText();
        String yearInput = yearTextField.getText();
        String pageLengthInput = pageNumTextField.getText(); 
        int genreInput = genreBox.getSelectedIndex();
        int ownedInput = isOwnedBox.getSelectedIndex(); 
        
        
        if(!titleInput.equals("")){
          userBook.setTitle(titleInput); 
          componentCount++; 
        }
        if(!authFirstInput.equals("")){
          userBook.setAuthFirst(authFirstInput); 
          componentCount++; 
        } 
        if(!authLastInput.equals("")){
          userBook.setAuthLast(authLastInput);
          componentCount++; 
        }
        if(!yearInput.equals("")){
          userBook.setYear(Integer.parseInt(yearInput)); 
          componentCount++; 
        }
        //A genre will always be selected, so this component will always exist
        
        userBook.setGenre(genreInput); 

        if(!pageLengthInput.equals("")){
          userBook.setPageLength(Integer.parseInt(pageLengthInput)); 
          componentCount++; 
          
        }
        
        if(ownedInput == 1) {
          userBook.setOwn(true); 
          componentCount++; 
          
        } else if (ownedInput == 2){
          userBook.setOwn(false); 
          componentCount++; 
        }
      
        if(componentCount == 6) {
//            LinkedList<Book> temp = new LinkedList<Book>();
//            temp = mL.listLoader("MasterList.txt", new LinkedList<Book>());                 
//            mL.setFamilyBooks(temp);                      
//            mL.addBook(userBook);
//            LinkedList<Book> toBeSaved = new LinkedList();
//            toBeSaved.add(userBook); 
//            System.out.println(mL.toString()); 
//            mL.saveList(toBeSaved,"MasterList.txt");
             // = mL.listLoader("MasterList.txt", new LinkedList<Book>());
            inputCollection.add(userBook); 
            mL.saveList(inputCollection, "MasterList.txt"); 
            result.setText("The book has been added to the collection.");
          
        } else {
          
          result.setText("One of the required fields is missing.");
          
        }
        
        componentCount = 0; 
        
      } else if (event.getSource().equals(removeButton)) {
        //take the information from the ComboBox
        //and textfields
        
      }
      
    } //ends actionPerformed method
    
  } //ends ButtonListener class
  
} //ends OurBooksTab

