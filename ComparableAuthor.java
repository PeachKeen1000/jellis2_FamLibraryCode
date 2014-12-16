public class ComparableAuthor extends ComparableWrapper {
 
  public ComparableAuthor(Book newBook) {
   super(newBook); 
  }
  
  public int compareTo(ComparableWrapper newCompWrap) {
   String author1 = newCompWrap.getBook().getAuthLast();
   String author2 = getBook().getAuthLast();
   
   for(int x = 0; x<author1.length(); x++) {
     if(author1.charAt(x)<author2.charAt(x)) {
      return 1; 
     }
     if(author1.charAt(x)>author2.charAt(x)) {
      return -1; 
     }
   }
   return 0;
  }
  
  public static void main (String[] args) {
   Book book1 = new Book();
   book1.setAuthLast("Rowling");
   Book book2 = new Book();
   book2.setAuthLast("Picoult");
   Book book3 = new Book();
   book3.setAuthLast("Rinaldi");
   Book book4 = new Book();
   book4.setAuthLast("Rinaldi");
   Book book5 = new Book();
   book5.setAuthLast("Lewis");
   
   ComparableAuthor tester1 = new ComparableAuthor(book1);
   ComparableAuthor tester2 = new ComparableAuthor(book2);
   ComparableAuthor tester3 = new ComparableAuthor(book3);
   ComparableAuthor tester4 = new ComparableAuthor(book4);
   ComparableAuthor tester5 = new ComparableAuthor(book5);
   
   System.out.println(tester1.compareTo(tester2));
   System.out.println(tester2.compareTo(tester1));
   System.out.println(tester3.compareTo(tester1));
   System.out.println(tester3.compareTo(tester4));
   System.out.println(tester5.compareTo(tester3));
  }
  
}