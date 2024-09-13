package demo;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
        Set<Person> persons = new TreeSet<>(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName).reversed());

        Person john = new Person("John", 34);
        persons.add(john);

        Person jane = new Person("Jane", 23);
        persons.add(jane);

        Person mike = new Person("Mike", 22);
        persons.add(mike);

        Person melinda = new Person("Melinda", 15);
        persons.add(melinda);

        Person anton = new Person("Anton", 22);
        persons.add(anton);

        // For SortedSet<Person>
//        System.out.println(persons.first());
//        System.out.println(persons.last());

        System.out.println(persons);
    }
}
