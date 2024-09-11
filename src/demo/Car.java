package demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private String model;

    private Engine engine;

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public void drive() {
        engine.start();
    }

    public void executeRepair(Repair repair) {
        System.out.println("start repair");
        repair.perform();
        System.out.println("end repair");
    }

    // Inner non-static class
    @Data
    public class Engine {

        private String model;

        private double torque;

        private double horsePower;

        public void start() {
            System.out.println("start engine " + model + " with torque " + torque + " and horse power " + horsePower);
            String carModel = Car.this.model;
        }
    }

    // Inner static class
    public static class CarBuilder {

        private String model;

        private Engine engine;

        public CarBuilder() {
        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Car build() {
            return new Car(model, engine);
        }
    }
}
