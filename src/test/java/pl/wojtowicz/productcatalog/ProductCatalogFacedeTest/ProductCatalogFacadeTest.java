package pl.wojtowicz.productcatalog.ProductCatalogFacedeTest;

import org.junit.Test;
import pl.wojtowicz.ebook.Book;
import pl.wojtowicz.ebook.ProductCatalogFacade;
import org.assertj.core.*

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogFacadeTest {

    @Test
    public void itAllowAddBookToCatalog() {
        ProductCatalogFacade api = new ProductCatalogFacade();
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
