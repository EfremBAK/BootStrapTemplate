package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    EmailSender emailSender;
    @Autowired
    JmsSender jmsSender;

    public void addBook(Book book) {
        bookRepository.save(book);
        emailSender.sendEmail("New arrival", "efrem@yahoo.com");
        jmsSender.sendMessage(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByISBN(isbn);
    }

    public void deleteBook(String isbn) {
        Book book = bookRepository.findByISBN(isbn);
        bookRepository.remove(isbn);
        emailSender.sendEmail("Sold out", "efrem@yahoo.com");
    }

    public Collection<Book> getAllBooks(){
        return bookRepository.findAll();
    }

}
