import java.util.Scanner;
import java.util.List;

// Game 类表示 Rummy 游戏
public class Game {
    private final Deck deck; // 纸牌堆对象
    private final Player player1; // 玩家1对象
    private final Player player2; // 玩家2对象

    // Game 类的构造函数，用于初始化纸牌堆和玩家对象
    public Game(Player player1, Player player2) {
        this.deck = new Deck(); // 初始化纸牌堆
        this.player1 = new Player(player1.getName()); // 初始化玩家1
        this.player2 = new Player(player2.getName()); // 初始化玩家2
    }

    // 游戏开始方法
    public void start() {
        // 发牌给玩家
        for (int i = 0; i < 6; i++) {
            player1.getHand().addCard(deck.drawCard()); // 玩家1抽牌
            player2.getHand().addCard(deck.drawCard()); // 玩家2抽牌
        }

        // 游戏主循环，直到其中一个玩家手牌为空
        while (!player1.getHand().getCards().isEmpty() && !player2.getHand().getCards().isEmpty()) {
            takeTurn(player1); // 玩家1出牌
            if (player1.getHand().getCards().isEmpty()) break; // 玩家1手牌为空，结束游戏
            takeTurn(player2); // 玩家2出牌
        }

        if (player1.getHand().getCards().isEmpty()){
            System.out.println(player1.getName() + "已经没有牌可用了，游戏结束。");
        }

        if (player2.getHand().getCards().isEmpty()){
            System.out.println(player2.getName() + "已经没有牌可用了，游戏结束。");
        }

        // 游戏结束，计算得分并宣布胜利者
        calculateScores();
        displayWinner();
    }

    // 玩家出牌的方法
    private void takeTurn(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + "，请进行你的回合：");

        // 从牌堆顶部抽取一张新牌
        Card newCard = deck.drawCard();
        player.getHand().addCard(newCard);
        System.out.println(player.getName() + " 抽到了新牌：" + newCard);
        System.out.println("现在你手里的牌有: " + player.getHand());

        // 询问玩家是否要出牌
        System.out.print("你决定出一套同花色或同值的三张牌吗？(y/n): ");
        String response = scanner.nextLine();

        if ("y".equalsIgnoreCase(response)) {
            // 出一组牌（同花色或同值的三张牌）
            playSet(player);

            // 选择一张不需要的牌放到牌堆的底部
            returnCardToDeck(player);
        } else if ("n".equalsIgnoreCase(response)) {
            // 不出牌，直接进入弃牌阶段
            System.out.println(player.getName() + " 选择不出牌，直接进入弃牌阶段。");

            returnCardToDeck(player); // 这里只是示例，可以根据实际游戏规则进行修改
        } else {
            // 输入不合法，重新询问
            System.out.println("输入不合法，请重新输入！");
            playSet(player);
        }
    }

    // 玩家出一组牌的方法
    private void playSet(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + "，请给出你要出的三张牌的序号（从小到大）：");

        List<Card> handCards = player.getHand().getCards();

        int card1 = scanner.nextInt();
        int card2 = scanner.nextInt();
        int card3 = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        // 验证出牌是否合法
        if (Hand.isValidSet(handCards.get(card1), handCards.get(card2), handCards.get(card3))) {
            // 计算得分并累加到玩家总分
            int points = Hand.calculateScore(handCards.get(card1)) + Hand.calculateScore(handCards.get(card2)) + Hand.calculateScore(handCards.get(card3));
            player.increaseScore(points);
            System.out.println("厉害啊！你获得了 " + points + " 分。");
            // 移除出的牌
            player.getHand().removeCard(card3);
            player.getHand().removeCard(card2);
            player.getHand().removeCard(card1);
        } else {
            System.out.println("你选的三张牌不符合出牌的规则。");
        }
    }

    // 玩家选择一张牌放回到牌堆的底部的方法
    private void returnCardToDeck(Player player) {
        List<Card> handCards = player.getHand().getCards();
        System.out.println("现在你手里的牌有: " + player.getHand());

        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + "，你想把哪张牌放回到牌堆中？请给出牌的序号：");
        int cardIndex = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        Card cardReturn = handCards.get(cardIndex);
        player.getHand().removeCard(cardIndex);
        deck.returnCardToBottom(cardReturn);
        System.out.println(player.getName() + " 将 " + cardReturn + " 放回到了牌堆底部。");
    }

    // 计算得分并宣布胜利者的方法
    private void calculateScores() {
        List<Card> handCards1 = player1.getHand().getCards();
        List<Card> handCards2 = player2.getHand().getCards();

        for (int i = 0; i < player1.getHand().getCards().size(); i++){
            int points = Hand.calculateScore(handCards1.get(i));
            player1.decreaseScore(points);
        }

        for (int i = 0; i < player2.getHand().getCards().size(); i++){
            int points = Hand.calculateScore(handCards2.get(i));
            player2.decreaseScore(points);
        }

        System.out.println(player1.getName() + "，目前得分是 " + player1.getScore() + " 分。");
        System.out.println(player2.getName() + "，目前得分是 " + player2.getScore() + " 分。");
    }

    // 显示胜利者的方法
    private void displayWinner() {
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();

        if (player1Score > player2Score) {
            System.out.println("祝贺 " + player1.getName() + "，你赢了！");
        } else if (player1Score < player2Score) {
            System.out.println("祝贺 " + player2.getName() + "，你赢了！");
        } else {
            System.out.println("游戏结束，平局！");
        }
    }

    // 主方法，用于运行游戏
    public static void main(String[] args) {
        System.out.println("欢迎玩一局简化版拉米（Rummy）纸牌游戏!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("玩家 1, 怎么称呼你？");
        String player1Name = scanner.nextLine();
        System.out.print("玩家 2, 怎么称呼你？");
        String player2Name = scanner.nextLine();

        Player player1 = new Player(player1Name); // 创建玩家1对象
        Player player2 = new Player(player2Name); // 创建玩家2对象

        Game game = new Game(player1, player2); // 实例化一个 Game 对象并传入玩家对象
        game.start(); // 开始游戏
    }
}
