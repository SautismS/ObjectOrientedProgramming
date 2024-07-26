import java.util.Scanner;

public class RunLengthEncoding {
    // 编码函数，对输入字符串进行Run-length编码
    public static String encode(String input) {
        StringBuilder encoded = new StringBuilder();
        int count = 1;
        char currentChar = input.charAt(0);

        // 遍历输入字符串，查找连续相同的字符
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++; // 相同字符计数增加
            } else {
                // 当遇到不同字符时，将当前字符及其计数添加到编码结果中
                encoded.append(count).append(currentChar);
                currentChar = input.charAt(i);
                count = 1;
            }
        }
        // 添加最后一个run到编码结果中
        encoded.append(count).append(currentChar);

        return encoded.toString();
    }

    // 解码函数，对已编码的字符串进行解码
    public static String decode(String input) {
        StringBuilder decoded = new StringBuilder();
        int i = 0;

        // 遍历编码后的字符串
        while (i < input.length()) {
            // 如果当前字符是数字，则开始解析连续字符的数量
            if (Character.isDigit(input.charAt(i))) {
                int count = 0;
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    count = count * 10 + (input.charAt(i) - '0'); // 计算连续字符的数量
                    i++;
                }
                char character = input.charAt(i++); // 获取要重复的字符
                // 根据计数复制字符到解码后的字符串
                for (int j = 0; j < count; j++) {
                    decoded.append(character);
                }
            } else { // 若当前字符不是数字，则直接添加到解码后的字符串
                decoded.append(input.charAt(i++));
            }
        }

        return decoded.toString();
    }

    // 测试主方法
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入原码：");
        String sourceCode = sc1.nextLine();
        String encodedString = encode(sourceCode);
        System.out.println("编码后的字符串: " + encodedString);
        System.out.println("请输入压缩码：");
        String compressedCode = sc2.nextLine();
        String decodedString = decode(compressedCode);
        System.out.println("解码后的字符串: " + decodedString);
    }
}