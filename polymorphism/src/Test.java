public class Test {
    public static void main(String[] args) {
        Base[] bases = {new Base(0, 0), new SubBase(0, 0), new Base(1, 2)};
        bases[0].move();
        bases[1].move();
        bases[2].move();
        SubBase sub = (SubBase) bases[1];
        System.out.println("i = " + bases[1].i + " f = " + bases[1].f);
        System.out.println("i = " + sub.i + " f = " + sub.f);
        
        String n = 2 + (3+"1") + (5+6) + 3*4;
        System.out.println(n);
    }
}
