package demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdersSummary {

    private String personName;

    private int totalItemsCount;

    private double totalPrice;

    public OrdersSummary add(int count, double price) {
        totalItemsCount += count;
        totalPrice += price;
        return this;
    }
}
