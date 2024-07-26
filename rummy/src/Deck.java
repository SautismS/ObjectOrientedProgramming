import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Deck 类表示一副纸牌
class Deck {
    private final List<Card> cards; // 存储纸牌的列表
    private final String[] suits = {"♠", "♥", "♣", "♦"}; // 定义牌的花色-
    private final String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"}; // 定义牌的点数

    // Deck 类的构造函数，用于创建一副包含 52 张牌的完整纸牌堆，并进行随机排列
    public Deck() {
        cards = new ArrayList<>(); // 初始化牌堆列表
        initializeDeck(); // 初始化牌堆
        shuffle(); // 洗牌
    }

    // 初始化纸牌堆，添加所有的纸牌
    private void initializeDeck() {
        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value)); // 添加每张纸牌到牌堆中
            }
        }
    }

    // 洗牌，打乱纸牌顺序
    public void shuffle() {
        Collections.shuffle(cards); // 使用 Collections 类的 shuffle 方法进行洗牌
    }

    // 从牌堆顶部抽取一张新牌
    public Card drawCard() {
        return cards.remove(cards.size() - 1); // 从列表末尾移除一张牌并返回
    }

    // 将牌添加到牌堆底部
    public void returnCardToBottom(Card card) {
        cards.add(0, card); // 将牌添加到列表开头，即牌堆底部
    }
}