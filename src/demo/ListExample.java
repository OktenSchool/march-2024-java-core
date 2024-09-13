package demo;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Яблуко");
        list.add("Ананас");
        list.add("Банан");

        System.out.println(list);

        System.out.println("Element at index 2: " + list.get(2));

        list.remove("Ананас");

        System.out.println(list);

        if (list.contains("Банан")) {
            System.out.println("У нас є банан");
        }

        List<String> personNames = new LinkedList<>(List.of("John", "Melinda", "Anton"));

        personNames.add("Ivan");

        for (String personName : personNames) {
            System.out.println(personName);
        }

        Queue<String> queue = new LinkedList<>();
        queue.addAll(personNames);

        System.out.println(queue);

        String peekedPerson = queue.peek();
        System.out.println("Queue after peek: " + queue);

        String polledPerson = queue.poll();
        System.out.println("Queue after poll: " + queue);
    }
}
