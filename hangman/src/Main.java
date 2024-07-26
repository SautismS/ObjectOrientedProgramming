import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 首先运行WordListLoader
            WordListLoader loader = new WordListLoader("wordlist.txt");
            List<String> words = loader.getWords();
            String difficulty = loader.getSelectedDifficulty();

            // 然后创建Hangman游戏
            HangmanGame game = new HangmanGame();
            HangmanView view = new HangmanView(game);
            new HangmanController(game, view, words, difficulty);

            view.setVisible(true);
        });
    }
}
