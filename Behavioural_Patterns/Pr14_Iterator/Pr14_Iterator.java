import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Aggregate interface
interface CarCollection {
    Iterator<Car> createIterator();
}

// Concrete Aggregate
class CarList implements CarCollection {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public Iterator<Car> createIterator() {
        return cars.iterator();
    }
}

// Concrete Item
class Car {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

// Client code
public class Pr14_Iterator {
    public static void main(String[] args) {
        CarList carList = new CarList();
        carList.addCar(new Car("Porsche"));
        carList.addCar(new Car("Bugatti"));
        carList.addCar(new Car("Lamborghini"));

        Iterator<Car> iterator = carList.createIterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            System.out.println("Brand: " + car.getBrand());
        }
    }
}
