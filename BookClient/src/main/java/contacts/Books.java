package contacts;

import java.util.Collection;
import java.util.List;

public class Books {
    private Collection<Book> books;

    public Books() {
    }

    @Override
    public String toString() {
        return "Books{" +
                "books=" + books +
                '}';
    }

    public Books(Collection<Book> contacts) {
        this.books = contacts;
    }
    public Collection<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
