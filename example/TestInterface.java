package client;

import vehicle.*;


public class TestInterface {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new CompactCar("尼桑", "Murano", 2004);
        cars[1] = new SportsCar("北京现代", "N-Line", 2021, "现代风格", 30);
        cars[2] = new LuxuryCar("雷克萨斯", "NX 400", 2020, "巴洛克风格");
        cars[3] = new CompactCar("比亚迪", "唐",2019);
        cars[4] = new SportsCar("奥迪","Q5L",2015,"简约风格",28);
        for(Car auto : cars) {
            System.out.print(auto);
            System.out.println("========================================================");
        }
        bubbleSort(cars);
        System.out.println("\n------------------------ To sort cars by year ------------------------\n");
        for(Car auto : cars) {
            System.out.print(auto);
            System.out.println("========================================================");
        }
    }

    public static void bubbleSort(int[] data){
        int length = data.length;
        for (int i = 0; i < length - 1; i++)
            for (int j = length - 1; j > i; j--){
                if (data[j] < data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
    }

    public static void bubbleSort(Car[] cars){
        int length = cars.length;
        Car temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (cars[j].getCarYear() < cars[j - 1].getCarYear()) {
                    temp = cars[j];
                    cars[j] = cars[j - 1];
                    cars[j - 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(Comparable[] compares) {
        System.out.println("bubbleSort(Comparable[])");
        int length = compares.length;
        Comparable temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (compares[j].compareTo(compares[j-1]) < 0) {
                    temp = compares[j];
                    compares[j] = compares[j - 1];
                    compares[j - 1] = temp;
                }
            }
        }
    }
}