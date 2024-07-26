import java.util.Scanner;

public class HillPattern {

    public static void main(String[] args) {
        // 检查命令行参数是否正确
        if (args.length != 1) {
            System.out.println("Usage: java HillPattern [a|b|c|d]");
            return;
        }

        char patternType = args[0].charAt(0); // 获取图形模式
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象用于获取键盘输入

        System.out.print("Enter the rows：");
        int size = scanner.nextInt(); // 从键盘读取图形大小

        // 根据不同的图形模式，调用相应的绘制方法
        switch (patternType) {
            case 'a':
                drawUpTriangle(size);
                break;
            case 'b':
                drawDownTriangle(size);
                break;
            case 'c':
                drawDiamond(size);
                break;
            case 'd':
                drawSquareWithHole(size);
                break;
            default:
                System.out.println("未知的图形模式，请输入'a'、'b'、'c'或'd'！");
        }

        scanner.close(); // 关闭Scanner资源
    }

    // 绘制上三角形
    private static void drawUpTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j < 2 * (size - i + 1); j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    // 绘制下三角形
    private static void drawDownTriangle(int size) {
        for (int i = size; i >= 1; i--) {
            for (int j = 1; j < 2 * (size - i + 1); j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    // 绘制菱形
    private static void drawDiamond(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j < 2 * (size - i + 1); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("# ");
            }
            System.out.println();
        }
        for (int i = size - 1; i >= 1; i--) {
            System.out.print("  ");
            for (int j = 1; j < 2 * (size - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    // 绘制中间挖去一个菱形的正方形
    private static void drawSquareWithHole(int size) {
        for (int n = 1; n <= (2 * size - 1); n++) {
            System.out.print("# ");
        }
        System.out.println();
        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= (size - i); j++) {
                System.out.print("# ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (size - i); j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j <= (i + 1); j++) {
                System.out.print("# ");
            }
            for (int k = 1; k <= (2 * (size - i - 1) - 1); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (i + 1); j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
        for (int n = 1; n <= (2 * size - 1); n++) {
            System.out.print("# ");
        }
    }
}