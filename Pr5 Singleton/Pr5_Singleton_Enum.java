
enum Car {
    INSTANCE;

    int id;

    public int getInstance() {
        return id;
    }

    public void setInstance(int id) {
        this.id = id;
    }

}

public class Pr5_Singleton_Enum {

    public static void main(String[] args) {

        System.out.println("\nSetting Instance 1: ");
        Car carObject1 = Car.INSTANCE;
        carObject1.setInstance(1);
        System.out.println("Instance is 1: " + carObject1.getInstance());

        System.out.println("\nSetting Instance 2: ");
        Car carObject2 = Car.INSTANCE;
        carObject2.setInstance(2);
        System.out.println("Instance is 2: " + carObject2.getInstance());

        if (carObject1 == carObject2)
            System.out.println("\nObjects are of the same instance");

    }

}
