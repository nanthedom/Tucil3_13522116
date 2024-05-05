package wordladder;

import java.util.*;
import lib.*;

public class GBFS implements IWordLadder {
    @Override
    public WordLadder solver(String start, String end, HashSet<String> dictionary) {
        HashSet<String> visited = new HashSet<>();
        Node currentNode = new Node(0, Util.heuristicCost(start, end), start, null);
        int check = 0;
        while (true) {
            String word = currentNode.getWord();
            visited.add(word);
            check++;
            if (currentNode.equalWord(end))
                return new WordLadder(currentNode.buildPath(), check);

            int newCost = Integer.MAX_VALUE;
            String newWord = "";
            for (int i = 0; i < word.length(); i++) {
                for (char character = 'A'; character <= 'Z'; character++) {
                    if (word.charAt(i) != character) {
                        StringBuilder str = new StringBuilder(word);
                        str.setCharAt(i, character);
                        String tempWord = str.toString();

                        if (dictionary.contains(tempWord) && !visited.contains(tempWord)) {
                            int cost = Util.heuristicCost(tempWord, end);
                            if (cost < newCost) {
                                newCost = cost;
                                newWord = tempWord;
                            }
                        }
                    }
                }
            }

            if (newWord.equals(""))
                return new WordLadder(null, check);
            currentNode = new Node(currentNode.getDepth() + 1, newCost, newWord, currentNode);
        }
    }
}