package demo;

public class Person implements Passenger {
    @Override
    public void enterIntoCar() {
        System.out.println("person sit into car");
    }
}
