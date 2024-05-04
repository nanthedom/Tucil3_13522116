package wordladder;

import java.util.*;

public class WordLadder {
    private List<String> path;
    private int nodesVisited;

    public WordLadder(List<String> path, int nodesVisited) {
        this.path = path;
        this.nodesVisited = nodesVisited;
    }

    public List<String> getPath() {
        return path;
    }

    public int getNodesVisited() {
        return nodesVisited;
    }
}