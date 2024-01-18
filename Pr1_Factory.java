import java.util.*;

/*
! The Factory Design Pattern is a creational pattern that provides an interface
for creating instances of a class, allowing subclasses to alter the type of objects
that will be instantiated. It promotes code flexibility and separation of
concerns by delegating the responsibility of object creation to dedicated factory classes.
*/

interface Car {
    // Create an interface implemented by classes to print all brand details.
    public void carBrandDetails();
}

class Porsche implements Car {
    // Sub class that implements "Car" interface and "carBrandDetails" method
    public void carBrandDetails() {
        // Print Details of the Car Brand.
        System.out.println("This is Porsche.");
        System.out.println("Founder: Ferdinand Porsche");
        System.out.println("Founded: 25 April 1931, Stuttgart, Germany");
    }
}

class Bugatti implements Car {
    // Sub class that implements "Car" interface and "carBrandDetails" method
    public void carBrandDetails() {
        // Print Details of the Car Brand.
        System.out.println("This is Bugatti.");
        System.out.println("Founder: Ettore Bugatti");
        System.out.println("Founded: 1909, Molsheim, France");
    }
}

class Lamborghini implements Car {
    // Sub class that implements "Car" interface and "carBrandDetails" method
    public void carBrandDetails() {
        // Print Details of the Car Brand.
        System.out.println("This is Lamborghini.");
        System.out.println("Founder: Ferruccio Lamborghini");
        System.out.println("Founded: May 1963, Sant'Agata Bolognese, Italy");
    }
}

// Car Factory is used to create the car based on the valid user input.
class CarFactory {
    /*
     * Factory class that returns new instance of respective classes.
     * Type of the Car object is based on the user input string.
     */
    public Car createCar(String carBrand) {
        // If no user input is found. Null return type is handled in main method..
        if (carBrand == null || carBrand.isEmpty()) {
            return null;
        }
        // If user input is "Porsche" then return new object of "Porsche" class
        else if (carBrand.equalsIgnoreCase("Porsche")) {
            return new Porsche();
        }
        // If user input is "Bugatti" then return new object of "Bugatti" class
        else if (carBrand.equalsIgnoreCase("Bugatti")) {
            return new Bugatti();
        }
        // If user input is "Lamborghini" then return new object of "Lamborghini" class
        else if (carBrand.equalsIgnoreCase("Lamborghini")) {
            return new Lamborghini();
        }
        return null;
    }
}

// Main Driver Class
public class Pr1_Factory {

    // Main Method
    public static void main(String[] args) {
        // Create Scanner Object with Input stream
        Scanner sc = new Scanner(System.in);

        // Display Prompt to request User Input Data
        System.out.println("Enter the Car Brand Name:");

        // Input the user data using scanner object and "nextLine()" method and store in
        // the "input" string.
        String input = sc.nextLine();

        CarFactory carFactory = new CarFactory(); // Create Object of CarFactory Class.

        // invoke the "createCar()" method with the user input string as a parameter.
        // Store the returned object in the "object" variable of type "Car" (class).
        Car object = carFactory.createCar(input);

        // If the user input does not match any car brands it will return null.
        // In this case, print an error prompt that this class does not exist.
        if (object == null) {
            System.out.println("No Object Created! Class with brand name '" + input + "' doesn't exist!");
        }
        // Display the Car Brand Details if the user input matches the brand classes.
        else {
            object.carBrandDetails();
        }

        // Close the Scanner input stream to prevent data leaks.
        sc.close();
    }
}