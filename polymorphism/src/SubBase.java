public class SubBase extends Base {
    protected static int i;
    public float f;

    public SubBase(int i, float f) {
        super(i, f); // ------------(*)
        SubBase.i = i;
        this.f = f;
    }

    public void move() {
        move(5);
        move(5f);
    }

    public void move(int i) {
        SubBase.i += i;
        System.out.println("in float SubBase " + this.f);
    }
}
