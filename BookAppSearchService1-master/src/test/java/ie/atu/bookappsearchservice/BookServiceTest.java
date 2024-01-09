package ie.atu.bookappsearchservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testSearchBooks() {
        // Mocking data
        String keyword = "Java";
        Book book1 = createSampleBook("1", "Java Programming", "Author 1", "2022-01-01", "http://example.com/review1", "http://example.com/poster1", Arrays.asList("Programming", "Java"), Arrays.asList("Backdrop1", "Backdrop2"));
        Book book2 = createSampleBook("2", "Advanced Java", "Author 2", "2022-01-02", "http://example.com/review2", "http://example.com/poster2", Arrays.asList("Programming", "Java"), Arrays.asList("Backdrop3", "Backdrop4"));
        List<Book> mockBooks = Arrays.asList(book1, book2);

        // Mocking repository method
        when(bookRepository.findByTitleContainingIgnoreCase(keyword)).thenReturn(mockBooks);

        // Call the service method
        List<Book> result = bookService.searchBooks(keyword);

        // Assert the result
        assertEquals(mockBooks.size(), result.size());
        assertEquals(mockBooks, result);
        verify(bookRepository, times(1)).findByTitleContainingIgnoreCase(keyword);
    }

    private Book createSampleBook(String bookId, String title, String author, String releaseDate, String reviewLink, String poster, List<String> genres, List<String> backdrops) {
        Book book = new Book();
        book.setBookId(bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setReleaseDate(releaseDate);
        book.setReviewLink(reviewLink);
        book.setPoster(poster);
        book.setGenres(genres);
        book.setBackdrops(backdrops);
        return book;
    }
}

