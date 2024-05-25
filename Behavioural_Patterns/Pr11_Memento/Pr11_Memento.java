// Snapshot class
class CarSnapshot {
    private String state;

    public CarSnapshot(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Car class
class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void changeBrandAndModel(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public CarSnapshot saveSnapshot() {
        return new CarSnapshot(brand + " " + model);
    }

    public void restoreFromSnapshot(CarSnapshot snapshot) {
        String[] parts = snapshot.getState().split(" ");
        this.brand = parts[0];
        this.model = parts[1];
    }

    public void display() {
        System.out.println("Current Car: " + brand + " " + model);
    }
}

// Caretaker class
class CarSnapshotCaretaker {
    private CarSnapshot snapshot;

    public void saveSnapshot(CarSnapshot snapshot) {
        this.snapshot = snapshot;
    }

    public CarSnapshot retrieveSnapshot() {
        return snapshot;
    }
}

// Client code
public class Pr11_Memento {
    public static void main(String[] args) {
        Car car = new Car("Porsche", "911");
        CarSnapshotCaretaker caretaker = new CarSnapshotCaretaker();

        // Save initial state
        caretaker.saveSnapshot(car.saveSnapshot());
        System.out.println("Original Car:");
        car.display();

        // Change state
        car.changeBrandAndModel("Bugatti", "Veyron");
        System.out.println("\nAfter Changing Brand and Model:");
        car.display();

        // Restore saved state
        car.restoreFromSnapshot(caretaker.retrieveSnapshot());
        System.out.println("\nRestored Car:");
        car.display();
    }
}
