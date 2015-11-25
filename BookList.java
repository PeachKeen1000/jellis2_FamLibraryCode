//Started on: December 4, 2014
//Written by: Kate Puzzanghera



import java.util.*;
import javafoundations.*;
import java.io.*;


public class BookList { 
  
  private LinkedList<Book> bookList;
  private LinkedList<Book> familyBooks;
  private Hashtable<User, LinkedList<Book>> personalBooks;
  private Hashtable<User, LinkedList<Book>> wishlistHash;
  private UserList userList;
  
  public BookList() {
    bookList=new LinkedList<Book>(); 
    familyBooks = new LinkedList<Book>();
    personalBooks=new Hashtable<User, LinkedList<Book>>();
    userList = new UserList();
  }
  
  
  public LinkedList<Book> getBookList() {
   return bookList; 
  }
  
    
  public void setBookList(String fileName) throws IOException {  
    bookList = listLoader(fileName, bookList);
  }
  
  public UserList getUserList() {
    return userList;
  }
  
  public void setUserList(UserList ul) {
    userList = ul;
  }
  public void addBook(Book newBook, User u) {
    bookList.add(newBook);
    u.getMyBooks().add(newBook);
    u.setBooksOwned(u.getBooksOwned()+1);
    if (newBook.getWantOwn()==true) {
    u.getMyWishList().add(newBook);
    } 
    if (newBook.getOwn()==true) {
      familyBooks.add(newBook);
    }
  }
  
  public void removeBook(Book oldBook,User u) {
    bookList.remove(oldBook);
    u.getMyBooks().remove(oldBook);
    u.getMyWishList().remove(oldBook);
    u.setBooksOwned(u.getBooksOwned()-1);
    
  }
  
  public LinkedList<Book> search (String searchType, String searchTerm) {

    LinkedList<Book> searchResults = new LinkedList<Book>();
    
    if (searchType.equalsIgnoreCase("title")) {
      Iterator<Book> iter = bookList.iterator();
      while (iter.hasNext()) {
        Book booky = iter.next();
        if(booky.getTitle().toUpperCase().contains(searchTerm.toUpperCase())) {
          searchResults.add(booky);
        }
      }
      return searchResults;
    }
    
    if (searchType.equalsIgnoreCase("user")) {
      Iterator<Book> iter = bookList.iterator();
      while (iter.hasNext()) {
        Book booky = iter.next();
        if(booky.getUser().toUpperCase().contains(searchTerm.toUpperCase())) {
          searchResults.add(booky);
        }
      }
      return searchResults;
    }
    
    if (searchType.equalsIgnoreCase("author")) {
      Iterator<Book> iter = bookList.iterator();
      while (iter.hasNext()) {
        Book booky = iter.next();
        if(booky.getAuthLast().toUpperCase().contains(searchTerm.toUpperCase()) 
             || booky.getAuthFirst().toUpperCase().contains(searchTerm.toUpperCase())) {
          searchResults.add(booky);
        }
      }
      return searchResults;
    }
    
    else {
      Iterator<Book> iter = bookList.iterator();
      while (iter.hasNext()){
        Book booky = iter.next();
        if(booky.getTag1().toUpperCase().contains(searchTerm.toUpperCase()) 
             || booky.getTag2().toUpperCase().contains(searchTerm.toUpperCase())
             || booky.getTag3().toUpperCase().contains(searchTerm.toUpperCase()) 
             || booky.getTag4().toUpperCase().contains(searchTerm.toUpperCase())
             || booky.getTag5().toUpperCase().contains(searchTerm.toUpperCase())) {
          searchResults.add(booky);
          
        }
      }
      return searchResults;
    }
  }
  
  public String toString() {
    String result = "";
    Iterator<Book> iter = bookList.iterator();
    while (iter.hasNext()) {
      Book b = iter.next();
      result= result + " " + b.getTitle() + " by " + b.getAuthFirst() + " "
        + b.getAuthLast() + "\n";
    }
    return result;
  }
  
  
  
