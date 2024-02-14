// Car class representing a car with specific details
class Car {
    private String model, color, brand;
    private int year;

    // Lazy-initialized singleton instance of Car
    private static Car carObject = null;

    // Private constructor to prevent direct instantiation
    private Car() {
        // Setting default values for brand, model, year, and color
        this.brand = "Porsche";
        this.model = "911";
        this.year = 2024;
        this.color = "Black";
        System.out.println("Constructor Called");
    }

    // Getter method to retrieve the singleton instance of Car
    public static Car getInstance() {
        return carObject;
    }

    // Setter method to create a new Car instance if it doesn't already exist
    public static void setInstance() {
        if (carObject == null) {
            carObject = new Car();
            System.out.println("Car Instance successfully set");
        } else
            System.out.println("Car Instance Already Exists!! You can access it using 'getInstance()' method.\n");
    }

    // Method to print the details of the car
    public void printDetails() {
        System.out.println("Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                "}");
    }
}

// Main class to demonstrate the lazy singleton pattern
public class Pr5_Singleton_Lazy {

    public static void main(String[] args) {

        // Setting and displaying the first instance of the Car
        System.out.println("\nSetting Instance 1: ");
        Car.setInstance();

        // Setting and displaying the second instance of the Car
        System.out.println("\nSetting Instance 2: ");
        Car.setInstance();

        // Retrieving the first instance and printing its details
        Car carObject1 = Car.getInstance();
        System.out.println("Details of Car Object 1");
        carObject1.printDetails();

        // Retrieving the second instance and printing its details
        Car carObject2 = Car.getInstance();
        System.out.println("Details of Car Object 2");
        carObject2.printDetails();

        // Checking if both objects refer to the same instance
        if (carObject1 == carObject2) {
            System.out.println("Both objects are the same instance.");
        }
    }
}
