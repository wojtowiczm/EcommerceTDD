package pl.wojtowicz.ebook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfiguration {

    @Bean
    ProductCatalogFacade facade(BookRepository repository) {
        ProductCatalogFacade facade = new ProductCatalogFacade(repository);
        Book a = Book.builder().title("aaa").build();
        Book b = Book.builder().title("bbb").build();
        facade.addBook(a);
        facade.addBook(b);
        return facade;
    }
}
