import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MaxSubsequenceProduct {
    public static void main(String[] args) throws IOException {
        // 读取数据
        File file = new File("data.txt"); // 数据存储在 data.txt 文件中
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line.trim()); // 移除每行首尾的空白字符，包括换行符
        }
        String sequence = sb.toString(); // 获取整个数字序列字符串
        br.close();

        int maxLength = sequence.length(); // 数字序列字符串的最大长度
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入子序列的指定长度n（1<=n<=maxLength-1）：");
        int n = scan.nextInt();

        long maxProduct = 0; // 最大乘积值
        for (int i = 0; i <= maxLength - n; i++) {
            long product = 1; // 当前子序列的乘积
            for (int j = i; j < i + n; j++) {
                int digit = Character.getNumericValue(sequence.charAt(j));
                product *= digit; // 计算乘积
            }
            maxProduct = Math.max(maxProduct, product); // 更新最大乘积值
        }

        System.out.println("长度为 " + n + " 的最大子序列乘积值为 " + maxProduct);
    }
}
