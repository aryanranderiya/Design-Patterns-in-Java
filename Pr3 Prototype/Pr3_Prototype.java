
import java.util.ArrayList;
import java.util.List;

class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private int id;

    // Constructor to initialize the Car with required attributes
    public Car(int id, String brand, String model, int year, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public int getID() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    // The toString() method returns the String representation of the object.
    // The toString() method returns the String representation of the object.
    // In this implementation, the Java compiler internally invokes the toString()
    // method and prints the attributes of the car accordingly.

    public String toString() {
        return "\nCar{" +
                "id='" + id + '\'' +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                "}";
    }

}

class CarShop implements Cloneable {
    private String shopName;
    List<Car> carList = new ArrayList<>();

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public List<Car> getCarsList() {
        return carList;
    }

    public void setCarsList(List<Car> carList) {
        this.carList = carList;
    }

    public String toString() {
        return "CarShop{ Shop Name = " + shopName + ", " + "Cars = " + carList + " }";
    }

    public void createCar(int id, String brand, String model, int year, String color) {
        Car c = new Car(id, brand, model, year, color);
        getCarsList().add(c);
    }

    // Shallow Clone
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // protected CarShop clone() throws CloneNotSupportedException {
    // // CarShop cloned = (CarShop) super.clone();
    // // cloned.carList = new ArrayList<>(this.carList);
    // // return cloned;
    // CarShop obj = new CarShop();
    // for (Car car : carList) {

    // obj.getCarsList().add(car);
    // }
    // return obj;
    // }

    // Deep Clone
    public CarShop deepClone(CarShop shop) {
        CarShop obj = new CarShop();
        obj.carList = shop.carList;
        return obj;
    }

}

public class Pr3_Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        CarShop car_shop1 = new CarShop();
        car_shop1.setShopName("Car Shop 1");
        car_shop1.createCar(1, "brandA", "modelA", 2023, "Black");
        car_shop1.createCar(2, "brandB", "modelB", 2023, "Black");

        // Shallow cloning. Modified Results will not be reflected in book shop 2
        System.out.println("---------------------- Shallow Clone ---------------------- ");
        CarShop car_shop2 = (CarShop) car_shop1.clone();
        car_shop2.setShopName("Car Shop 2");
        System.out.println(car_shop1);
        System.out.println(car_shop2);

        // Deep Clone. Modified Results will all be reflected.
        System.out.println("---------------------- Deep Clone ---------------------- ");
        System.out.println("---------------------- Before Removing ---------------------- ");
        System.out.println(car_shop1);

        CarShop car_shop3 = car_shop1.deepClone(car_shop1);
        car_shop1.getCarsList().remove(0);
        car_shop3.setShopName("Car Shop 3");
        
        System.out.println("---------------------- After Removing ---------------------- ");
        System.out.println(car_shop1);
        System.out.println(car_shop3);
    }
}