package ie.atu.bookappsearchservice;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testSearchBooks() {
        // Arrange
        when(bookRepository.findByTitleContainingIgnoreCase(anyString())).thenReturn(Collections.singletonList(new Book()));

        // Act
        List<Book> result = bookService.searchBooks("test");

        // Assert
        assertEquals(1, result.size());
    }
}
