public class Base {
    protected static int i;
    public float f;

    public Base(int i, float f) {
        Base.i = i;
        this.f = f;
    }

    public void move() {
        move(10);
        move(10f);
    }

    public void move(int i) {
        Base.i += i;
        System.out.println("in int Base " + Base.i);
    }

    public void move(float f) {
        this.f += f;
        System.out.println("in float Base " + this.f);
    }
}
