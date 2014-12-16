public abstract class ComparableWrapper implements Comparable<ComparableWrapper> {
  private Book compBook;
  
  public ComparableWrapper(Book newBook) {
    compBook=newBook;
  }
  
  public Book getBook() {
    return compBook;
  }
  
  public abstract int compareTo(ComparableWrapper compWrap);
    
}