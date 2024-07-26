package vehicle;
public abstract class Car implements Comparable{
    String make;
    String model;
    int year;
    int miles;
    int speed;
    Car(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public void setCarMake(String make){
        this.make = make;
    }
    public String getCarMake(){
        return make;
    }
    public void setCarModel(String model){
        this.model = model;
    }
    public String getCarModel(){
        return model;
    }
    public void setCarYear(int year){
        this.year = year;
    }
    public int getCarYear(){
        return year;
    }
    public String toString(){
        return "Car make: " + make + " Car model: " + model + " Car year: " + year + "\n";
    }
    public void calculateMilesToEmpty(){
        miles = 0;
    }
    public void steer(){
        speed -= 1;
        System.out.println("adjust the steering wheel...");
    }
    public int compareTo(Object o){
        Car car = (Car) o;
        if(this.year < car.year)
            return -1;
        else if(this.year > car.year)
            return 1;
        return 0;
    }
    public abstract void accelerate();
    public abstract void decelerate();

}
