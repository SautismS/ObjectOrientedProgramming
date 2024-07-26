public class Primitives {

    public static void main(String[] args) {
        IntTest();
        FloatTest();
        compareFloat();
    }

    public static void IntTest() {
        int i = 1000000;
        System.out.println(i * i);
        long l = i;
        System.out.println(l * l);
    }

    public strictfp static void FloatTest() {
        // An example of overflow:
        double d = 1e308;
        System.out.print("overflow produces infinity: ");
        System.out.println(d + " * 10 == " + d * 10);

        // An example of gradual underflow:
        d = 1e-316 * Math.PI;
        System.out.print("gradual underflow:(denormalized value) " + d);
        for (int i = 0; i < 4; i++)
            System.out.print(" " + (d /= 100));
        System.out.print(" " + (d *= 100));
        System.out.println();

        d = -1e-317 * Math.PI;
        System.out.print("gradual underflow:(a signed zero) " + d);
        for (int i = 0; i < 4; i++)
            System.out.print(" " + (d /= 100));
        System.out.println();

        // An example of NaN:
        System.out.print("0.0/0.0 is Not-a-Number: ");
        d = 0.0 / 0.0;
        System.out.println(d);
        System.out.println("All numberic operations with NaN as an operand produce NaN as a result:" + (d + 10.23));
        System.out.println("The operator == returns false if either oprand is NaN:" + (d == Double.NaN));
        System.out.println("The operator != returns true if either oprand is NaN:" + (d != Double.MIN_NORMAL));
        System.out.println("In particular, x != x is true if and only if x is NaN:" + (d != Double.NaN));

        // An example of infinity
        d = 1.0 / 0.0;
        System.out.println(d);

        // An example of inexact results and rounding:
        System.out.print("inexact results with float:");
        for (int i = 0; i < 100; i++) {
            float z = 1.0f / i;
            if (z * i != 1.0f)
                System.out.print(" " + i);
        }
        System.out.println();

        // Another example of inexact results and rounding:
        System.out.print("inexact results with double:");
        for (int i = 0; i < 100; i++) {
            double z = 1.0 / i;
            if (z * i != 1.0)
                System.out.print(" " + i);
        }
        System.out.println();

        // An example of cast to integer rounding:
        System.out.print("cast to int rounds toward 0: ");
        d = 12345.6;
        System.out.println((int) d + " " + (int) (-d));
    }

    public static void compareFloat() {
        double[] doubles = { 1.0, 1.0001, 1.0000001, 1.0000000001, 1.0000000000001 };
        double[] deltas = { 0.01, 0.00001, 0.0000001, 0.0000000001, 0 };

        // loop through all of the deltas initialized above
        for (int j = 0; j < deltas.length; j++) {
            double delta = deltas[j];
            System.out.println("delta: " + delta);

            // loop through all of the doubles initialized above
            for (int i = 0; i < doubles.length - 1; i++) {
                double d1 = doubles[i];
                double d2 = doubles[i + 1];
                boolean result = deltaCompare(d1, d2, delta);
                System.out.println(" " + d1 + " == " + d2 + " ? " + result);
            }
            System.out.println();
        }
    }

    private static boolean deltaCompare(double d1, double d2, double delta) {
        return Math.abs(d1 - d2) < delta;
    }

}