  public LinkedBinarySearchTree<ComparableWrapper> sortByTitle(String fileName) { 
    LinkedBinarySearchTree<ComparableWrapper> titleSorter = new LinkedBinarySearchTree<ComparableWrapper>();
    try {
      return treeLoader(fileName, titleSorter, "titleSorter");
    } catch (IOException ex) {
      Iterator<Book> iter = bookList.iterator();
    while (iter.hasNext()) {
      ComparableTitle bookworm = new ComparableTitle(iter.next());
      titleSorter.add(bookworm); 
    }
    return titleSorter; 
  }
  }
  
  public LinkedBinarySearchTree<ComparableWrapper> sortByAuthor(String fileName) {
    LinkedBinarySearchTree<ComparableWrapper> authorSorter = new LinkedBinarySearchTree<ComparableWrapper>();
    try {
      return treeLoader(fileName, authorSorter, "authorSorter");
    } catch (IOException ex) {
    Iterator<Book> iter = bookList.iterator();
    while (iter.hasNext()) {
      ComparableAuthor bookworm = new ComparableAuthor(iter.next());
      authorSorter.add(bookworm);
    }
    return authorSorter;
  }
  }
  public LinkedBinarySearchTree<ComparableWrapper> sortByYear(String fileName) {
    LinkedBinarySearchTree<ComparableWrapper> yearSorter = new LinkedBinarySearchTree<ComparableWrapper>();
    try {
      return treeLoader(fileName, yearSorter, "yearSorter");
    } catch (IOException ex) {
    Iterator<Book> iter = bookList.iterator();
    while (iter.hasNext()) {
      ComparableYear bookworm = new ComparableYear(iter.next());
      yearSorter.add(bookworm);
    }
    return yearSorter;
  }
  }
  public LinkedBinarySearchTree<ComparableWrapper> sortByPageLength(String fileName) {
    LinkedBinarySearchTree<ComparableWrapper> pageSorter = new LinkedBinarySearchTree<ComparableWrapper>();
    try {
        return treeLoader(fileName, pageSorter, "pageSorter");
         } catch (IOException ex) {
    Iterator<Book> iter = bookList.iterator();
    while(iter.hasNext()) {
      ComparablePageLength bookworm = new ComparablePageLength(iter.next());
      pageSorter.add(bookworm);
    }
    return pageSorter;
  }
  }
  
   
  public LinkedList<Book> genreSorter() {
    LinkedList<Book> genreSorter = new LinkedList<Book>();
    Book newbook = new Book();
    for (int x=0; x<14; x++) {
      String[] temp = newbook.getGenreCollection();
      String currentGenre = temp[x];
      Iterator<Book> iter = bookList.iterator();
      while(iter.hasNext()) {
        Book currentBook=iter.next();
        if(currentGenre.equals(currentBook.getGenre())) {
          genreSorter.add(currentBook);
        }
      }
    }
    return genreSorter;
  }
  
  
  public LinkedList<Book> getFamilyBooks(String fileName)  {
    try {
        return listLoader(fileName, familyBooks);
         } catch (IOException ex) {
    
    return familyBooks;
         }
  }
  
  public Hashtable<User, LinkedList<Book>> addtoHash (UserList ul)  {
   
    Iterator<User> iter = ul.getList().iterator();
    while (iter.hasNext()) {
      User current = iter.next();
      //  System.out.println(current);
     
      personalBooks.put(current, current.getMyBooks());
 
    }
    return personalBooks;
  }
  
  public LinkedList<Book> getPersonalBooks(User u, UserList ul, String fileName)  {
    try {
        return listLoader(fileName, u.getMyBooks());
         } catch (IOException ex) {
      
    addtoHash(ul);
    return personalBooks.get(u);
         }
  }
  
  public Book getBookOfTheDay() {
    Random randNum = new Random();
    int x = randNum.nextInt((bookList.size()-0)+1) + 0;
    return bookList.get(x);
  }
  
