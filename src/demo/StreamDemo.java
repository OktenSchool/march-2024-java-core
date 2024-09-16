package demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Яблуко");
        list.add("Ананас");
        list.add("Банан");

        for (String fruit : list) {
            if (fruit.contains("а")) {
                String fruitWithNewLetters = fruit.replaceAll("а", "о");
                System.out.println(fruitWithNewLetters);
            }
        }

        System.out.println("With streams: ");
        list.stream()
                .filter(fruit -> fruit.contains("а"))
                .map(fruit -> {
                    System.out.println("[1] replacing letters in word: " + fruit);
                    return fruit.replaceAll("а", "о");
                })
                .forEach(System.out::println);

        Stream<String> fruitsStream = list
                .stream()
                .filter(fruit -> fruit.contains("а"))
                .map(fruit -> {
                    System.out.println("[2] replacing letters in word: " + fruit);
                    return fruit.replaceAll("а", "о");
                });

        System.out.println(fruitsStream);

        String result = fruitsStream.collect(Collectors.joining(","));
        System.out.println(result);

        Set<String> fruits = list.stream()
                .filter(fruit -> fruit.contains("а"))
                .map(fruit -> {
                    System.out.println("[3] replacing letters in word: " + fruit);
                    return fruit.replaceAll("а", "о");
                })
                .collect(Collectors.toSet());
        // stream was terminated, we can not reuse fruitsStream
//        Set<String> fruits = fruitsStream.forEach(System.out::println);
        System.out.println(fruits);
    }
}
