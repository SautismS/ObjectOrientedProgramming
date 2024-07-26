import java.util.ArrayList;
import java.util.List;

// Hand 类表示玩家的一手牌
class Hand {
    private final List<Card> cards; // 存储玩家手牌的列表

    // Hand 类的构造函数，用于创建一个空的手牌列表
    public Hand() {
        cards = new ArrayList<>(); // 初始化手牌列表
    }

    // 向手牌中添加一张牌
    public void addCard(Card card) {
        cards.add(card); // 添加牌到手牌列表
    }

    // 从手牌中移除指定索引位置的牌
    public void removeCard(int index) {
        if (index >= 0 && index < cards.size()) { // 检查索引的有效性
            cards.remove(index); // 移除指定索引位置的牌
        } else {
            System.out.println("索引越界或无效索引！");
        }
    }

    // 判断三张牌是否可以组成有效的出牌
    public static boolean isValidSet(Card card1, Card card2, Card card3) {
        return (card1.getSuit().equals(card2.getSuit()) && card2.getSuit().equals(card3.getSuit())) ||
                (card1.getValue().equals(card2.getValue()) && card2.getValue().equals(card3.getValue()));
    }

    // 计算三张牌组成的得分
    public static int calculateScore(Card card) {
        int score = 0;
        // 计分规则：2 到 9 的牌每张 5 分，其他牌（包括 A、J、Q、K 和 10）每张 10 分
        List<String> specialValues = List.of("A", "T", "J", "Q", "K");
        if (specialValues.contains(card.getValue())) score += 10;
        else score += 5;
        return score;
    }

    // 获取手牌列表
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            handString.append("[").append(i).append("]").append(cards.get(i)).append("  ");
        }
        return handString.toString();
    }
}
