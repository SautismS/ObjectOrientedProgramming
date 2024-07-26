//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Examples {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        double a=10%3,b=10%-3,c=-10%3,d=-10%-3;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        boolean m=0.1+0.1==0.2;
        boolean n=0.1+0.1+0.1==0.3;
        System.out.println(m);
        System.out.println(n);

        double x=Math.abs(-2147483648);
        System.out.println(x);
    }
}