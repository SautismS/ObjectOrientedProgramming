package vehicle;

public class SportsCar extends Car{
    private String upholsteryType;
    private int tireSize;
    public SportsCar(){
        this("no make", "no model", 0, "none", 28);
    }
    public SportsCar(String make, String model, int year, String upholsteryType, int tireSize){
        super(make, model, year);
        this.upholsteryType = upholsteryType;
        this.tireSize = tireSize;
    }
    @Override
    public void accelerate() {
        speed += 20;
        System.out.println("Current speed is: " + speed);
    }

    @Override
    public void decelerate() {
        speed -= 20;
        System.out.println("Current speed is: " + speed);
    }

    public String toString(){
        return super.toString() + "Car type: Sports " + " Car upholstery: " + upholsteryType +
                "car tireSize: " + tireSize + "\n";
    }
}
