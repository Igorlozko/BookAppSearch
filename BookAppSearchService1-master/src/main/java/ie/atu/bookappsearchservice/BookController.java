package ie.atu.bookappsearchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001") // Add the origin of your frontend application
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("api/search/books")
    public List<Book> searchBooks(@RequestParam String keyword) {
        System.out.println("Received search request for keyword: " + keyword);
        List<Book> searchResults = bookService.searchBooks(keyword);
        System.out.println("Search results: " + searchResults);
        return searchResults;
        //return bookService.searchBooks(keyword);
    }
}