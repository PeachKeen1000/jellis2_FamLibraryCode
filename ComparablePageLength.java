public class ComparablePageLength extends ComparableWrapper {
 
  public ComparablePageLength(Book newBook) {
   super(newBook); 
  }
  
  public int compareTo(ComparableWrapper newCompWrap) {
   int pageNum1=newCompWrap.getBook().getPageLength();
   int pageNum2=getBook().getPageLength();
   
   if(pageNum1>pageNum2) {
     return 1;
   } 
   else if (pageNum1<pageNum2) {
     return -1;
   } else {
     return 0;
   }
  }


public static void main (String[] args) {
 Book book1 = new Book();
 book1.setPageLength(25);
 Book book2 = new Book();
 book2.setPageLength(396);
 Book book3 = new Book();
 book3.setPageLength(396);
 
 ComparablePageLength tester1 = new ComparablePageLength(book1);
 ComparablePageLength tester2 = new ComparablePageLength(book2);
 ComparablePageLength tester3 = new ComparablePageLength(book3);
 
 System.out.println(tester1.compareTo(tester2));
 System.out.println(tester2.compareTo(tester3));
 System.out.println(tester2.compareTo(tester1));
}

}