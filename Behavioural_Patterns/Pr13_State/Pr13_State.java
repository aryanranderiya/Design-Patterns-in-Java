// State interface
interface DrivingMode {
    void accelerate();

    void brake();
}

// Concrete State classes
class EcoMode implements DrivingMode {
    @Override
    public void accelerate() {
        System.out.println("Driving smoothly in Eco Mode");
    }

    @Override
    public void brake() {
        System.out.println("Braking gently in Eco Mode");
    }
}

class SportMode implements DrivingMode {
    @Override
    public void accelerate() {
        System.out.println("Driving aggressively in Sport Mode");
    }

    @Override
    public void brake() {
        System.out.println("Braking sharply in Sport Mode");
    }
}

class NormalMode implements DrivingMode {
    @Override
    public void accelerate() {
        System.out.println("Driving steadily in Normal Mode");
    }

    @Override
    public void brake() {
        System.out.println("Braking normally in Normal Mode");
    }
}

// Context class
class Car {
    private DrivingMode currentMode;

    public Car(DrivingMode mode) {
        this.currentMode = mode;
    }

    public void setDrivingMode(DrivingMode mode) {
        System.out.println("Switching to " + mode.getClass().getSimpleName());
        this.currentMode = mode;
    }

    public void accelerate() {
        currentMode.accelerate();
    }

    public void brake() {
        currentMode.brake();
    }
}

// Client code
public class Pr13_State {
    public static void main(String[] args) {
        Car car = new Car(new NormalMode());

        car.accelerate();
        car.brake();

        car.setDrivingMode(new EcoMode());
        car.accelerate();
        car.brake();

        car.setDrivingMode(new SportMode());
        car.accelerate();
        car.brake();
    }
}
