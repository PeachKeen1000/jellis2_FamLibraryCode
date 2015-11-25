//Written by: Kathryn Puzzanghera
//Started on: December 8, 2014
//Finished on: December 10, 2014
//Collaborators: Professor Wood on conceptual issues.
//Summary: ComparablePageLength extends the ComparableWrapper class.  Its purpose is to compare
//the page lengths of two different books to determine their relative numerical place.


public class ComparablePageLength extends ComparableWrapper {
 
  //construtor takes a book as a parameter
  public ComparablePageLength(Book newBook) {
   super(newBook); 
  }
  
  //compareTo satisfies the Comparable Interface and takes a ComparableWrapper as its parameter
  //It stores the page lengths of the two books in each ComparableWrapper and then compares the two integers
  public int compareTo(ComparableWrapper newCompWrap) {
  //stores the pageLength by retrieving the pagelenght out of the books out of the ComparableWrappers
   int pageNum1=newCompWrap.getBook().getPageLength();
   int pageNum2=getBook().getPageLength();
 
   //compares the two integers to see which is greater or less
   if(pageNum1>pageNum2) {
     return 1;
   } 
   else if (pageNum1<pageNum2) {
     return -1;
   } else {
     return 0;
   }
  }

//testing code
//public static void main (String[] args) {
// Book book1 = new Book();
// book1.setPageLength(25);
// Book book2 = new Book();
// book2.setPageLength(396);
// Book book3 = new Book();
// book3.setPageLength(396);
// 
// ComparablePageLength tester1 = new ComparablePageLength(book1);
// ComparablePageLength tester2 = new ComparablePageLength(book2);
// ComparablePageLength tester3 = new ComparablePageLength(book3);
// 
// System.out.println(tester1.compareTo(tester2));
// System.out.println(tester2.compareTo(tester3));
// System.out.println(tester2.compareTo(tester1));
//}

}