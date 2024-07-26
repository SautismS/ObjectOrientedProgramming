import java.util.Scanner;

public class DateUtil {

    // 判断给定年份是否是闰年
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 判断给定的年月日是否构成一个有效日期
    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        if (day > 28 && month == 2) {
            return isLeapYear(year) ? day == 29 : false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }
        return true;
    }

    // 获取给定日期的星期几
    public static int getDayOfWeek(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid date.");
        }

        // 1. 根据年份获取对应的"century"值
        int century = 0;
        int firstTwoDigits = year / 100;
        if (firstTwoDigits >= 17 && firstTwoDigits <= 24) {
            int[] centuryTable = {4, 2, 0, 6, 4, 2, 0, 6};
            century = centuryTable[firstTwoDigits - 17]; // 表中对应的索引
        } else {
            throw new IllegalArgumentException("Year out of range (1700-2499).");
        }

        // 2. 加上年份的后两位数字
        int lastTwoDigits = year % 100;

        // 3. 加上"the last two digit of the year divide by 4, truncate the fractional part"
        int lastTwoDigitsDividedByFour = lastTwoDigits / 4;

        // 4. 根据月份表获取对应的月份值
        int monthValue = 0;
        if (!isLeapYear(year)) {
            int[] nonLeapMonthTable = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
            monthValue = nonLeapMonthTable[month - 1]; // 表中对应的索引
        } else {
            int[] leapMonthTable = {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};// 表中对应的索引
            monthValue = leapMonthTable[month - 1];
        }

        // 5. 加上日期
        int sum = century + lastTwoDigits + lastTwoDigitsDividedByFour + monthValue + day;

        // 6. 对7取模得到星期几（0为SUN，1为MON，...，6为SAT）
        int dayOfWeek = sum % 7;
        return dayOfWeek;
    }

    // 打印指定年月的日历
    public static void printCalendar(int year, int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month.");
        }
        System.out.println("SUN MON TUE WED THU FRI SAT");
        int dayOfWeek = getDayOfWeek(year, month, 1);
        int countSpaces = dayOfWeek * 4; // 每个星期占据四个字符（包括空格）
        for (int i = 0; i < countSpaces; i++) {
            System.out.print(" "); // 输出对应数量的空格
        }
        int daysInMonth = 31;
        if (month == 2) {
            daysInMonth = isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            daysInMonth = 30;
        }
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d", day);
            dayOfWeek++;
            if (dayOfWeek % 7 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // 打印指定年的整个日历
    public static void printCalendar(int year) {
        for (int month = 1; month <= 12; month++) {
            System.out.println("\n" + getMonthName(month) + " " + year);
            printCalendar(year, month);
        }
    }

    // 格式化给定日期的输出
    public static String formatDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid date.");
        }
        String[] weekdays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int dayOfWeek = getDayOfWeek(year, month, day);
        String monthName = getMonthName(month);
        return weekdays[dayOfWeek] + " " + day + " " + monthName + " " + year;
    }

    // 辅助方法，获取月份的英文名称
    private static String getMonthName(int month) {
        String[] monthNames = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month.");
        }
        return monthNames[month];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份、月份、日期：");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        String[] weekdays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        System.out.println(year + "年是闰年吗？" + isLeapYear(year));
        System.out.println(year + "年" + month + "月" + day + "日是否有效？" + isValidDate(year, month, day));
        System.out.println(year + "年" + month + "月" + day + "日是星期几？" + weekdays[getDayOfWeek(year,month,day)]);
        System.out.println("格式化后的日期：" + formatDate(year, month, day));

        System.out.println("\n打印" + year + "年" + month + "月的日历：");
        printCalendar(year, month);

        System.out.println("\n打印" + year + "年的整个日历：");
        printCalendar(year);
    }
}
