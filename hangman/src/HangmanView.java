import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// 游戏界面类，负责显示游戏界面
public class HangmanView extends JFrame {
    private HangmanGame game;

    private JPanel lettersPanel; // 字母按钮面板
    private JLabel messageLabel; // 显示消息的标签
    private JLabel hintLabel; // 显示提示信息的标签
    private JLabel wordLabel; // 显示单词的标签
    private HangmanCanvas hangmanCanvas; // 绘制挂人图示的面板

    private JMenuItem fileNextWord;
    private JMenuItem fileGiveUp;
    private JMenuItem fileExit;

    private JButton nextWordButton;
    private JButton giveUpButton;
    private JButton hintButton;

    public HangmanView(HangmanGame game) {
        this.game = game;

        setTitle("Hangman Game");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 菜单栏
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileNextWord = new JMenuItem("下一个单词");
        fileGiveUp = new JMenuItem("放弃猜测");
        fileExit = new JMenuItem("退出");

        fileMenu.add(fileNextWord);
        fileMenu.add(fileGiveUp);
        fileMenu.add(fileExit);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // 游戏内容区域
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        messageLabel = new JLabel();
        messageLabel.setFont(new Font("楷体", Font.BOLD, 16));
        gamePanel.add(messageLabel, BorderLayout.NORTH);

        wordLabel = new JLabel();
        wordLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gamePanel.add(wordLabel, BorderLayout.SOUTH);

        hintLabel = new JLabel();
        hintLabel.setFont(new Font("楷体", Font.BOLD, 16));
        gamePanel.add(hintLabel, BorderLayout.WEST);

        hangmanCanvas = new HangmanCanvas();
        JPanel hangmanPanel = new JPanel(new BorderLayout());
        hangmanPanel.add(hangmanCanvas, BorderLayout.CENTER);
        hangmanPanel.setPreferredSize(new Dimension(200, 400)); // 设置适当的首选大小
        gamePanel.add(hangmanPanel, BorderLayout.EAST);

        add(gamePanel, BorderLayout.CENTER);

        // 字母按钮区域
        lettersPanel = new JPanel();
        lettersPanel.setLayout(new GridLayout(2, 13));
        for (char c = 'A'; c <= 'Z'; c++) {
            JButton button = new JButton(String.valueOf(c));
            lettersPanel.add(button);
        }
        add(lettersPanel, BorderLayout.NORTH);

        // 功能按钮区域
        JPanel controlPanel = new JPanel();
        nextWordButton = new JButton("下一个单词");
        giveUpButton = new JButton("放弃猜测");
        hintButton = new JButton("提示");

        controlPanel.add(nextWordButton);
        controlPanel.add(giveUpButton);
        controlPanel.add(hintButton);
        add(controlPanel, BorderLayout.SOUTH);
    }

    // 设置单词显示
    public void setWordDisplay(String word) {
        wordLabel.setText(word);
    }

    // 设置消息
    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    // 设置提示信息
    public void setHintMessage(String hint) {
        hintLabel.setText(hint);
    }

    // 设置剩余尝试次数
    public void setTriesLeft(int triesLeft) {
        hangmanCanvas.setTriesLeft(triesLeft);
    }

    // 添加字母按钮监听器
    public void addLetterButtonListener(ActionListener listener) {
        for (Component component : lettersPanel.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(listener);
            }
        }
    }

    // 启用所有字母按钮
    public void enableAllLetterButtons() {
        for (Component component : lettersPanel.getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(true);
            }
        }
    }

    // 禁用所有字母按钮
    public void disableAllLetterButtons() {
        for (Component component : lettersPanel.getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(false);
            }
        }
    }

    // 添加下一个单词按钮监听器
    public void addNextWordButtonListener(ActionListener listener) {
        nextWordButton.addActionListener(listener);
        fileNextWord.addActionListener(listener);
    }

    // 添加放弃猜测按钮监听器
    public void addGiveUpButtonListener(ActionListener listener) {
        giveUpButton.addActionListener(listener);
        fileGiveUp.addActionListener(listener);
    }

    // 添加提示按钮监听器
    public void addHintButtonListener(ActionListener listener) {
        hintButton.addActionListener(listener);
    }

    // 添加退出按钮监听器
    public void addExitButtonListener(ActionListener listener) {
        fileExit.addActionListener(listener);
    }
}
