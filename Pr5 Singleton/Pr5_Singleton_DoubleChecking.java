
class Car {
    private String model, color, brand;
    private int year;

    // Early, instance will be created at load time
    private static Car carObject = null;

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

    public static void setInstance() {
        if (carObject == null) {
            synchronized (Car.class) {
                if (carObject == null) {
                    carObject = new Car();
                    System.out.println("Car Instance successfully set");
                }
            }
        } else
            System.out.println("Car Instance Already Exists!! You can access it using 'getInstance()' method.\n");
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

public class Pr5_Singleton_DoubleChecking {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("\nSetting Instance 1: ");
                Car.setInstance();
                Car carObject1 = Car.getInstance();
                System.out.println("Details of Car Object 1");
                carObject1.printDetails();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {

                System.out.println("\nSetting Instance 2: ");
                Car.setInstance();
                Car carObject2 = Car.getInstance();
                System.out.println("Details of Car Object 2");
                carObject2.printDetails();
            }
        });

        t1.start();
        t2.start();
    }

}
