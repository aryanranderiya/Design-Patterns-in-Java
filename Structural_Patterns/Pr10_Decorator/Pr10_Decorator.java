// Car interface
interface Car {
    String getDescription();

    double getCost();
}

// Concrete component - BasicCar
class BasicCar implements Car {
    @Override
    public String getDescription() {
        return "Basic Car";
    }

    @Override
    public double getCost() {
        return 20000;
    }
}

// Decorator - CarDecorator
abstract class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }
}

// Concrete Decorator - AlloyWheels
class AlloyWheels extends CarDecorator {
    public AlloyWheels(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Alloy Wheels";
    }

    @Override
    public double getCost() {
        return car.getCost() + 1000;
    }
}

// Concrete Decorator - LeatherSeats
class LeatherSeats extends CarDecorator {
    public LeatherSeats(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Leather Seats";
    }

    @Override
    public double getCost() {
        return car.getCost() + 2000;
    }
}

// Client code
public class Pr10_Decorator {
    public static void main(String[] args) {
        // Creating a basic car
        Car myCar = new BasicCar();
        System.out.println("Description: " + myCar.getDescription());
        System.out.println("Cost: " + myCar.getCost());

        // Adding alloy wheels
        Car myCarWithAlloyWheels = new AlloyWheels(myCar);
        System.out.println("Description: " + myCarWithAlloyWheels.getDescription());
        System.out.println("Cost: " + myCarWithAlloyWheels.getCost());

        // Adding leather seats
        Car myCarWithLeatherSeats = new LeatherSeats(myCarWithAlloyWheels);
        System.out.println("Description: " + myCarWithLeatherSeats.getDescription());
        System.out.println("Cost: " + myCarWithLeatherSeats.getCost());
    }
}
