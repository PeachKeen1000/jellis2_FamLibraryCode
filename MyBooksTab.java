/** MyBooksTab Class - Written by: Jabree Ellis
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

public class MyBooksTab extends JPanel {
  private BookList mL; 
  private UserList uL; 
  
  //declare buttons and labels 
  //variables for finding the user 
  private JLabel userNameLabel;     private JTextField userNameTextField;
  private JLabel passwordLabel;     private JTextField passwordTextField;
  
  //This method assures that the username/password combination is correct
  private boolean approved; 
  
  
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
  private String[] genreChoices = { "Choose a genre","Reference", "Fantasy", "Science-Fiction", "Fiction/Novels", 
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
  
  //indicates whether the add button has already been pressed or not
  private boolean alreadyPressed; 
  
  public MyBooksTab(BookList input, UserList users) {
    setLayout(new FlowLayout(FlowLayout.CENTER)); 
    
    mL = input; 
    uL = users; 
    componentCount = 0; 
    approved = false; 
    alreadyPressed = false; 
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
      setLayout (new GridLayout(10,2));
      
      //Initializatiions of username/password textfields and labels
      //Adding those textfields/labels to the panel 
      
      userNameLabel = new JLabel("Enter your username: "); 
      userNameTextField = new JTextField(); 
      add(userNameLabel); 
      add(userNameTextField); 
      passwordLabel = new JLabel("Enter your password"); 
      passwordTextField = new JTextField(); 
      add(passwordLabel); 
      add(passwordTextField); 
      
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
      
      result = new JLabel("", SwingConstants.CENTER);
      
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
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      if(event.getSource() == addButton){
        
        //before you do anything, make sure the username/password is approve
        approved = false; 
        String userNameInput = userNameTextField.getText(); 
        String passwordInput = passwordTextField.getText(); 
        
        if (uL.containsUser(userNameInput)){
          if (uL.findUser(userNameInput).getPassword().equals(passwordInput)){
            approved = true; 
            
          } else {
            result.setText("Cannot find user/password"); 
            
          }
          
        } else {
          result.setText("Cannot find user/password");
          
        } 
        
        if (approved == true) {
          Book userBook = new Book(); 
          
          //Holds the values of all the user input fields. 
          String titleInput = titleAddTextField.getText();
          String authFirstInput = authFirstAddTextField.getText();
          String authLastInput = authLastAddTextField.getText();
          String yearInput = yearTextField.getText();
          String pageLengthInput = pageNumTextField.getText(); 
          int genreInput = genreBox.getSelectedIndex();
          int ownedInput = isOwnedBox.getSelectedIndex(); 
          
          /****************************************************************
            * The following if-conditionals help to ensure that the user 
            * has input correct information.
            ****************************************************************/
          
          /**********************Checks the title input********************/
          
          if(!titleInput.equals("")){
            userBook.setTitle(titleInput); 
            componentCount++; 
          } else {
            result.setText("Missing: book title");
            
          }
          
          /******************Checks the author's first name input****************/
          
          if(!authFirstInput.equals("")){
            userBook.setAuthFirst(authFirstInput); 
            componentCount++; 
            
          } else {
            result.setText("Missing: author's first name");
            
          }
          
          /******************Checks the author's last name input****************/
          
          if(!authLastInput.equals("")){
            userBook.setAuthLast(authLastInput);
            componentCount++; 
            
          } else {
            result.setText("Missing: author's last name");
            
          }
          
          /*************************Checks the year input*********************/
          
          if(!yearInput.equals("")){
            int yearParsed = Integer.parseInt(yearInput);
            userBook.setYear(yearParsed);
            
            if((0 < yearParsed) && (yearParsed < 2015)){
              componentCount++; 
              
            } else {
              result.setText("Missing: valid year input"); 
            }
            
          } else {
            result.setText("Missing: valid year input"); 
            
          }
          
          /********************Checks the genre input***********************/
          
          if(genreInput != 0) {
            userBook.setGenre(genreInput); 
            componentCount++; 
            
          } else {
            result.setText("Missing: book genre"); 
            
          }
          
          /********************Checks page length input***********************/
          
          if(!pageLengthInput.equals("")){
            try {
              userBook.setPageLength(Integer.parseInt(pageLengthInput)); 
              componentCount++; 
              
            } catch (NumberFormatException e) {
              result.setText("Missing: proper page number"); 
              
            }
            
          } else {
            result.setText("Missing: Page Number"); 
            
          }
          
          /************************Checks owner input***********************/
          
          if(ownedInput == 1) {
            userBook.setOwn(true); 
            userBook.setWantOwn(false); 
            componentCount++; 
            
          } else if (ownedInput == 2){
            userBook.setOwn(false); 
            userBook.setWantOwn(true); 
            componentCount++; 
            
          } else {
            result.setText("Missing: Owner info"); 
            
          }
          
          /****************************************************************
            * If the user has input all the components correctly, the book 
            * will be added to the MasterList text file, and the user 
            * will be notified. 
            ****************************************************************/
          //if this button has not been pressed, do a couple of things
          //change the variable to true
          //save the List 
          
          if(componentCount == 7) {
            if(alreadyPressed == false) {
              try {
                //attach a user to the book
                //add the book to the user's collection 
                
                //load the master collection with all the books
                //add the new book to the master collection 
                //save everything
                userBook.setUser(userNameInput);
                inputCollection = mL.listLoader("MasterList.txt", new LinkedList<Book>());
                inputCollection.add(userBook); 
                mL.saveList(inputCollection, "MasterList.txt");       
                result.setText("The book has been added to your collection.");
                alreadyPressed = true; 
              } catch (FileNotFoundException e ){
                System.out.print("Collection file not found"); 
                
              }
              
            } else {
              
              userBook.setUser(userNameInput);
              inputCollection.add(userBook); 
              mL.saveList(inputCollection, "MasterList.txt");       
              result.setText("The book has been added to your collection.");  
              
            }
            
          } 
          
          /*****************************************************************
            * After everything is evaluated the component count will reset. 
            ****************************************************************/
          
          componentCount = 0; 
          
        }
      } else if (event.getSource().equals(removeButton)) {
        //Ideally, we would like to implement this. 
        
      }
      
    } //ends actionPerformed method
    
  } //ends ButtonListener class
  
} //ends MyBooksTab