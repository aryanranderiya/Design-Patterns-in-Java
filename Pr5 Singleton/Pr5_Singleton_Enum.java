// Enum representing a singleton Car instance
enum Car {
    INSTANCE; // The single instance of the Car enum

    int id; // Variable to store the ID of the car

    // Getter method to retrieve the ID of the car
    public int getInstance() {
        return id;
    }

    // Setter method to set the ID of the car
    public void setInstance(int id) {
        this.id = id;
    }
}

// Main class to demonstrate the singleton enum pattern
public class Pr5_Singleton_Enum {

    public static void main(String[] args) {

        // Setting and displaying the first instance of the Car
        System.out.println("\nSetting Instance 1: ");
        Car carObject1 = Car.INSTANCE;
        carObject1.setInstance(1);
        System.out.println("Instance is 1: " + carObject1.getInstance());

        // Setting and displaying the second instance of the Car
        System.out.println("\nSetting Instance 2: ");
        Car carObject2 = Car.INSTANCE;
        carObject2.setInstance(2);
        System.out.println("Instance is 2: " + carObject2.getInstance());

        // Checking if both objects refer to the same instance
        if (carObject1 == carObject2)
            System.out.println("\nObjects are of the same instance");

    }
}
