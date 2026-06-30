import java.util.*;
class Book{
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String id,String title,String author){
        this.id=id;
        this.title=title;
        this.author=author;
        this.isBorrowed=false;
    }
    public String getId(){return id;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public boolean isBorrowed(){return isBorrowed;}

    public void borrowBook(){this.isBorrowed=true;}
    public void returnBook(){this.isBorrowed=false;}

    public String toString(){
        return "ID"+id+"|Title:"+title+"|Author:"+author+"|Status:"+(isBorrowed ? "Borrowed":"Available");

    }
}
class Member{
    private String id;
    private String name;
    private List<Book>borrowedBooks;
    public  Member(String id,String name){
        this.id=id;
        this.name=name;
        this.borrowedBooks=new ArrayList<>();
    }
    public String getId(){return id;}
    public String getName(){return name;}
    public List<Book>getBorrowedBooks(){return borrowedBooks; }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }
    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }
    public String toString(){
        return "Member ID:"+id+"|name:"+name+"|Books borrowed:"+borrowedBooks.size();
    }
}
class Library{
    private List <Book> books=new ArrayList<>();
    private List<Member> members=new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
        System.out.println("Sucess");
    }
    public void viewBooks(){
        if(books.isEmpty()){
            System.out.println("Notice: no books available");
            return;
        }
        System.out.println("\n---Library Books---");
        for(Book book:books){
            System.out.println(book);
        }
    }
    public Book findBook(String id){
        for(Book book:books){
            if(book.getId().equalsIgnoreCase(id)){
                return book;
            }
        }
            return null;

    }
    public void registerMember(Member member){
        members.add(member);
        System.out.println("Sucess:Member registered.");
    }
    public void viewMembers(){
        if(members.isEmpty()){
            System.out.println("Notice:No members registered yet.");
            return;
        }
        System.err.println("\n---- registered member----");
        for(Member member:members){
            System.out.println(member);
        }
    }
    public Member findMember(String id){
        for(Member member:members){
            if(member.getId().equalsIgnoreCase(id))
                return member;
        }
        return null;
    }
    public void issueBook(String bookId,String memberId){
        Book book=findBook(bookId);
        Member member=findMember(memberId);

        if(book==null){
            System.out.println("Error");
            return;
        }
        if(member==null){
            System.out.println("Error:Member details not found:");
            return;
        }
        if(book.isBorrowed()){
            System.out.println("Error:Book is already checked out.");
            return;
        }
        book.borrowBook();
        member.borrowBook(book);
        System.out.println("Success: Book issued to"+member.getName()+".");

    }
    public void returnBook(String bookId,String MemberId){
        Book book=findBook(bookId);
        Member member=findMember(MemberId);
        if(book==null||member==null){
            System.out.println("Invalid book");
            return;
        }
        if(!member.getBorrowedBooks().contains(book)){
            System.out.println("Member does not have this check");
            return;
        }
        book.returnBook();
        member.returnBook(book);
        System.out.println("book return sucessfully");
    }
}
public class Problem109{
    public static void main(String[] args){
        Library library=new Library();
        Scanner sc=new Scanner(System.in);
        library.addBook(new Book("B1","Effective java","Joshua Bloch"));
        library.addBook(new Book("B2","Clean Code","Robert c.martin"));
        library.registerMember(new Member("M1","Alice Smith"));

        while(true){
            System.out.println("\n====LIBRARY MANAGEMENT SYSTEM====");
            System.out.println("1.Add a new Book");
            System.out.println("2.Register a new member");
            System.out.println("3.view all books");
            System.out.println("4.View all member");
            System.out.println("5.Issue a book");
            System.out.println("Return a book");
            System.out.println("Exit system");
            System.out.println("Select an option:");

            String choice=sc.nextLine();
            switch(choice){
                case "1":
                    System.out.println("Enter unique book ID:");
                    String bId=sc.nextLine();
                    System.out.println("Enter book title");
                    String title=sc.nextLine();
                    System.out.println("Enter author name");
                    String author=sc.nextLine();
                    library.addBook(new Book(bId,title,author));
                    break;
                case "2":
                    System.out.println("Enter Unique MemberID:");
                    String mId=sc.nextLine();
                    System.out.println("Enter member name");
                    String name=sc.nextLine();
                    library.registerMember(new Member(mId, name));    
                    break;
                case "3":
                    library.viewBooks();
                    break;
                case "4":
                    library.viewMembers();
                    break;
                case "5":
                    System.out.println("Enter BookId to issue:");
                    String issueBId=sc.nextLine();
                    System.out.println("Enter member ID:");
                    String issueMId=sc.nextLine();
                    library.issueBook(issueBId,issueMId);
                    break;
                case "6":
                    System.out.println("Enter Book ID to return:");
                    String returnBId=sc.nextLine();
                    System.out.println("Enter Member ID:");
                    String returnMId=sc.nextLine();
                    library.returnBook(returnBId,returnMId);
                    break;
                case "7":
                    System.out.println("Shutting down the library:");
                default:
                    System.out.println("invalid selection.");        
            }
        }

    }
}