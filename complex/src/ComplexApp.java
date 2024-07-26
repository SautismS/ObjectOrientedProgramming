import java.util.Scanner;

public class ComplexApp {
    public static void run(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter complex number 1 (real and imaginary part): ");
        double real1 = sc.nextDouble();
        double imag1 = sc.nextDouble();
        Complex c1 = new Complex(real1, imag1);

        System.out.print("Enter complex number 2 (real and imaginary part): ");
        double real2 = sc.nextDouble();
        double imag2 = sc.nextDouble();
        Complex c2 = new Complex(real2, imag2);

        System.out.println("Number 1 is: " + c1);
        System.out.println(c1 + " is" + (c1.isReal() ? "" : " NOT") + " a pure real number");
        System.out.println(c1 + " is" + (c1.isImaginary() ? "" : " NOT") + " a pure imaginary number");
        System.out.println("Number 2 is: " + c2);
        System.out.println(c2 + " is" + (c2.isReal() ? "" : " NOT") + " a pure real number");
        System.out.println(c2 + " is" + (c2.isImaginary() ? "" : " NOT") + " a pure imaginary number");

        System.out.println(c1 + " is" + (c1.equals(c2) ? "" : " NOT") + " equal to " + c2);
        System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));

        sc.close();
    }
}
