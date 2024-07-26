package vehicle;

public class CompactCar extends Car{
    public CompactCar(){
        super("no make", "no model", 0);
    }
    public CompactCar(String make, String model, int year){
        super(make, model, year);
    }
    @Override
    public void accelerate() {
        speed += 1;
        System.out.println("Current speed is: " + speed);
    }

    @Override
    public void decelerate() {
        speed -= 1;
        System.out.println("Current speed is: " + speed);
    }

    public String toString(){
        return super.toString() + "Car type: Compact \n";
    }
}
