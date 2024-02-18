import java.util.ArrayList;
import java.util.List;

// Component interface
interface CarComponent {
    void display(); // Common method for displaying car components
}

// Leaf class representing the engine
class Engine implements CarComponent {
    @Override
    public void display() {
        System.out.println("Engine");
    }
}

// Leaf class representing a wheel
class Wheel implements CarComponent {
    @Override
    public void display() {
        System.out.println("Wheel");
    }
}

// Leaf class representing the car body
class Body implements CarComponent {
    @Override
    public void display() {
        System.out.println("Body");
    }
}

// Composite class representing the entire car
class CarComposite implements CarComponent {
    private List<CarComponent> components = new ArrayList<>(); // List to store child components

    // Method to display the entire car structure
    @Override
    public void display() {
        System.out.println("Car Structure:");
        for (CarComponent component : components) {
            // System.out.println("Car Structure:");
            component.display(); // Delegating display to child components
        }
    }

    // Method to add a component to the car
    public void addComponent(CarComponent component) {
        components.add(component);
    }

    // Method to remove a component from the car
    public void removeComponent(CarComponent component) {
        components.remove(component);
    }
}

// Example usage
public class Pr6_Composite {
    public static void main(String[] args) {
        // Create leaf objects
        Engine engine = new Engine();
        Wheel frontLeftWheel = new Wheel();
        Wheel frontRightWheel = new Wheel();
        Wheel rearLeftWheel = new Wheel();
        Wheel rearRightWheel = new Wheel();
        Body carBody = new Body();

        // Create composite objects
        CarComposite frontAxle = new CarComposite();
        CarComposite rearAxle = new CarComposite();
        CarComposite car = new CarComposite();

        // Build the car structure
        frontAxle.addComponent(frontLeftWheel);
        frontAxle.addComponent(frontRightWheel);

        rearAxle.addComponent(rearLeftWheel);
        rearAxle.addComponent(rearRightWheel);

        car.addComponent(engine);
        car.addComponent(frontAxle);
        car.addComponent(rearAxle);
        car.addComponent(carBody);

        // Display the entire car structure
        car.display();
    }
}
