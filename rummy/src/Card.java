// Card 类表示一张纸牌
class Card {
    private static final String[] SUITS = {"♠", "♥", "♣","♦"}; // 定义牌的花色
    private static final String[] VALUES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"}; // 定义牌的点数

    private final String suit; // 纸牌的花色
    private final String value; // 纸牌的点数

    // Card 类的构造函数
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    // 获取纸牌的花色
    public String getSuit() {
        return suit;
    }

    // 获取纸牌的点数
    public String getValue() {
        return value;
    }

    // 重写 toString 方法，用于打印纸牌信息
    public String toString() {
        return suit + value;
    }
}
