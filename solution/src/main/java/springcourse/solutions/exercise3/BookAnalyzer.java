package springcourse.solutions.exercise3;

import org.springframework.stereotype.Component;
import springcourse.solutions.exercise3.model.Book;
import springcourse.solutions.exercise3.model.Genre;

/**
 * @author Amit Tal
 * @since 3/24/14
 */
@Component
public class BookAnalyzer {

    public Genre analyzeBook(Book book) {
        // This is a fake genre analyzer, do not take the following serious
        Genre genre = Genre.NA;
        String details = book.getDetails();
        if (details != null) {
            if (details.contains("kiss")) {
                genre = Genre.ROMANCE;
            } else if (details.contains("ha ha ha")) {
                genre = Genre.COMEDY;
            } else if (details.contains("scream")) {
                genre = Genre.HORROR;
            } else if (details.contains("shoot")) {
                genre = Genre.ACTION;
            } else if (details.contains("magic")) {
                genre = Genre.FICTION;
            }
        }
        return genre;
    }
}
