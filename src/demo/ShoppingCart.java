package demo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShoppingCart {

    private Integer id;

    private List<Item> items;
}
