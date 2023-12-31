package ie.atu.bookappsearchservice;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSearchBooks() {
        // Act
        ResponseEntity<Book[]> responseEntity = restTemplate.getForEntity("/api/search/books?keyword=test", Book[].class);
        Book[] books = responseEntity.getBody();

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(1, books.length);
    }
}

