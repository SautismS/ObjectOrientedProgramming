package vehicle;

public class LuxuryCar extends Car{
    private String upholsteryType;
    public LuxuryCar(){
        this("no make", "no model", 0, "none");
    }
    public LuxuryCar(String make, String model, int year, String upholstery){
        super(make, model, year);
        this.upholsteryType = upholstery;
    }
    @Override
    public void accelerate() {
        speed += 10;
        System.out.println("Current speed is: " + speed);
    }

    @Override
    public void decelerate() {
        speed -= 10;
        System.out.println("Current speed is: " + speed);
    }

    public String toString(){
        return super.toString() + "Car type: Luxury " + " Car upholstery: " + upholsteryType + "\n";
    }
}
