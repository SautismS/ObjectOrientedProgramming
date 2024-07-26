public class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public Complex(){
        this(0.0, 0.0);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public String toString(){
        return "(" + real + " + " + imag + "i" + ")";
    }

    public  boolean isReal(){
        return imag == 0.0;
    }

    public  boolean isImaginary(){
        return real == 0.0;
    }

    public boolean equals(double real, double imag){
        final double EPISLON = 1e-8;
        return Math.abs(this.real - real) <= EPISLON && Math.abs(this.imag - imag) <= EPISLON;
    }

    public boolean equals(Complex another){
        return equals(another.real, another.imag);
    }

    public double abs(){
        return Math.sqrt(real * real + imag * imag);
    }

    public Complex add(Complex right){
        return new Complex(this.real + right.real, this.imag + right.imag);
    }

    public Complex subtract(Complex right) {
        return new Complex(this.real - right.real, this.imag - right.imag);
    }

    public Complex multiply(Complex right) {
        double newReal = this.real * right.real - this.imag * right.imag;
        double newImag = this.real * right.imag + this.imag * right.real;
        return new Complex(newReal, newImag);
    }

    public Complex divide(Complex right) {
        double divisor = right.real * right.real + right.imag * right.imag;
        double newReal = (this.real * right.real + this.imag * right.imag) / divisor;
        double newImag = (this.imag * right.real - this.real * right.imag) / divisor;
        return new Complex(newReal, newImag);
    }

    public static void main(String[] args){
        // Test the Complex class
        TestComplex.runTests();

        System.out.print("\n");

        // Use the Complex class in a simple client application
        ComplexApp.run();
    }
}
