package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {
        Map<String, Person> persons = new TreeMap<>();

        Person john = new Person("John", 34);
        persons.put(john.getName(), john);

        Person jane = new Person("Jane", 23);
        persons.put(jane.getName(), jane);

        Person mike = new Person("Mike", 22);
        persons.put(mike.getName(), mike);

        Person melinda = new Person("Melinda", 15);
        persons.put(melinda.getName(), melinda);

        Person anton = new Person("Anton", 22);
        persons.put(anton.getName(), anton);

        System.out.println(persons);

        persons.remove(john.getName());

        System.out.println(persons);

        System.out.println("Person names: " + persons.keySet());
    }
}
