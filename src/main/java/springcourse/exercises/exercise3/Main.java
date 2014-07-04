package springcourse.exercises.exercise3;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springcourse.exercises.exercise3.model.Book;
import springcourse.exercises.exercise3.model.Member;

import java.util.Collection;

/**
 * @author Amit Tal
 * @since 3/24/14
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Library library = applicationContext.getBean(Library.class);

        // Create Membership
        library.createMembership(new Member("Your", "Name", "your.name@sc101.com"));

        // Add new books
        library.addNewBook(new Book("Alice in Wonderland", "Lewis Carroll"));
        library.addNewBook(new Book("A Tangled Tale", "Lewis Carroll"));
        library.addNewBook(new Book("The Hobbit", "J. R. R. Tolkien"));
        library.addNewBook(new Book("The Fellowship of the Ring", "J. R. R. Tolkien"));
        library.addNewBook(new Book("The Two Towers", "J. R. R. Tolkien"));
        library.addNewBook(new Book("The Return of the King", "J. R. R. Tolkien"));

        // Read all books
        Collection<Book> allBooks = library.getAllBooks();
        Assert.assertEquals(6, allBooks.size());

        Collection<Book> jrrTolkienBooks = library.searchBooksByAuthor("J. R. R. Tolkien");
        Assert.assertEquals(4, jrrTolkienBooks.size());
    }
}
