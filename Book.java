//Started on: December 12, 2014
//Finished on: December 17, 2014
//Written by: Kate Puzzanghera (Professor Wood: 11:10; Instructor Kakavouli: 1:30 on Thursday)
//Part of the Family Library Project
//Collaborators: I asked Stella about how I might best represent something that had three options instead of boolean.
//She suggested using integers.  Professor Wood suggested the toFileString method when I was writing the BookList class.
//Summary: This class creates a book object.  It consists of instance variables representing all the information we
//would like to capture about a book and getters and setters for each of those variables.  It also has two different
//String representations of the book object.

public class Book {
  //instance variables
  private String title;
  private String authorFirst;
  private String authorSecond;
  private String genre;
  private String[] genreCollection={ "Reference", "Fantasy", "Science-Fiction", "Fiction", 
    "Historical-Fiction", "Humor", "Classics", "Biography", "Non-fiction", "Theater", "Poetry", "Comic Books", 
    "Romance", "Miscellaneous"} ;
  private int pagelength;
  private int pubYear;
  private boolean own;
  private boolean wantOwn;
  private String[] readingStatCollection = {"have read", "am reading", "want to read"};
  private String readingStat;
  private String user;
  private String residence;
  
  private boolean other;
  private boolean editor;
  private boolean translator;
  private boolean secondAuthor;
  private String secAuthorName;
  private String translatorName;
  private String editorName;
  
  private String tag1="";
  private String tag2="";
  private String tag3="";
  private String tag4="";
  private String tag5="";
  
  //constructor
  public Book() {
    
  }
  //retrieves the title instance variable
  public String getTitle() {
    return title;
  }
  //retrieves and returns the title instance variable
  public void setTitle(String newTitle) {
    title=newTitle;
  }
  //retrieves and returns the authorFirst instance variable
  public String getAuthFirst() {
    return authorFirst; 
  }
  //sets the authorFirst instance variable
  public void setAuthFirst(String firstName) {
    authorFirst=firstName; 
  }
  //retrieves and returns the auhorSecond instance variable
  public String getAuthLast() {
    return authorSecond;
  }
  //sets the authorSecond instance variable
  public void setAuthLast(String lastName) {
    authorSecond=lastName;
  }
  //retrieves and returns the genre instance variable
  public String getGenre() {
    return genre;
  }
  //sets the genre instance variable
  public void setGenre(int x) {
    genre=genreCollection[x];
  }
  //retrieves and returns the genreCollection instance variable
  public String[] getGenreCollection() {
    return genreCollection;
  }
  
  //retrives and returns the pageLength instance variable
  public int getPageLength() {
    return pagelength; 
  }
  //sets the pageLength instance variable
  public void setPageLength(int newPageNum) {
    pagelength=newPageNum;
  }
  //retrieves and returns the pubYear instance variable
  public int getYear() {
    return pubYear; 
  }
  //sets the pubYear instance variable
  public void setYear(int newYear) {
    pubYear=newYear;
  }
//retrieves and returns the own instance variable
  public boolean getOwn() {
    return own; 
  }
//sets the own instance variable
  public void setOwn(Boolean tf) {
    own=tf; 
  }
//returns strings depending on whether own is true or false, used in the toString method
  public String ownDisplay() {
    if (getOwn()==true) {
      return "You own this book.";
    } else {
      return "You do not own this book.";
    }
  }
//returns and retrieves the instance variable wantOwn
  public boolean getWantOwn() {
    return wantOwn; 
  }
  
//sets the wantOwn instance variable
  public void setWantOwn(boolean tf) {
    wantOwn=tf; 
  }
//returns and retrieves the readingStat instance variable
  public String getReadingStat() {
    return readingStat; 
  }
  
  
//sets the readingStat instance variable
  public void setReadingStat(int x) {
    readingStat=readingStatCollection[x]; 
  }
//retrieves and returns the readingStatCollection instance variable
  public String[] getReadingStatCollection() {
    return readingStatCollection;
  }
  