  public void saveList(LinkedList<Book> listtoSave, String fileName) {
    try {
      PrintWriter saver = new PrintWriter(new File(fileName));
      Iterator<Book> iter = listtoSave.iterator();
      while (iter.hasNext()) {
        saver.println(iter.next().toFileString());
      }
      saver.close();
    } catch (IOException ex) {
      System.out.println("ERROR: We couldn't save your file: " + ex); 
    }
  }
  
  
  
  public void saveTree(LinkedBinarySearchTree<ComparableWrapper> treetoSave, String fileName) {
    try {
      PrintWriter saver = new PrintWriter(new File (fileName));
      Iterator<ComparableWrapper> iter = treetoSave.inorder();
      while (iter.hasNext()) {
        saver.println(iter.next().getBook().toFileString());
      }
      saver.close();
    } catch (IOException ex) {
      System.out.println("ERROR: We couldn't save your file: " + ex);
    }
  }
   public LinkedList<Book> listLoader(String fileName, LinkedList<Book> reloadedList) throws FileNotFoundException {
    Scanner listReader = new Scanner(new File(fileName));
    reloadedList=new LinkedList<Book>();
    try {
      while(listReader.hasNext()) {
        Book newbook= new Book();
        reverseString(listReader, newbook, getUserList());    
        reloadedList.add(newbook);
      }
    } catch (RuntimeException e) {
      System.out.println("Error reading the file");
      throw e;
    } finally {
      listReader.close();
    }
    return reloadedList;
  }
  
  public LinkedBinarySearchTree<ComparableWrapper> treeLoader(String fileName, 
                                                              LinkedBinarySearchTree<ComparableWrapper> reloadedTree, 
                                                              String treeName) throws FileNotFoundException {
    
    Scanner treeReader = new Scanner(new File(fileName));
    reloadedTree=new LinkedBinarySearchTree<ComparableWrapper>();
    try {
      while (treeReader.hasNext()) {
        Book newbook = new Book(); 
        reverseString(treeReader, newbook, getUserList());
        if (treeName.equals("authorSorter")) {
          ComparableAuthor newWrap = new ComparableAuthor(newbook);
          reloadedTree.add(newWrap);
        }
        else if (treeName.equals("titleSorter")) {
          ComparableTitle newWrap = new ComparableTitle(newbook);
          reloadedTree.add(newWrap);
        }
        else if (treeName.equals("yearSorter")) {
          ComparableYear newWrap = new ComparableYear(newbook);
          reloadedTree.add(newWrap);
        } 
        else if (treeName.equals("pageSorter")) {
          ComparablePageLength newWrap = new ComparablePageLength(newbook);
          reloadedTree.add(newWrap);
        }
        
      }
    } catch (RuntimeException e) {
      System.out.println("Error reading the file");
      throw e;
    }finally {
      treeReader.close();
    }
    return reloadedTree;
  }
  
  
  public Book reverseString(Scanner scanny, Book tempBook, UserList ul) {
    tempBook.setTitle(scanny.nextLine());
    tempBook.setAuthFirst(scanny.nextLine());
    tempBook.setAuthLast(scanny.nextLine());
    tempBook.setPageLength(Integer.parseInt(scanny.nextLine()));
    tempBook.setYear(Integer.parseInt(scanny.nextLine()));
    
    String genreFind = scanny.nextLine();
    String[] temp = tempBook.getGenreCollection();
    for (int x=0; x<temp.length; x++) {
      if (temp[x].equals(genreFind)) {
        tempBook.setGenre(x);
      }
    }
    
    String readingStatfind = scanny.nextLine();
    String [] tempStat = tempBook.getReadingStatCollection();
    for (int x=0; x<tempStat.length; x++) {
      if (tempStat[x].equals(readingStatfind)) {
        tempBook.setReadingStat(x);
      }
    }
    
    String ownTF = scanny.nextLine();
    if (ownTF.equals("true")) {
      tempBook.setOwn(true);
    } else {
      tempBook.setOwn(false);
    }
    
    String wantOwnTF = scanny.nextLine();
    if (wantOwnTF.equals("true")) {
      tempBook.setWantOwn(true);
    } else {
      tempBook.setWantOwn(false);
    } 
    
    tempBook.setUser(userList.findUser(scanny.nextLine()));
  

    tempBook.setSecondAuthor(scanny.nextLine());
    String translatorTF = scanny.nextLine();
    if (translatorTF.equals("true")) {
       tempBook.setTranslator(true);
    } else {
      tempBook.setTranslator(false);
    }
    tempBook.setEditorName(scanny.nextLine());
    tempBook.setTag1(scanny.nextLine());
    tempBook.setTag2(scanny.nextLine());
    tempBook.setTag3(scanny.nextLine());
    tempBook.setTag4(scanny.nextLine());
    tempBook.setTag5(scanny.nextLine());
    scanny.nextLine();
    
    return tempBook;
  }
  
