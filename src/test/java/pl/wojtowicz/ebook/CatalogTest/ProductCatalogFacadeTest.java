package pl.wojtowicz.ebook.CatalogTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.wojtowicz.ebook.Book;
import pl.wojtowicz.ebook.BookRepository;
import pl.wojtowicz.ebook.ProductCatalogFacade;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCatalogFacadeTest {

    @Autowired
    BookRepository repository;

    @Test
    public void itAllowAddBookToCatalog() {
        ProductCatalogFacade api = new ProductCatalogFacade(repository);
        Book book = mockedBook();
        api.addBook(book);
        List<Book> books = api.allBooks();
        assertThat(books).hasSize(1);
    }

    private Book mockedBook() {
        return Book.builder()
                .price(BigDecimal.valueOf(12))
                .title("Clean code")
                .build();
    }
}
