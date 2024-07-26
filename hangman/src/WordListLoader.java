import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordListLoader {
    private List<String> easyWords = new ArrayList<>();
    private List<String> mediumWords = new ArrayList<>();
    private List<String> hardWords = new ArrayList<>();
    private String selectedDifficulty;

    public WordListLoader(String filename) {
        loadWordsFromFile(filename);
        selectDifficulty();
    }

    private void loadWordsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim().toUpperCase();
                if (word.length() <= 6) {
                    easyWords.add(word);
                } else if (word.length() <= 9) {
                    mediumWords.add(word);
                } else {
                    hardWords.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectDifficulty() {
        String[] difficulties = {"简单", "较难", "最难"};
        selectedDifficulty = (String) JOptionPane.showInputDialog(
                null,
                "选择游戏难度",
                "难度选择",
                JOptionPane.QUESTION_MESSAGE,
                null,
                difficulties,
                difficulties[0]
        );

        if (selectedDifficulty == null) {
            System.exit(0);
        }
    }

    public List<String> getWords() {
        switch (selectedDifficulty) {
            case "较难":
                return mediumWords;
            case "最难":
                return hardWords;
            default:
                return easyWords;
        }
    }

    public String getSelectedDifficulty() {
        return selectedDifficulty;
    }
}
