import java.util.Arrays;
import java.util.Random;

public class Histogram {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("请提供一个整数作为参数 n");
            return;
        }

        int n = Integer.parseInt(args[0]);
        if (n <= 0) {
            System.out.println("参数 n 必须为正整数");
            return;
        }

        int[] data = generateRandomData(n);
        int[] histogram = generateHistogram(data);

        System.out.println("水平直方图：");
        displayHorizontalHistogram(histogram);
        System.out.println("\n垂直直方图：");
        displayVerticalHistogram(histogram);

    }

    // 生成 n 个随机数，范围在 [0, 100] 之间
    private static int[] generateRandomData(int n) {
        Random random = new Random();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(101);
        }
        return data;
    }

    // 生成直方图，统计 11 个区间的数据个数（0-9, 10-19, ..., 90-100）
    private static int[] generateHistogram(int[] data) {
        int[] histogram = new int[11];
        for (int num : data) {
            histogram[num / 10]++;
        }
        return histogram;
    }

    // 显示水平直方图
    private static void displayHorizontalHistogram(int[] histogram) {
        for (int i = 0; i < histogram.length - 1; i++) {
            int lowerBound = i * 10;
            int upperBound = (i + 1) * 10 - 1;
            System.out.print(String.format("%2d - %2d：", lowerBound, upperBound));
            for (int j = 0; j < histogram[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 显示垂直直方图
    private static void displayVerticalHistogram(int[] histogram) {
        int maxCount = Arrays.stream(histogram).max().orElse(0);
        for (int level = maxCount; level > 0; level--) {
            for (int count : histogram) {
                if (count >= level) {
                    System.out.print("   *  ");
                } else {
                    System.out.print("      ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < histogram.length - 1; i++) {
            int lowerBound = i * 10;
            int upperBound = (i + 1) * 10 - 1;
            System.out.print(String.format("%2d-%2d ", lowerBound, upperBound));
        }
        System.out.println();
    }
}
