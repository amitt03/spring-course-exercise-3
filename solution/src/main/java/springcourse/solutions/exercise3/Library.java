package springcourse.solutions.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcourse.solutions.exercise3.dao.api.IBookDao;
import springcourse.solutions.exercise3.dao.api.IMemberDao;
import springcourse.solutions.exercise3.model.Book;
import springcourse.solutions.exercise3.model.Genre;
import springcourse.solutions.exercise3.model.Member;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Amit Tal
 * @since 3/24/14
 */
@Service
public class Library {

    private Logger logger = LoggerFactory.getLogger(Library.class);

    private IBookDao bookDao;
    private IMemberDao memberDao;
    private BookAnalyzer bookAnalyzer;

    @Autowired
    public Library(IBookDao bookDao, IMemberDao memberDao, BookAnalyzer bookAnalyzer) {
        this.bookDao = bookDao;
        this.memberDao = memberDao;
        this.bookAnalyzer = bookAnalyzer;
    }

    @PostConstruct
    public void open() {
        if (bookDao.checkConnection()) {
            logger.info("The library is now open");
        } else {
            logger.info("The library is temporarily unavailable");
        }
    }

    public Member createMembership(Member member) {
        Member dbMember = memberDao.createMember(member);
        return dbMember;
    }

    public Book addNewBook(Book newBook) {
        Genre genre = bookAnalyzer.analyzeBook(newBook);
        newBook.setGenre(genre);
        Book dbBook = bookDao.addBook(newBook);
        return dbBook;
    }

    public void removeBook(String catalogId) {
        bookDao.removeBook(catalogId);
    }

    public Collection<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public Collection<Book> searchBooksByAuthor(String author) {
        Collection<Book> allBooks = bookDao.getAllBooks();
        Collection<Book> booksByAuthor = new ArrayList<Book>();
        for (Book book : allBooks) {
            if (author.equals(book.getAuthor())) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    @PreDestroy
    public void close() {
        logger.info("The library is now closed");
    }

}
