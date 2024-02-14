package Pr3_Prototype;

class Car {
    private String brand;
    private String model;
    private int year;
    private String color;

    // Constructor to initialize the Car with required attributes
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // The toString() method returns the String representation of the object.
    // The toString() method returns the String representation of the object.
    // In this implementation, the Java compiler internally invokes the toString()
    // method and prints the attributes of the car accordingly.

    public String toString() {
        return "\nCar{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                "}\n";
    }

}
