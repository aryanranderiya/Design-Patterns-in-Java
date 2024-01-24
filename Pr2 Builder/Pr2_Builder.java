
/*
Builder pattern aims to “Separate the construction of a complex object from its representation so that the same construction process can create different representations.” It is used to construct a complex object step by step and the final step will return the object. The process of constructing an object should be generic so that it can be used to create different representations of the same object.
*/

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

// The builder class responsible for constructing a Car
class CarBuilder {

    // Temporary variables to store Car attributes during the building process
    private String brand;
    private String model;
    private int year;
    private String color;

    // Builder method for setting the brand attribute
    public CarBuilder buildBrand(String brand) {
        this.brand = brand;
        return this;
    }

    // Builder method for setting the model attribute
    public CarBuilder buildModel(String model) {
        this.model = model;
        return this;
    }

    // Builder method for setting the year attribute
    public CarBuilder buildYear(int year) {
        this.year = year;
        return this;
    }

    // Builder method for setting the color attribute
    public CarBuilder buildColor(String color) {
        this.color = color;
        return this;
    }

    // Final build method that constructs and returns the Car with specified
    // attributes
    public Car getCar() {
        return new Car(brand, model, year, color);
    }
}

// Main Driver Class
public class Pr2_Builder {

    // Main Method
    public static void main(String[] args) {

        Car porsche = new CarBuilder().buildBrand("Porsche").buildColor("Matte Black").buildModel("911")
                .buildYear(1963).getCar();
        Car pagani = new CarBuilder().buildBrand("Pagani").buildColor("White").buildModel("Huayra")
                .buildYear(2011).getCar();

        System.out.print(porsche);
        System.out.print(pagani);
        System.out.println();
    }
}