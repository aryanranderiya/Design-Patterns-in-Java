import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Car {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// Concrete Subject
class CarModel implements Car {
    private String brand;
    private List<Observer> observers = new ArrayList<>();

    public void setBrand(String brand) {
        this.brand = brand;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer added: " + observer.getClass().getSimpleName());
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer removed: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(brand);
        }
    }
}

// Observer interface
interface Observer {
    void update(String brand);
}

// Concrete Observer
class CarDisplay implements Observer {
    @Override
    public void update(String brand) {
        System.out.println("Car Display updated: Brand - " + brand);
    }
}

// Client code
public class Pr12_Observer {
    public static void main(String[] args) {
        CarModel carModel = new CarModel();
        CarDisplay carDisplay = new CarDisplay();

        carModel.addObserver(carDisplay);

        System.out.println("Observer registered: Car Display");

        // Simulate brand change
        carModel.setBrand("Porsche");
    }
}