  public LinkedList<Book> sortedTreeList(LinkedBinarySearchTree<ComparableWrapper> treetoList) {
    LinkedList<Book> treeList = new LinkedList<Book>(); 
    
    Iterator<ComparableWrapper> iter = treetoList.inorder();
    while (iter.hasNext()) {
      treeList.add(iter.next().getBook());
   }
    
    return treeList; 

  }
  public Hashtable<User, LinkedList<Book>> addtoWishHash (UserList ul) throws IOException {
   
    Iterator<User> iter = ul.getList().iterator();
    while (iter.hasNext()) {
      User current = iter.next();
      //  System.out.println(current);
     
      wishlistHash.put(current, current.getMyWishList());
 
    }
    return wishlistHash;
  } 
  
  public LinkedList<Book> getWishList(User u, UserList ul, String fileName) throws IOException { 
    try {
        return listLoader(fileName, u.getMyWishList());
         } finally {
  addtoWishHash(ul);
  return wishlistHash.get(u);
  }
         }
 
  
  
  //TESTING CODE
//      public String searchDisplay() {
//   String s = "";
//   for (int x=0; x<searchResults.size(); x++) {
//     s=s+ " " + searchResults.get(x).getTitle() + " by " + searchResults.get(x).getAuthFirst() + " " 
//       + searchResults.get(x).getAuthLast() + " " + searchResults.get(x).getGenre() + " " 
//       +searchResults.get(x).getPageLength() + " Pages \n";
//   }
//   return s;
//  }
  
//  public String sortTitleDisplay() {
//    String result = "";
//    Iterator<ComparableWrapper> iter = titleSorter.inorder();
//    while(iter.hasNext()) {
//     Book currentBook = iter.next().getBook();
//      result=result+" "+currentBook.getTitle() + "\n";
//    }
//    return result;
//  }
//  
//  public String sortAuthorDisplay() {
//    String result = "";
//    Iterator<ComparableWrapper> iter = authorSorter.inorder();
//   while(iter.hasNext()) {
//      Book currentBook = iter.next().getBook();
//      result=result+ " " + currentBook.getAuthFirst() + " " + currentBook.getAuthLast() + "\n";
//    }
//    return result;
//  }
//  
//  public String sortYearDisplay() {
//    String result = "";
//    Iterator<ComparableWrapper> iter = yearSorter.inorder();
//    while(iter.hasNext()) {
//      Book currentBook = iter.next().getBook();
//      result=result+" " + currentBook.getYear() + "\n";
//    }
//    return result;
//  }
//  
//  public String sortPageDisplay() {
//    String result="";
//    Iterator<ComparableWrapper> iter = pageSorter.inorder();
//   while (iter.hasNext()) {
//      Book currentBook = iter.next().getBook();
//      result=result+ " " + currentBook.getPageLength() + "\n";
//    }
//    return result;
//  }
  
