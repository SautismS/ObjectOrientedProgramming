public class TestComplex {
    public static void runTests() {
        // Create complex numbers for testing
        Complex c1 = new Complex(1.1, 2.2);
        Complex c2 = new Complex(3.3, 4.4);

        // Test all methods
        System.out.println("c1: " + c1);
        System.out.println("c1 isReal: " + c1.isReal());
        System.out.println("c1 isImaginary: " + c1.isImaginary());
        System.out.println("c1 equals 1.1 + 2.2i: " + c1.equals(1.1, 2.2));
        System.out.println("c1 equals c2: " + c1.equals(c2));
        System.out.println("c1 abs: " + c1.abs());
        System.out.println("c1 + c2: " + c1.add(c2));
        System.out.println("c1 - c2: " + c1.subtract(c2));
        System.out.println("c1 * c2: " + c1.multiply(c2));
        System.out.println("c1 / c2: " + c1.divide(c2));
    }
}
