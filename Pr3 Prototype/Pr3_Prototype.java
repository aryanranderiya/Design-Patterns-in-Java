package Pr3_Prototype;

interface CarPrototype {
    public Car shallowClone();

    public Car deepClone();
}

class CarConcretePrototype implements CarPrototype {

    public Car shallowClone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        // return new Car(null, null, 0, null);
    }

    public Car deepClone() {

        return new Car(null, null, 0, null);
        return (CarConcretePrototype) super.clone();

    }

}

public class Pr3_Prototype {

    public static void main(String[] args) {

    }
}