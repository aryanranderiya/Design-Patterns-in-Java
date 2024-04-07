// Target Interface - Represents the interface expected by the client
interface Car {
    void refuel();
}

// Adaptees - Different types of cars with incompatible interfaces

class ElectricCar {
    public void chargeBattery() {
        System.out.println("Charging the electric car's battery");
    }
}

class GasolineCar {
    public void refillGasoline() {
        System.out.println("Refilling the gasoline car's tank");
    }
}

class HybridCar {
    public void refillGasoline() {
        System.out.println("Refilling the hybrid car's gasoline tank");
    }

    public void chargeBattery() {
        System.out.println("Charging the hybrid car's battery");
    }
}

// Adapters - Adapts the different types of cars to the Car interface

class ElectricCarAdapter implements Car {
    private ElectricCar electricCar;

    public ElectricCarAdapter(ElectricCar electricCar) {
        this.electricCar = electricCar;
    }

    @Override
    public void refuel() {
        electricCar.chargeBattery();
    }
}

class GasolineCarAdapter implements Car {
    private GasolineCar gasolineCar;

    public GasolineCarAdapter(GasolineCar gasolineCar) {
        this.gasolineCar = gasolineCar;
    }

    @Override
    public void refuel() {
        gasolineCar.refillGasoline();
    }
}

class HybridCarAdapter implements Car {
    private HybridCar hybridCar;

    public HybridCarAdapter(HybridCar hybridCar) {
        this.hybridCar = hybridCar;
    }

    @Override
    public void refuel() {
        hybridCar.refillGasoline();
        hybridCar.chargeBattery();
    }
}

// Client
public class Pr7_Adapter {
    public static void main(String[] args) {
        // Create instances of different types of cars
        ElectricCar electricCar = new ElectricCar();
        GasolineCar gasolineCar = new GasolineCar();
        HybridCar hybridCar = new HybridCar();

        // Create adapters for each type of car
        Car electricCarAdapter = new ElectricCarAdapter(electricCar);
        Car gasolineCarAdapter = new GasolineCarAdapter(gasolineCar);
        Car hybridCarAdapter = new HybridCarAdapter(hybridCar);

        // Now, the client can interact with the cars through the unified Car interface
        System.out.println("Refueling Electric Car:");
        electricCarAdapter.refuel();

        System.out.println("\nRefueling Gasoline Car:");
        gasolineCarAdapter.refuel();

        System.out.println("\nRefueling Hybrid Car:");
        hybridCarAdapter.refuel();
    }
}
