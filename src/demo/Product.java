package demo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Setter(AccessLevel.PRIVATE)
    private int id;

    private String name;

    private BigDecimal price;

    private ArrayList reviews = new ArrayList();

    public Product(String name) {
        this.name = name;
    }
}
