package springcourse.exercises.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springcourse.exercises.exercise3.dao.api.IBookDao;
import springcourse.exercises.exercise3.model.Book;
import springcourse.exercises.exercise3.model.Member;

import java.util.Collection;

/**
 * @author Amit Tal
 * @since 3/24/14
 */
public class Library {

    private Logger logger = LoggerFactory.getLogger(Library.class);

    // TODO Need to get reference to IBookDao
    private IBookDao bookDao;


    public void open() {
        if (bookDao.checkConnection()) {
            logger.info("The library is now open");
        } else {
            logger.info("The library is temporarily unavailable");
        }
    }

    public Member createMembership(Member member) {
        // TODO Implement
        return null;
    }

    public Book addNewBook(Book newBook) {
        // TODO Implement
        return null;
    }

    public void removeBook(String catalogId) {
        bookDao.removeBook(catalogId);
    }

    public Collection<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public Collection<Book> searchBooksByAuthor(String author) {
        // TODO Implement
        return null;
    }

    public void close() {
        logger.info("The library is now closed");
    }

}
