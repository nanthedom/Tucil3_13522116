package interfaces;

import wordladder.*;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.Color;
import java.util.HashSet;

public class WordLadderEventHandler {
    private final HashSet<String> dictionary;

    public WordLadderEventHandler() {
        lib.Dictionary d = new lib.Dictionary("dictionary.txt");
        this.dictionary = d.getDictionary();
    }

    public void handleEvent(String startWord, String endWord, String algorithm, JTextPane resultArea,
            JLabel propsLabel) {
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
            long startTime = 0;
            long endTime = 0;
            switch (algorithm) {
                case "UCS":
                    UCS ucsSolver = new UCS();
                    startTime = System.nanoTime();
                    result = ucsSolver.solver(startWord, endWord, this.dictionary);
                    endTime = System.nanoTime();
                    break;
                case "GBFS":
                    GBFS gbfsSolver = new GBFS();
                    startTime = System.nanoTime();
                    result = gbfsSolver.solver(startWord, endWord, this.dictionary);
                    endTime = System.nanoTime();
                    break;
                case "A*":
                    AStar aStarSolver = new AStar();
                    startTime = System.nanoTime();
                    result = aStarSolver.solver(startWord, endWord, this.dictionary);
                    endTime = System.nanoTime();
                    break;
            }
            totalTime = (endTime - startTime) / 1e6;
        }
        displayProperties(totalTime, result, propsLabel, valid);
        displayResult(result, resultArea, endWord, valid);
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

    private void displayResult(WordLadder result, JTextPane resultArea, String endWord, boolean valid) {
        resultArea.setText("");

        if (result.getPath() == null) {
            appendToPane(resultArea, "\n    Path Not Found!\n", endWord, false);
        } else {
            for (int i = 0; i < result.getPath().size(); i++) {
                appendToPane(resultArea, result.getPath().get(i), endWord, valid);
            }
        }
    }

    private void appendToPane(JTextPane tp, String msg, String endWord, boolean valid) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet blackAttributes = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground,
                Color.BLACK);
        AttributeSet redAttributes = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);
        AttributeSet blueAttributes = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLUE);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        if (!valid) {
            for (int i = 0; i < msg.length(); i++) {
                tp.setCharacterAttributes(redAttributes, false);
                tp.replaceSelection(String.valueOf(msg.charAt(i)));
            }
        } else {
            for (int i = 0; i < endWord.length(); i++) {
                AttributeSet attributes = (msg.charAt(i) == endWord.charAt(i)) ? blueAttributes : blackAttributes;
                tp.setCharacterAttributes(attributes, false);
                tp.replaceSelection(String.valueOf(msg.charAt(i)));
            }
        }
        tp.replaceSelection("\n");
    }

}
