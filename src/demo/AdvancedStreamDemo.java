package demo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedStreamDemo {

    public static void main(String[] args) {
        Item laptop = new Item("Laptop", 12345.99);
        Item pencil = new Item("Pencil", 3.32);
        Item phone = new Item("Phone", 999);
        Item tablet = new Item("Tablet", 1999);
        Item monitor = new Item("Monitor", 400);
        Item keyboard = new Item("Keyboard", 5600);

        List<Person> persons = List.of(
                new Person("John", 22, List.of(
                        new ShoppingCart(1, List.of(laptop, phone, monitor)),
                        new ShoppingCart(2, List.of(pencil, phone, tablet)),
                        new ShoppingCart(3, List.of(pencil, monitor))
                )),
                new Person("Mike", 35, List.of(
                        new ShoppingCart(4, List.of(keyboard, pencil)),
                        new ShoppingCart(5, List.of(tablet)),
                        new ShoppingCart(6, List.of(monitor, phone, keyboard, tablet))
                )),
                new Person("Jack", 15, List.of(
                        new ShoppingCart(7, List.of(tablet, pencil)),
                        new ShoppingCart(8, List.of(monitor, keyboard))
                ))
        );

        persons.stream()
                .map(Person::getAge)
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);

        // Classic approach
        List<ShoppingCart> shoppingCarts = new LinkedList<>();
        for (Person person : persons) {
            shoppingCarts.addAll(person.getShoppingCarts());
        }
        List<Item> items = new LinkedList<>();
        for (ShoppingCart shoppingCart : shoppingCarts) {
            items.addAll(shoppingCart.getItems());
        }
        Item itemWithMaxPrice = null;
        double maxPrice = 0;
        for (Item item : items) {
            if (item.getPrice() > maxPrice) {
                maxPrice = item.getPrice();
                itemWithMaxPrice = item;
            }
        }
        System.out.println(itemWithMaxPrice);

        // Approach with StreamAPI
        persons.stream()
                .flatMap(person -> person.getShoppingCarts().stream())
                .flatMap(shoppingCart -> shoppingCart.getItems().stream())
                .max(Comparator.comparingDouble(Item::getPrice))
                .ifPresent(System.out::println);

        //перерахувати товари, де лежить планшет або мобілка
        List<ShoppingCart> shoppingCartsWithTabletOrPhone = persons.stream()
                .flatMap(person -> person.getShoppingCarts().stream())
                .filter(shoppingCart -> shoppingCart
                        .getItems()
                        .stream()
                        .anyMatch(item -> item.getName().equals(tablet.getName()) || item.getName().equals(phone.getName())))
                .toList();

        //перерахувати персон, де лежить планшет і мобілка
        List<Person> personsWhoHasPhoneAndTabletInShoppingCart = persons.stream()
                .filter(person -> person.getShoppingCarts().stream()
                        .anyMatch(shoppingCart -> shoppingCart.getItems().stream()
                                .anyMatch(item -> item.getName().equals(tablet.getName()))
                                && shoppingCart.getItems().stream()
                                .anyMatch(item -> item.getName().equals(phone.getName()))))
                .toList();

        System.out.println("Shopping carts with tablet OR phone: ");
        System.out.println(shoppingCartsWithTabletOrPhone.stream().map(ShoppingCart::toString).collect(Collectors.joining(", \n")));

        System.out.println("Persons who has shopping carts with tablet AND phone: ");
        System.out.println(personsWhoHasPhoneAndTabletInShoppingCart.stream().map(Person::getName).collect(Collectors.joining(", \n")));

        // OrderSummary
        persons.stream()
                .parallel()
                .map(person -> person.getShoppingCarts().stream()
                        .flatMap(shoppingCart -> shoppingCart.getItems().stream())
                        .collect(
                                () -> new OrdersSummary(person.getName(), 0, 0),
                                (ordersSummary, item) -> ordersSummary.add(1, item.getPrice()),
                                ((ordersSummary1, ordersSummary2) -> ordersSummary1.add(ordersSummary2.getTotalItemsCount(), ordersSummary2.getTotalPrice()))))
                .forEach(System.out::println);
        persons.stream()
                .parallel()
                .map(person -> person.getShoppingCarts().stream()
                        .flatMap(shoppingCart -> shoppingCart.getItems().stream())
                        .reduce(new OrdersSummary(person.getName(), 0, 0),
                                (ordersSummary, item) -> ordersSummary.add(1, item.getPrice()),
                                ((ordersSummary1, ordersSummary2) -> ordersSummary1.add(ordersSummary2.getTotalItemsCount(), ordersSummary2.getTotalPrice()))))
                .forEach(System.out::println);

        // distinct (unique elements)
        List<Item> allItems = persons.stream()
                .flatMap(person -> person.getShoppingCarts().stream())
                .flatMap(shoppingCart -> shoppingCart.getItems().stream())
                .distinct()
                .toList();
        System.out.println(allItems);
    }
}
