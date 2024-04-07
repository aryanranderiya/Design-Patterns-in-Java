import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Car {
    void drive();
}

// Concrete Flyweight
class ConcreteCar implements Car {
    private String brand;

    public ConcreteCar(String brand) {
        this.brand = brand;
    }

    @Override
    public void drive() {
        System.out.println("Driving " + brand + " car.");
    }
}

// Flyweight Factory
class CarFactory {
    private static Map<String, Car> cars = new HashMap<>();

    public static Car getCar(String brand) {
        Car car = cars.get(brand);
        if (car == null) {
            car = new ConcreteCar(brand);
            cars.put(brand, car);
            System.out.println("Creating new " + brand + " car instance.");
        }
        return car;
    }
}

// Client
public class Pr9_Flyweight {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("Porsche");
        Car car2 = CarFactory.getCar("Lamborghini");
        Car car3 = CarFactory.getCar("Koenigsegg");

        car1.drive();
        car2.drive();
        car3.drive();
    }
}
