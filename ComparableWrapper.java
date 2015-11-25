//Written by: Kate Puzzanghera 
//Started on: December 8, 2014
//Finished on: December 10, 2014
//Collaborators: Professor Wood with regards to the creation of the concept
//Summary: This class implements the Comparable interface and is abstract.  It is meant to create a 
//framework to modify the compareTo methods so that a Binary Search Tree can compare two objects (in this case, books)
//by different criteria.  It also contains methods for retrieving the book out of its wrapping.

public abstract class ComparableWrapper implements Comparable<ComparableWrapper> {
  //instance variables
  private Book compBook;
  
  //constructor
  public ComparableWrapper(Book newBook) {
    compBook=newBook;
  }
  
  //retrieves the book from the wrapper
  public Book getBook() {
    return compBook;
  }
  
  //abstract version of compareTo that takes a ComparableWrapper as its parameter
  public abstract int compareTo(ComparableWrapper compWrap);
    
}