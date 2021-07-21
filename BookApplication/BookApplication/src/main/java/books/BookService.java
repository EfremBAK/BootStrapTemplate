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

    public void addBook(Book book) {
        bookRepository.save(book);
//        emailSender.sendEmail("Welcome", contacts.getEmail());
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByISBN(isbn);
    }

    public void deleteBook(String isbn) {
        bookRepository.remove(isbn);
    }

    public Collection<Book> getAllBooks(){
        return bookRepository.findAll();
    }

}
