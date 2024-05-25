// Model: Car
class Car {
    private String brand;
    private String model;
    private int speed;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.speed = 0;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void accelerate() {
        speed += 10;
    }

    public void brake() {
        if (speed > 0) {
            speed -= 10;
        }
    }
}

// View: CarView
class CarView {
    public void displayCarDetails(String brand, String model, int speed) {
        System.out.println("Car: " + brand + " " + model + ", Speed: " + speed + " km/h");
    }
}

// Controller: CarController
class CarController {
    private Car model;
    private CarView view;

    public CarController(Car model, CarView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.displayCarDetails(model.getBrand(), model.getModel(), model.getSpeed());
    }

    public void accelerateCar() {
        System.err.println("Accelerating...");
        model.accelerate();
        updateView();
    }

    public void brakeCar() {
        System.err.println("Braking...");
        model.brake();
        updateView();
    }
}

// Main class
public class Pr15_MVC {
    public static void main(String[] args) {
        // Create model, view, and controller
        Car carModel = new Car("Porsche", "911");
        CarView carView = new CarView();
        CarController carController = new CarController(carModel, carView);

        // Display initial car details
        carController.updateView();

        // Accelerate the car and display updated details
        carController.accelerateCar();
        carController.accelerateCar();
        carController.accelerateCar();

        // Brake the car and display updated details
        carController.brakeCar();
        carController.brakeCar();
        carController.brakeCar();
    }
}
