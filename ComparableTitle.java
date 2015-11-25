//Primary Author: Kathryn Puzzanghera
//Date started: December 8, 2014
//Date finished: December 10, 2014
//Collaborators: Professor Wood
//Summary: ComparableTitle extends the ComparableWrapper class.  Its purpose is to compare
//two book titles to determine their relative place alphabetically.

public class ComparableTitle extends ComparableWrapper {

  //constructor takes a book as a parameter
  public ComparableTitle(Book newBook) { 

    super(newBook);
  }
  
  ////This method compares two ComparableWrapers by taking them, retrieving their books, and then retrieving their
  //titles.  It compares the two titles alphabetically and returns an integer.
  //This method satisfies the comparable interface.
  public int compareTo(ComparableWrapper newCompTitle) {
  //stores the titles as a string using the comparableWrapers and the getBook() method
    String title1 = newCompTitle.getBook().getTitle();
    String title2 = getBook().getTitle();
    
//    String testTitle1= "Harry Potter";
//    String testTitle2 ="The Lion, the Witch, and the Wardrobe";
    
    //goes through a loop the length of one of the titles
    for(int x=0; x<title1.length(); x++) {
      //compares the titles using charAt
      if (title1.charAt(x)<title2.charAt(x)){
        return 1;
      }
      if(title1.charAt(x)>title2.charAt(x)) {
        return -1;
      }
    }
    return 0;
  }

//  Testing code
// public static void main (String[] args) {
//    
//      Book book1 = new Book();
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
//  Book book3 = new Book();
//  book3.setTitle("The Last of the Mohicans");
//  
//  Book book4 = new Book();
//  book4.setTitle("The Last of the Mohicans");
//  
//    ComparableTitle tester1 = new ComparableTitle(book1);
//    ComparableTitle tester2 = new ComparableTitle(book2);
//    ComparableTitle tester3 = new ComparableTitle(book3);
//    ComparableTitle tester4 = new ComparableTitle(book4);
//    
//    System.out.println(tester1.compareTo(tester2));
//    System.out.println(tester2.compareTo(tester1));
//    System.out.println(tester3.compareTo(tester2));
//    System.out.println(tester2.compareTo(tester3));
//    System.out.println(tester3.compareTo(tester4));
//    
//    
//  }
}