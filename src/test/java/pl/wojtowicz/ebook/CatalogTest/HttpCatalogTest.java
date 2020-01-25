package pl.wojtowicz.ebook.CatalogTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.wojtowicz.ebook.Book;
import pl.wojtowicz.ebook.ProductCatalogFacade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HttpCatalogTest {

    @Autowired
    TestRestTemplate http;

    @Autowired
    ProductCatalogFacade productCatalogFacade;

    @LocalServerPort
    int port;

    @Test
    public void testListProductsViaHttpEndpoint() {

        Book firstBook = mockedBook("A");
        Book secondBook = mockedBook("B");
        productCatalogFacade.addBook(firstBook);
        productCatalogFacade.addBook(secondBook);

        ResponseEntity<Book[]> res = http.getForEntity(
                String.format("http://localhost:%s/api/products", port),
                Book[].class
        );
                assertThat(res).isEqualTo(HttpStatus.OK);
                assertThat(mapToTitles(res.getBody())).contains(firstBook.getTitle());
    }

    private List<String> mapToTitles(Book[] array) {
        return Stream.of(array)
                .map(b -> b.getTitle())
                .collect(Collectors.toList());
    }
    private Book mockedBook(String title) {
        return Book.builder().title(title).build();
    }
}