  public String getReadingStatCollection(int input) {
    return readingStatCollection[input];
  }
//retrieves and returns the other instance variable
  public boolean getOther() {
    return other;
  }
//sets the other instance variable
  public void setOther(boolean tf) {
    other=tf;
  }
//retrieves and returns the editorName instance variable
  public String getEditorName() {
    return editorName;
  }
//sets the instance variable editorName
  public void setEditorName(String newEditor) {
    editorName=newEditor; 
  }
//retrieves and returns the secAuthorName instance variable
  public String getSecondAuthorName() {
    return secAuthorName;
  }
//sets the secAuthorName instance variable
  public void setSecondAuthor(String secAuth) {
    secAuthorName=secAuth;
  }
//retrieves and returns the translatorName instance variable
  public String getTranslatorName() {
    return translatorName; 
  }
//sets the translatorName instance variable
  public void setTranslatorName(String newTranslator) {
    translatorName=newTranslator;
  }
//retrieves and returns the editor instance variable
  public boolean getEditor() {
    return editor;
  }
//sets the editor instance variable to a boolean value
  public void setEditor(Boolean tf) {
    editor=tf; 
  }
//retrieves and returns the secondAuthor instance variable
  public boolean getSecAuthor() {
    return secondAuthor;
  }
//sets the secondAuthor instance variable to a boolean value
  public void setSecAuthor(Boolean tf) {
    secondAuthor=tf;
  }
//retrieves and returns the translator instance variable
  public boolean getTranslator() {
    return translator;
  }
//sets the translator instance variable to a boolean value
  public void setTranslator(Boolean tf) {
    translator=tf;
  }
//retrieves and returns the instance variable tag1
  public String getTag1() {
    return tag1;
  }
//sets the instance variable tag1 to a String value
  public void setTag1(String newTag) {
    tag1=newTag;
  }
//retrieves and returns the instance variable tag2
  public String getTag2() {
    return tag2;
  }
//sets the instance variable tag2 to a String value
  public void setTag2(String newTag) {
    tag2=newTag;
  }
//retrieves and returns the instance variable tag3
  public String getTag3() {
    return tag3;
  }
//sets the instance variable tag3 to a String value
  public void setTag3(String newTag) {
    tag3=newTag;
  }
//retrieves and returns the instance variable tag4
  public String getTag4() {
    return tag4;
  }
//sets the instance variable tag4 to a String value
  public void setTag4(String newTag) {
    tag4=newTag;
  }
//retrieves and returns the instance variable tag5
  public String getTag5() {
    return tag5;
  }
//sets the instance variable tag5 to a String value
  public void setTag5(String newTag) {
    tag5=newTag; 
  }
//retrieves and returns the instance variable user
  public String getUser() {
    return user;
  }
//sets the instance variable user to a specific user's username
  public void setUser(User newUser) {
    user=newUser.getUsername();
  }
  
  public void setUser(String input) {
    user = input;
  }
  
//retrieves and returns the instance variable residence
  public String getResidence() {
    return residence;
  }
//sets the instance variable residence
  public void setResidence(String newRes) {
    residence=newRes;
  }
  
//creates a string representation of a book for testing and for the user
  public String toString() {
    String result;
    result=title +
      "\n by " + authorFirst + " " + authorSecond
      + "\n Pages: " + pagelength 
      + "\n Year Published: " + pubYear
      + "\n Genre: " + genre
      + "\n I " +readingStat
      + "\n I ";
    if (getOwn()==true) {
      result=result+"own this book.";
    } else {
      if (getWantOwn()==true) {
        result=result+"don't own this book but I want to.";
      } 
      
      result=result+"don't own this book.";
    }
    result=result +"\n User: " + user
      + "\n Room: " + residence
      + "\n Second Author: " + secAuthorName
      + "\n Translator: " + translatorName
      + "\n Editor: " + editorName
      + "\n Tags: " + tag1 + "," + tag2 + "," + tag3 + "," + tag4 + "," + tag5 
      + "\n"
      + "\n";
    
    
    return result;  
  } 
//creates a String representation of the book object for reading into a file
  public String toFileString() {
    String result;
    result=title +
      "\n" + authorFirst 
      + "\n" + authorSecond
      + "\n" + pagelength 
      + "\n" + pubYear
      + "\n" + genre
      + "\n" +readingStat
      + "\n" + own
      + "\n" + wantOwn
      +"\n" + user
      + "\n" + residence
      + "\n" + secAuthorName
      + "\n" + translatorName
      + "\n" + editorName
      + "\n" + tag1 
      + "\n" + tag2 
      + "\n" + tag3 
      + "\n" + tag4 
      + "\n" + tag5;
    
    return result;  
  }
}
//TESTING CODE
//public static void main (String[] args) {
//  Book book1 = new Book();
//  book1.setTitle("Harry Potter and the Prisoner of Azkaban");
//  book1.setAuthFirst("J.K.");
//  book1.setAuthLast("Rowling");
//  book1.setPageLength(325);
//  book1.setGenre(2);
//  book1.setYear(1999);
//  
//  Book book2 = new Book();
//  book2.setTitle("The Lion, the Witch, and the Wardrobe");
//  book2.setAuthFirst("C.S.");
//  book2.setAuthLast("Lewis");
//  book2.setPageLength(123);
//  book2.setGenre(2);
//  book2.setYear(1950);
//  
////  System.out.println(book2.getTitle());
//  System.out.println(book2.toString());
//}
//  
//}
