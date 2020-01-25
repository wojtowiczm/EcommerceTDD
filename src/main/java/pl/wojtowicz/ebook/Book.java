package pl.wojtowicz.ebook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
@Entity
public class Book {

    private Book() {}
    @Id
    @GeneratedValue
    Long id;

    String title;
    BigDecimal price;
}
