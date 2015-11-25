//Written by: Kathryn Puzzanghera (Professor Wood, 11)
//Started on: December 8, 2014
//Finished on: December 10, 2014
//Collaborators: Professor Wood
//Summary: ComparableYear extends the ComparableWrapper class.  Its purpose is to compare
//the publication years of two different books to determine their relative numerical place.



public class ComparableYear extends ComparableWrapper {

  //constructor takes a book as a parameter
  public ComparableYear(Book newBook) {
   super(newBook); 
  }
  
  
  //compareTo satisfies the Comparable Interface and takes a ComparableWrapper as its parameter
  //It stores the publication years of the two books in each ComparableWrapper and then compares the two integers
  public int compareTo(ComparableWrapper newCompWrap) {
 //stores the years by retrieving the books out of the comparable wrappers and calling their years
    int year1 = newCompWrap.getBook().getYear();
   int year2 = getBook().getYear();
   
   //compares the two integers to see which one is greater
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
  
//  public static void main (String[] args) {
//   Book book1 = new Book();
//   Book book2 = new Book();
//   Book book3 = new Book();
//   book1.setYear(1923);
//   book2.setYear(2014);
//   book3.setYear(2014);
//   
//   ComparableYear tester1 = new ComparableYear(book1);
//   ComparableYear tester2 = new ComparableYear(book2);
//   ComparableYear tester3 = new ComparableYear(book3);
//   
//   System.out.println(tester1.compareTo(tester2));
//   System.out.println(tester2.compareTo(tester1));
//   System.out.println(tester2.compareTo(tester3));
//  }
  
}