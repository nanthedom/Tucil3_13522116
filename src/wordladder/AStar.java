package wordladder;

import java.util.*;
import lib.*;

public class AStar implements IWordLadder {
    @Override
    public WordLadder solver(String start, String end, HashSet<String> dictionary) {
        HashSet<String> visited = new HashSet<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new lib.NComparator());
        Node currentNode = new Node(0, Util.heuristicCost(start, end), start, null);

        priorityQueue.offer(currentNode);
        visited.add(currentNode.getWord());

        int check = 0;
        while (!priorityQueue.isEmpty()) {
            currentNode = priorityQueue.poll();
            String word = currentNode.getWord();

            check++;
            if (currentNode.equalWord(end))
                return new WordLadder(currentNode.buildPath(), check);

            for (int i = 0; i < word.length(); i++) {
                for (char character = 'A'; character <= 'Z'; character++) {
                    if (word.charAt(i) != character) {
                        StringBuilder str = new StringBuilder(word);
                        str.setCharAt(i, character);
                        String tempWord = str.toString();

                        if (dictionary.contains(tempWord)) {
                            if (!visited.contains(tempWord)) {
                                int depth = currentNode.getDepth() + 1;
                                int cost = Util.heuristicCost(tempWord, end) + depth;
                                Node newNode = new Node(depth, cost, tempWord, currentNode);
                                priorityQueue.offer(newNode);
                                visited.add(tempWord);
                            }
                        }
                    }
                }
            }
        }

        return new WordLadder(null, check);
    }

    public static void main(String[] args) {
        lib.Dictionary dict = new lib.Dictionary("dictionary.txt");
        AStar solver = new AStar();
        WordLadder result = solver.solver("FUCK", "SHIT", dict.getDictionary());
        List<String> path = result.getPath();
        int nodesVisited = result.getNodesVisited();
        System.out.println("Path: " + path);
        System.out.println("Number of nodes visited: " + nodesVisited);
    }
}
