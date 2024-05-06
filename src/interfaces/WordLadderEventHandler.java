package interfaces;

import wordladder.*;
import javax.swing.*;
import java.util.HashSet;

public class WordLadderEventHandler {
    private final HashSet<String> dictionary;

    public WordLadderEventHandler() {
        lib.Dictionary d = new lib.Dictionary("dictionary.txt");
        this.dictionary = d.getDictionary();
    }

    public void handleEvent(String startWord, String endWord, String algorithm, JTextArea resultArea,
            JLabel propsLabel) {
        WordLadder result = processWords(startWord, endWord, algorithm, propsLabel);
        displayResult(result, resultArea);
    }

    private WordLadder processWords(String startWord, String endWord, String algorithm, JLabel propsLabel) {
        WordLadder result = new WordLadder(null, 0);
        boolean valid = true;
        if (startWord.length() == 0 || endWord.length() == 0) {
            String error = "Start Word or End Word cannot be blank!";
            result.setPathError(error);
            valid = false;
        } else {
            if (!this.dictionary.contains(startWord)) {
                String error = "The word " + startWord + " is not in our English dictionary!";
                result.setPathError(error);
                valid = false;
            }
            if (!this.dictionary.contains(endWord)) {
                String error = "The word " + endWord + " is not in our English dictionary!";
                result.setPathError(error);
                valid = false;
            }
            if (startWord.length() != endWord.length()) {
                String error = "The length of the start and end word doesn't match!";
                result.setPathError(error);
                valid = false;
            }
        }
        double totalTime = 0;
        if (valid) {
            long startTime = System.nanoTime();
            switch (algorithm) {
                case "UCS":
                    UCS ucsSolver = new UCS();
                    result = ucsSolver.solver(startWord, endWord, this.dictionary);
                    break;
                case "GBFS":
                    GBFS gbfsSolver = new GBFS();
                    result = gbfsSolver.solver(startWord, endWord, this.dictionary);
                    break;
                case "A*":
                    AStar aStarSolver = new AStar();
                    result = aStarSolver.solver(startWord, endWord, this.dictionary);
                    break;
            }
            long endTime = System.nanoTime();
            totalTime = (endTime - startTime) / 1e6;
        }
        displayProperties(totalTime, result, propsLabel, valid);
        return result;
    }

    private void displayProperties(double totalTime, WordLadder result, JLabel propsLabel, boolean valid) {
        if (!valid || result.getPath() == null) {
            propsLabel.setText("<html>Number of step: 0<br>Number of node visited: "
                    + result.getNodesVisited()
                    + "<br>Execution Time: " + (totalTime) + " ms</html>");
        } else {
            propsLabel.setText("<html>Number of step: " + (result.getPath().size() - 1)
                    + "<br>Number of node visited: " + result.getNodesVisited()
                    + "<br>Execution Time: " + (totalTime) + " ms</html>");
        }
    }

    private void displayResult(WordLadder result, JTextArea resultArea) {
        resultArea.setText("");
        if (result.getPath() == null) {
            resultArea.append("\n   Path Not Found!");
        } else {
            for (int i = 0; i < result.getPath().size(); i++) {
                resultArea.append(result.getPath().get(i) + "\n");
            }
        }
    }
}
