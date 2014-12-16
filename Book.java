//Started on: December 12, 2014
//Written by: Kate Puzzanghera

//Kate's notes/questions:
//How do I do some sort of option thing, like reading, unread, read (do I make all of them boolean?)
//I'm not sure how to handle the multiple choices thing, like if y then x

//should I change these back to private given the getters and setters?
public class Book {
  protected String title;
  protected String authorFirst;
  protected String authorSecond;
  protected String genre;
  protected String[] genreCollection={ "Reference", "Fantasy", "Science-Fiction", "Fiction", 
    "Historical-Fiction", "Humor", "Classics", "Biography", "Non-fiction", "Theater", "Poetry", "Comic Books", 
    "Romance", "Miscellaneous"} ;
  protected int pagelength;
  protected int pubYear;
  protected boolean own;
  protected boolean wantOwn;
  protected String[] readingStatCollection = {"have read", "am reading", "want to read"};
  protected String readingStat;
  protected String user;
  protected String residence;
  
  protected boolean other;
  protected boolean editor;
  protected boolean translator;
  protected boolean secondAuthor;
  protected String secAuthorName;
  protected String translatorName;
  protected String editorName;
 
  protected String tag1;
  protected String tag2;
  protected String tag3;
  protected String tag4;
  protected String tag5;
  
  //Should the constructor take any arguments???  Do I need to initialize things in the constructor?  I assumed so...
  //but it's been compiling
  public Book() {
    
  }
  
  public String getTitle() {
    return title;
}
  
  public void setTitle(String newTitle) {
    title=newTitle;
  }
  
  public String getAuthFirst() {
   return authorFirst; 
  }
  
  public void setAuthFirst(String firstName) {
   authorFirst=firstName; 
  }
  
  public String getAuthLast() {
    return authorSecond;
  }
  
  public void setAuthLast(String lastName) {
    authorSecond=lastName;
  }
  
  public String getGenre() {
    return genre;
  }
  
  public void setGenre(int x) {
    genre=genreCollection[x];
  }
  
  public String[] getGenreCollection() {
    return genreCollection;
  }
 
  
  public int getPageLength() {
   return pagelength; 
  }
  
  public void setPageLength(int newPageNum) {
    pagelength=newPageNum;
  }
  
  public int getYear() {
   return pubYear; 
  }
  
  public void setYear(int newYear) {
   pubYear=newYear;
  }

  public boolean getOwn() {
 return own; 
}

public void setOwn(Boolean tf) {
 own=tf; 
}

public String ownDisplay() {
  if (getOwn()==true) {
    return "You own this book.";
  } else {
    return "You do not own this book.";
  }
}

public boolean getWantOwn() {
 return wantOwn; 
}

//Okay, I'm not sure that the setbooleans really work like this...
public void setWantOwn(boolean tf) {
 wantOwn=tf; 
}

public String getReadingStat() {
 return readingStat; 
}

//does this work???  Jabree, could you work with this?  For whether somethng is read, unread, or reading is related
//to an integer??  So if it's 1, then it's read, and so on.  Would this work with the GUI?
public void setReadingStat(int x) {
  readingStat=readingStatCollection[x]; 
}

public String[] getReadingStatCollection() {
  return readingStatCollection;
}

public boolean getOther() {
  return other;
}

public void setOther() {
  other=false;
}

public String getEditorName() {
  return editorName;
}

public void setEditorName(String newEditor) {
 editorName=newEditor; 
}

public String getSecondAuthorName() {
  return secAuthorName;
}

public void setSecondAuthor(String secAuth) {
  secAuthorName=secAuth;
}

public String getTranslatorName() {
 return translatorName; 
}

public void setTranslator(String newTranslator) {
  translatorName=newTranslator;
}

public boolean getEditor() {
  return editor;
}

public void setEditor() {
 editor=false; 
}

public boolean getSecAuthor() {
  return secondAuthor;
}

public void setSecAuthor() {
  secondAuthor=false;
}

public boolean getTranslator() {
  return translator;
}

public void setTransaltor() {
  translator=false;
}

public String getTag1() {
  return tag1;
}

public void setTag1(String newTag) {
  tag1=newTag;
}

public String getTag2() {
  return tag2;
}

public void setTag2(String newTag) {
  tag2=newTag;
}

public String getTag3() {
  return tag3;
}

public void setTag3(String newTag) {
  tag3=newTag;
}

public String getTag4() {
  return tag4;
}

public void setTag4(String newTag) {
  tag4=newTag;
}

public String getTag5() {
  return tag5;
}

public void setTag5(String newTag) {
 tag5=newTag; 
}

public String getUser() {
  return user;
}

public void setUser(String newUser) {
user=newUser;
}

public String getResidence() {
  return residence;
}

public void setResidence(String newRes) {
  residence=newRes;
}


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

public static void main (String[] args) {
  Book book1 = new Book();
  book1.setTitle("Harry Potter and the Prisoner of Azkaban");
  book1.setAuthFirst("J.K.");
  book1.setAuthLast("Rowling");
  book1.setPageLength(325);
  book1.setGenre(2);
  book1.setYear(1999);
  
  Book book2 = new Book();
  book2.setTitle("The Lion, the Witch, and the Wardrobe");
  book2.setAuthFirst("C.S.");
  book2.setAuthLast("Lewis");
  book2.setPageLength(123);
  book2.setGenre(2);
  book2.setYear(1950);
  
//  System.out.println(book2.getTitle());
  System.out.println(book2.toString());
}
  
}
