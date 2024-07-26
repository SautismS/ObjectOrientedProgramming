import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number = 0;
        double sum = 0;
        while(sc.hasNextDouble()){
                number = sc.nextDouble();
                sum += number;
        }
        System.out.println("The sum is : " + sum);
    }
}
