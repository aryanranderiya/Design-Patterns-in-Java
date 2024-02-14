// Car class representing a car with specific details
class Car {
    private String model, color, brand;
    private int year;

    // Singleton instance of Car, initialized to null
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

    // Synchronized setter method to create a new Car instance if it doesn't already
    // exist
    public static synchronized void setInstance() {
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

// Main class to demonstrate the synchronized singleton pattern
public class Pr5_Singleton_Synchronized {

    public static void main(String[] args) {

        // Creating and starting Thread t1
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("\nSetting Instance 1: ");
                Car.setInstance();
                Car carObject1 = Car.getInstance();
                System.out.println("Details of Car Object 1");
                carObject1.printDetails();
            }
        });

        // Creating and starting Thread t2
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("\nSetting Instance 2: ");
                Car.setInstance();
                Car carObject2 = Car.getInstance();
                System.out.println("Details of Car Object 2");
                carObject2.printDetails();
            }
        });

        t1.start(); // Start Thread t1
        t2.start(); // Start Thread t2
    }
}
