// Player 类表示一个玩家
class Player {
    private final String name; // 玩家的名字
    private int score; // 玩家的得分
    private final Hand hand; // 玩家的手牌

    // Player 类的构造函数，用于初始化玩家的名字、得分和手牌
    public Player(String name) {
        this.name = name; // 初始化玩家的名字
        this.score = 0; // 初始化玩家的得分为 0
        this.hand = new Hand(); // 初始化玩家的手牌
    }

    // 获取玩家的名字
    public String getName() {
        return name;
    }

    // 获取玩家的得分
    public int getScore() {
        return score;
    }

    // 增加玩家的得分
    public void increaseScore(int points) {
        score += points; // 增加玩家的得分
    }

    // 减少玩家的得分
    public void decreaseScore(int points) {
        score -= points; // 减少玩家的得分
    }

    // 获取玩家的手牌
    public Hand getHand() {
        return hand;
    }
}
