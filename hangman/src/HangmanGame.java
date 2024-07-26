import java.util.HashSet;
import java.util.Set;
import java.util.Random;

// 游戏逻辑类，负责处理游戏状态和逻辑
public class HangmanGame {
    private static final int MAX_TRIES = 7; // 最大尝试次数
    private int triesLeft = MAX_TRIES; // 剩余尝试次数
    private String currentWord; // 当前要猜的单词
    private Set<Character> guessedLetters = new HashSet<>(); // 已猜过的字母集合

    // 开始新游戏
    public void startNewGame(String word) {
        this.currentWord = word;
        this.guessedLetters.clear();
        this.triesLeft = MAX_TRIES;
    }

    // 猜一个字母
    public boolean guessLetter(char letter) {
        if (!currentWord.contains(String.valueOf(letter))) {
            triesLeft--;
        }
        guessedLetters.add(letter);
        return currentWord.contains(String.valueOf(letter));
    }

    // 判断游戏是否结束
    public boolean isGameOver() {
        return triesLeft <= 0 || isWordGuessed();
    }

    // 判断单词是否已经猜对
    public boolean isWordGuessed() {
        for (char c : currentWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    // 获取当前单词的显示状态（已猜对的字母显示，未猜对的显示为下划线）
    public String getWordDisplay() {
        StringBuilder display = new StringBuilder();
        for (char c : currentWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                display.append(c).append(' ');
            } else {
                display.append('_').append(' ');
            }
        }
        return display.toString();
    }

    // 获取剩余尝试次数
    public int getTriesLeft() {
        return triesLeft;
    }

    // 获取当前单词
    public String getCurrentWord() {
        return currentWord;
    }

    public char getHint() {
        StringBuilder hiddenLetters = new StringBuilder();
        for (char c : currentWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                hiddenLetters.append(c);
            }
        }
        if (hiddenLetters.length() > 0) {
            Random random = new Random();
            return hiddenLetters.charAt(random.nextInt(hiddenLetters.length()));
        }
        return 0; // 所有字母都已猜出
    }
}
