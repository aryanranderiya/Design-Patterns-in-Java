// Subsystem classes
class Engine {
    public void start() {
        System.out.println("Engine started");
    }

    public void stop() {
        System.out.println("Engine stopped");
    }
}

class Lights {
    public void turnOn() {
        System.out.println("Lights turned on");
    }

    public void turnOff() {
        System.out.println("Lights turned off");
    }
}

class FuelInjector {
    public void injectFuel() {
        System.out.println("Fuel injected");
    }
}

// Facade class
class CarFacade {
    private Engine engine;
    private Lights lights;
    private FuelInjector fuelInjector;

    public CarFacade() {
        this.engine = new Engine();
        this.lights = new Lights();
        this.fuelInjector = new FuelInjector();
    }

    public void startCar() {
        System.out.println("Starting the car...");
        engine.start();
        lights.turnOn();
        fuelInjector.injectFuel();
        System.out.println("Car started successfully!");
    }

    public void stopCar() {
        System.out.println("Stopping the car...");
        engine.stop();
        lights.turnOff();
        System.out.println("Car stopped");
    }
}

// Client class
public class Pr8_Facade {
    public static void main(String[] args) {
        System.out.println("Creating a car facade...");
        CarFacade car = new CarFacade();

        // Starting the car
        System.out.println("\nAttempting to start the car...");
        car.startCar();

        // Stopping the car
        System.out.println("\nAttempting to stop the car...");
        car.stopCar();

        System.out.println("\nExiting the program.");
    }
}
