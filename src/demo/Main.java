package demo;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Car car2 = new Car("bmw", null);
        Car.Engine car2Engine = car2.new Engine();
        car2Engine.setModel("v6");
        car2Engine.setTorque(123);
        car2Engine.setHorsePower(123);
        car2.setEngine(car2Engine);

        Car car = Car.builder()
                .model("tesla")
                .build();
        Car.Engine engine = car.new Engine();
        engine.setModel("ev 900");
        engine.setTorque(300);
        engine.setHorsePower(200);
        car.setEngine(engine);

        System.out.println(car);
        car.getEngine().start();

        car.executeRepair(() -> System.out.println("one-time repair"));
        car.executeRepair(() -> System.out.println("other one-time repair"));

        Supplier<String> supplier = () -> "asdads";
        Function<String, Integer> calculateLength = String::length;
        BiFunction<String, String, Integer> calculateTotalLength = (x, z) -> x.length() + z.length();
        Consumer<String> consumer = (text) -> {
            System.out.println(text + " | length = " + calculateLength.apply(text));
            System.out.println("text was printed");
        };

        consumer.accept(supplier.get());
    }
}
