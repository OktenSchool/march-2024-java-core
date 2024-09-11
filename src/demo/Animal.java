package demo;

public class Animal implements Passenger{
    @Override
    public void enterIntoCar() {
        System.out.println("animal entered into car");
    }
}