  public static void main (String[] args) throws FileNotFoundException {
    
    Book book1 = new Book();
    book1.setTitle("Harry Potter and the Prisoner of Azkaban");
    book1.setAuthFirst("J.K.");
    book1.setAuthLast("Rowling");
    book1.setPageLength(325);
    book1.setGenre(2);
    book1.setYear(1999);
    book1.setTag1("Magic");
    book1.setTag2("Wizardry");
    book1.setTag3("Harry Potter");
    book1.setTag4("");
    book1.setTag5("");
    book1.setOwn(true);
 
    
    Book book2 = new Book();
    book2.setTitle("The Lion, the Witch, and the Wardrobe");
    book2.setAuthFirst("C.S.");
    book2.setAuthLast("Lewis");
    book2.setPageLength(123);
    book2.setGenre(2);
    book2.setYear(1950);
    book2.setTag1("Magic");
    book2.setTag2("Christianity");
    book2.setTag3("Narnia");
    book2.setTag4("Children's Book");
    book2.setTag5("");
    book2.setOwn(true);
    
    
    Book book3 = new Book();
    book3.setTitle("My Sister's Keeper");
    book3.setAuthFirst("Jodi");
    book3.setAuthLast("Picoult");
    book3.setPageLength(223);
    book3.setYear(2004);
    book3.setGenre(3);
    book3.setOwn(false);
    book3.setWantOwn(true);
 
    
    Book book4 = new Book();
    book4.setTitle("The Other Boleyn Girl");
    book4.setAuthFirst("Phillipa");
    book4.setAuthLast("Gregory");
    book4.setPageLength(425);
    book4.setGenre(3);
    book4.setYear(2002);
    book4.setOwn(true);
      
    Book book5 = new Book();
    book5.setTitle("Mere Christianity");
    book5.setAuthFirst("C.S.");
    book5.setAuthLast("Lewis");
    book5.setPageLength(104);
    book5.setYear(1945);
    book5.setGenre(8);
    book5.setAuthLast("Lewis");
    book5.setOwn(false);
    book5.setWantOwn(true);
  
    BookList tester = new BookList();
    User kate = new User("Kate");
    User jabree = new User("Jabree");
    User sarah = new User("Sarah");
    
    UserList trial = new UserList();
    trial.addUser(kate);
    trial.addUser(jabree);
    trial.addUser(sarah);
    // System.out.println(trial.getList().toString());
    
//    tester.addBook(book1, sarah);
//    tester.addBook(book2, jabree);
//    tester.addBook(book3, sarah);
//    tester.addBook(book4, kate);
//    tester.addBook(book5, kate);
    //System.out.println(tester.toString());
    
    //System.out.println(kate.getOurBooks());
    // System.out.println(tester.toString());
    // tester.removeBook(book1);
    // System.out.println(tester.toString());
    
    //tester.search("Title", "Lion");
    // System.out.println(tester.searchDisplay());
    //tester.search("title", "Lio");
    // System.out.println(tester.searchDisplay());
    //tester.search("title", "lio");
    
    //tester.search("author", "Rowling");
    // tester.search("tag", "Magic");
    // tester.search("tag", "Narnia");
    
//System.out.println(tester.searchDisplay());
//  tester.sortByTitle();
//  tester.sortByAuthor();
//  tester.sortByYear();
//  tester.sortByPageLength();
    // System.out.println(tester.sortTitleDisplay());
    //System.out.println(tester.sortAuthorDisplay());
    //System.out.println(tester.sortYearDisplay());
    //System.out.println(tester.sortPageDisplay());
    //System.out.println(tester.getFamilyBooks().toString());
    
//    System.out.println(tester.getMyBooks(kate, trial).toString());
    // System.out.println(tester.getBookOfTheDay().toString());
    
    //tester.saveList(tester.bookList, "Master BookList");
// System.out.println( tester.listLoader("Master BookList", tester.bookList));
//  System.out.println(tester.getWishList("Sarah").toString());
//  System.out.println(tester.getWishList("Kate").toString());
    // System.out.println(tester.genreSorter().toString());
  }
}
