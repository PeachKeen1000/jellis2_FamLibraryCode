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
  private final Font large = new Font("large", Font. PLAIN, 16);
  
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
  private JLabel tags;                 private JTextField tagsField; 
  private JLabel auth2Label;           private JTextField auth2Field;
  private JLabel transLabel;           private JTextField transField;
  private JLabel editLabel;            private JTextField editField;
  
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
  
  private boolean alreadyPressed; 
  
  public OurBooksTab(BookList input) {
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    
    mL = input; 
    componentCount = 0; 
    alreadyPressed = false; 
    inputCollection = new LinkedList<Book>(); 
    
    add(Box.createRigidArea (new Dimension(0,25)));
    add(new InputPanel());   
    add(Box.createRigidArea (new Dimension(0,25)));
    
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
      setLayout (new GridLayout(11,2));
      
      //initialization of labels, buttons, and boxes to add a book 
      titleAddLabel = new JLabel("Title: "); 
      titleAddLabel.setFont(large);
      
      authFirstAddLabel = new JLabel("Author's First Name: "); 
      authFirstAddLabel.setFont(large);
      
      authLastAddLabel = new JLabel("Author's Last Name: ");
      authLastAddLabel.setFont(large);
      
      yearLabel = new JLabel("Year: "); 
      yearLabel.setFont(large);
      
      genreLabel = new JLabel ("Genre: "); 
      genreLabel.setFont(large);
      
      pageNumLabel = new JLabel ("Number of Pages: "); 
      pageNumLabel.setFont(large);
      
      tags = new JLabel("Add tags to your books. Separate with commas."); 
      tags.setFont(large); 
      
      auth2Label = new JLabel("(Opt.) Second Author"); 
      auth2Label.setFont(large);
        
      transLabel = new JLabel("(Opt.) Translator"); 
      transLabel.setFont(large); 
        
      editLabel = new JLabel("(Opt.) Editor");
      editLabel.setFont(large);
        
      titleAddTextField = new JTextField(); 
      authFirstAddTextField = new JTextField(); 
      authLastAddTextField = new JTextField(); 
      yearTextField = new JTextField(); 
      genreBox = new JComboBox(genreChoices); 
      pageNumTextField = new JTextField();  
      tagsField = new JTextField(); 
      auth2Field = new JTextField(); 
      transField = new JTextField(); 
      editField = new JTextField(); 
      
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
      add(tags);
      add(tagsField);
      add(auth2Label); 
      add(auth2Field);
      add(transLabel); 
      add(transField);
      add(editLabel);
      add(editField); 
      
      add(addButton);
      add(result);
      
      ButtonListener listen = new ButtonListener();
      
      addButton.addActionListener(listen);
      
    } //ends InputPanel constructor
  } //ends InputPanel class
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event) {
      if(event.getSource() == addButton){
        
        Book userBook = new Book(); 
        
        //Holds the values of all the user input fields. 
        String titleInput = titleAddTextField.getText();
        String authFirstInput = authFirstAddTextField.getText();
        String authLastInput = authLastAddTextField.getText();
        String yearInput = yearTextField.getText();
        String pageLengthInput = pageNumTextField.getText(); 
        int genreInput = genreBox.getSelectedIndex();
        String [] tagsInput = new String[5]; 
        String auth2Input = auth2Field.getText();
        String transInput = transField.getText();
        String editInput = editField.getText();
        
        String tagString = tagsField.getText(); 
        
        for(int i = 0; i < tagsInput.length; i++){
          tagsInput[i] = ""; 
          
        }
        
        int tagsAdded = 0; 
        int start = 0; 
        int count = 0; 
        
        
        for(int i = 0; (i < tagString.length()) && (count < 5) && (tagString.length() != 0); i++) {
          int stop = i; 
          
          if(tagString.charAt(i) == ',') {
            tagsInput[count] = tagString.substring(start,stop); 
            start = stop + 1; 
            tagsAdded++; 
            count++; 
            
          } else if(i == tagString.length() - 1){
            tagsInput[count] = tagString.substring(start,stop+1);  
            tagsAdded++; 
            count++; 
            
            
          }
        }
        
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
          userBook.setGenre(genreInput-1); 
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
        
       
        userBook.setOwn(true); 
        userBook.setWantOwn(false); 
        componentCount++; 
        
        
        userBook.setTag1(tagsInput[0]); 
        userBook.setTag2(tagsInput[1]); 
        userBook.setTag3(tagsInput[2]);  
        userBook.setTag4(tagsInput[3]);  
        userBook.setTag5(tagsInput[4]);
        
        userBook.setSecondAuthor(auth2Input); 
        
        if(!auth2Input.equals("")){  
          userBook.setSecAuthor(true); 
          
        } else {
          userBook.setSecAuthor(false); 
          
        }
        
        userBook.setTranslatorName(auth2Input);
        
        if(!transInput.equals("")){
          userBook.setTranslator(true); 
          
        } else {
          userBook.setTranslator(false); 
          
        }
        
        userBook.setEditorName(auth2Input);
        
        if(!editInput.equals("")){
          userBook.setEditor(true);
          
        } else {
          userBook.setEditor(false);
          
        }
        
        /****************************************************************
          * If the user has input all the components correctly, the book 
          * will be added to the MasterList text file, and the user 
          * will be notified. 
          ****************************************************************/
        
        if(componentCount == 7) {
          if(alreadyPressed == false) {
            try {
              //the first save list ensures that MasterList has been created
              inputCollection = mL.listLoader("MasterList.txt", new LinkedList<Book>());
              inputCollection.add(userBook); 
              mL.saveList(inputCollection, "MasterList.txt");       
              result.setText("The book has been added to your collection.");
              alreadyPressed = true; 
            } catch (FileNotFoundException e ){
              System.out.print("Collection file not found"); 
              
            }
            
          } else {
            
            inputCollection.add(userBook); 
            mL.saveList(inputCollection, "MasterList.txt");       
            result.setText("The book has been added to your collection.");
          }
          
        } 
        
        /*****************************************************************
          * After everything is evaluated the component count will reset. 
          ****************************************************************/
        
        componentCount = 0; 
        
      } else if (event.getSource().equals(removeButton)) {
        //Ideally, we would like to implement this. 
        
      }
      
    } //ends actionPerformed method
    
  } //ends ButtonListener class
  
} //ends OurBooksTab

