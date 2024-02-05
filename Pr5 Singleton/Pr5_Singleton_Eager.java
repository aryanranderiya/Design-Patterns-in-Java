import java.util.Scanner;

class Car {
    private String model, color, brand;
    private int year;

    // Early, instance will be created at load time
    private static Car carObject = new Car();

    private Car() {
        this.brand = "Porsche";
        this.model = "911";
        this.year = 2024;
        this.color = "Black";
        System.out.println("Constructor Called");
    }

    public static Car getInstance() {
        return carObject;
    }

    public void printDetails() {
        System.out.println("Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                "}");
    }

}

public class Pr5_Singleton_Eager {

    public static void main(String[] args) {

        // System.out.println("\nSetting Instance 1: ");
        // Car.setInstance();

        // System.out.println("\nSetting Instance 2: ");
        // Car.setInstance();

        Car carObject1 = Car.getInstance();
        System.out.println("Details of Car Object 1");
        carObject1.printDetails();

        Car carObject2 = Car.getInstance();
        System.out.println("Details of Car Object 2");
        carObject2.printDetails();

        if (carObject1 == carObject2) {
            System.out.println("Both objects are the same instance.");
        }

    }

}
