import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
public class FileInput {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("data.txt"));
        double number = 0;
        double sum = 0;
        while (sc.hasNextDouble()) {
            number = sc.nextDouble();
            sum += number;
        }
        System.out.println("The sum is : " + sum);
    }
}