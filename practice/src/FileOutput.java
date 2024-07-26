import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutput {
    public static void main(String[] args) throws FileNotFoundException {
        int year = 2024;
        String name = "软件23字头的学生们";
        PrintWriter pw = new PrintWriter("output.txt");
        pw.println(name + ", Welcome to Java" + " in " + year + ".");
        pw.printf("%s, Welcome to Java in %4d.", name, year);
        pw.close();
    }
}
