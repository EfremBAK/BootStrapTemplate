package books;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

    //in memory map of books using isbn as key
    private Map<String, Book> books = new HashMap<>();

    public void save(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book findByISBN(String isbn) {
//        return new Book("2134", "George Orwel", "1984", 12.5);
        return books.get(isbn);
    }

    public void remove(String isbn){
        books.remove(isbn);
    }

    public Collection<Book> findAll(){
        return books.values();
    }
}


/*
addBook(Book book);
updateBook(Book book);
deleteBook(String isbn);
getBook(String isbn);
getAllBooks();
 */