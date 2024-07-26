import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HangmanController {
    private HangmanGame game;
    private HangmanView view;
    private List<String> words;
    private String difficulty;
    private int hintsLeft;

    public HangmanController(HangmanGame game, HangmanView view, List<String> words, String difficulty) {
        this.game = game;
        this.view = view;
        this.words = words;
        this.difficulty = difficulty;

        view.addLetterButtonListener(new LetterButtonListener());
        view.addNextWordButtonListener(new NextWordButtonListener());
        view.addGiveUpButtonListener(new GiveUpButtonListener());
        view.addHintButtonListener(new HintButtonListener());
        view.addExitButtonListener(new ExitButtonListener());

        startNewGame();
    }

    private void startNewGame() {
        if (words.isEmpty()) {
            JOptionPane.showMessageDialog(view, "选定难度的单词库为空，请检查wordlist.txt文件。");
            return;
        }

        switch (difficulty) {
            case "简单":
                hintsLeft = 3;
                break;
            case "较难":
                hintsLeft = 2;
                break;
            case "最难":
                hintsLeft = 1;
                break;
        }

        game.startNewGame(words.get((int) (Math.random() * words.size())));
        view.setWordDisplay(game.getWordDisplay());
        view.setTriesLeft(game.getTriesLeft());
        view.setMessage("<html>这个英文单词共有" + game.getCurrentWord().length() + "个字符。" +
                "<br>还可以使用的预测次数是：" + game.getTriesLeft() + "次。</html>");
        view.setHintMessage("剩余提示次数：" + hintsLeft + "次。");
        view.enableAllLetterButtons();
    }

    private class LetterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setEnabled(false);
            char guessedLetter = button.getText().charAt(0);
            game.guessLetter(guessedLetter);
            view.setWordDisplay(game.getWordDisplay());
            view.setTriesLeft(game.getTriesLeft());
            view.setMessage("<html>这个英文单词共有" + game.getCurrentWord().length() + "个字符。" +
                    "<br>还可以使用的预测次数是：" + game.getTriesLeft() + "次。</html>");

            if (game.isGameOver()) {
                if (game.isWordGuessed()) {
                    view.setMessage("你赢了！");
                } else {
                    view.setMessage("你输了，单词是：" + game.getCurrentWord());
                }
                view.disableAllLetterButtons();
            }
        }
    }

    private class NextWordButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startNewGame();
        }
    }

    private class GiveUpButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setMessage("你放弃了，单词是：" + game.getCurrentWord());
            view.disableAllLetterButtons();
        }
    }

    private class HintButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (hintsLeft > 0) {
                char hint = game.getHint();
                if (hint != '\0') {
                    hintsLeft--;
                    view.setHintMessage("<html>提示：该单词含有字母" + hint + "。" +
                            "<br>剩余提示次数：" + hintsLeft + "次。</html>");
                } else {
                    view.setHintMessage("所有字母都已猜出！");
                }
            } else {
                view.setHintMessage("没有剩余提示次数！");
            }
        }
    }

    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
