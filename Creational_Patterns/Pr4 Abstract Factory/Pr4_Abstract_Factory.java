import java.util.*;

// Abstract product interface
interface CarBrand {
    // Create an interface implemented by classes to print all brand details.
    public void carBrandDetails();
}

// Concrete product implementations
class Porsche implements CarBrand {
    // Sub class that implements "Car" interface and "carBrandDetails" method
    public void carBrandDetails() {
        // Print Details of the Car Brand.
        System.out.println("This is Porsche.");
        System.out.println("Founder: Ferdinand Porsche");
        System.out.println("Founded: 25 April 1931, Stuttgart, Germany");
    }
}

class Bugatti implements CarBrand {
    // Sub class that implements "Car" interface and "carBrandDetails" method
    public void carBrandDetails() {
        // Print Details of the Car Brand.
        System.out.println("This is Bugatti.");
        System.out.println("Founder: Ettore Bugatti");
        System.out.println("Founded: 1909, Molsheim, France");
    }
}

class Lamborghini implements CarBrand {
    // Sub class that implements "Car" interface and "carBrandDetails" method
    public void carBrandDetails() {
        // Print Details of the Car Brand.
        System.out.println("This is Lamborghini.");
        System.out.println("Founder: Ferruccio Lamborghini");
        System.out.println("Founded: May 1963, Sant'Agata Bolognese, Italy");
    }
}

interface CarEngineType {
    public void carEngineTypeDetails();
}

class Diesel implements CarEngineType {
    public void carEngineTypeDetails() {
        System.out.println("Diesel Based Engine Type");
    }
}

class Petrol implements CarEngineType {
    public void carEngineTypeDetails() {
        System.out.println("Petrol Based Engine Type");
    }
}

class Electric implements CarEngineType {
    public void carEngineTypeDetails() {
        System.out.println("Electric Based Engine Type");
    }
}

// Abstract Factory interface
interface AbstractFactory {
    CarBrand createBrand(); // Create method for creating car brand

    CarEngineType createEngine(); // Create method for creating car engine type
}

// Concrete Factory for Porsche
class PorscheFactory implements AbstractFactory {

    @Override
    public CarBrand createBrand() {
        return new Porsche(); // Create Porsche brand
    }

    @Override
    public CarEngineType createEngine() {
        return new Diesel(); // Create Diesel engine type
    }

}

// Concrete Factory for Bugatti
class BugattiFactory implements AbstractFactory {

    @Override
    public CarBrand createBrand() {
        return new Bugatti(); // Create Bugatti brand
    }

    @Override
    public CarEngineType createEngine() {
        return new Diesel(); // Create Diesel engine type
    }
}

// Concrete Factory for Lamborghini
class LamborghiniFactory implements AbstractFactory {

    @Override
    public CarBrand createBrand() {
        return new Lamborghini(); // Create Lamborghini brand
    }

    @Override
    public CarEngineType createEngine() {
        return new Diesel(); // Create Diesel engine type
    }
}

// Main Driver Class
public class Pr4_Abstract_Factory {

    // Main Method
    public static void main(String[] args) {
        // Create Scanner Object with Input stream
        Scanner sc = new Scanner(System.in);

        // Display Prompt to request User Input Data
        System.out.println("Enter the Car Brand Name:");

        // Input the user data using scanner object and "nextLine()" method and store in
        // the "input" string.
        String input = sc.nextLine();

        AbstractFactory carAbstractFactory; // Create Reference of the Abstract Factory

        // Switch case to create new factory object based on input
        switch (input.toLowerCase()) {
            case "porsche":
                carAbstractFactory = new PorscheFactory();
                break;
            case "bugatti":
                carAbstractFactory = new BugattiFactory();
                break;
            case "lamborghini":
                carAbstractFactory = new LamborghiniFactory();
                break;
            default:
                System.out.println("No Object Created! Class with brand name '" + input + "' doesn't exist!");
                sc.close();
                return;
        }

        // use the reference to call the create car method of the factory
        CarBrand Brand = carAbstractFactory.createBrand();
        CarEngineType Engine = carAbstractFactory.createEngine();
        Brand.carBrandDetails(); // Print the car brand details of the car.
        Engine.carEngineTypeDetails(); // Print the car brand details of the car.

        // Close the Scanner input stream to prevent data leaks.
        sc.close();
    }
}
