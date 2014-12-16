public class ComparableYear extends ComparableWrapper {
 
  public ComparableYear(Book newBook) {
   super(newBook); 
  }
  
  public int compareTo(ComparableWrapper newCompWrap) {
   int year1 = newCompWrap.getBook().getYear();
   int year2 = getBook().getYear();
   
   if (year1>year2) {
     return 1;
   }
   else if(year1<year2) {
     return -1;
   }
   else {
     return 0;
   }
  }
  
  public static void main (String[] args) {
   Book book1 = new Book();
   Book book2 = new Book();
   Book book3 = new Book();
   book1.setYear(1923);
   book2.setYear(2014);
   book3.setYear(2014);
   
   ComparableYear tester1 = new ComparableYear(book1);
   ComparableYear tester2 = new ComparableYear(book2);
   ComparableYear tester3 = new ComparableYear(book3);
   
   System.out.println(tester1.compareTo(tester2));
   System.out.println(tester2.compareTo(tester1));
   System.out.println(tester2.compareTo(tester3));
  }
  
}