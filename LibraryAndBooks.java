import java.util.ArrayList;
import java.util.List;

// Main class to demonstrate aggregation
public class LibraryAndBooks {
    public static void main(String[] args) {
        // Creating books (independent objects)
        Book firstBook = new Book("Rich Dad Poor Dad", "Robert Kiyosaki");
        Book secondBook = new Book("The Power of Habit", "Charles Duhigg");
        Book thirdBook = new Book("Atomic Habits", "James Clear");
        Book fourthBook = new Book("Deep Work", "Cal Newport");

        // Creating libraries
        Library centralLibrary = new Library("Central Library");
        Library communityLibrary = new Library("Community Library");

        // Adding books to different libraries
        centralLibrary.addBook(firstBook);
        centralLibrary.addBook(secondBook);

        communityLibrary.addBook(thirdBook);
        communityLibrary.addBook(fourthBook);

        // Displaying books in each library
        communityLibrary.showBooks();
        centralLibrary.showBooks();
    }
}

// Library class (contains multiple Book objects)
class Library {
    private String libraryName;
    private List<Book> bookList;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void showBooks() {
        System.out.println("Library: " + libraryName);
        if (bookList.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
        System.out.println();
    }
}

// Book class (can exist independently of a Library)
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{Title='" + title + "', Author='" + author + "'}";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

//output
//Library: Community Library
//Book{Title='Atomic Habits', Author='James Clear'}
//Book{Title='Deep Work', Author='Cal Newport'}

//Library: Central Library
//Book{Title='Rich Dad Poor Dad', Author='Robert Kiyosaki'}
//Book{Title='The Power of Habit', Author='Charles Duhigg'}