package pl.wojtowicz.ebook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class Book {
    String title;
    BigDecimal price;
}
