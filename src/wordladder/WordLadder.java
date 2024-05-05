package wordladder;

import java.util.*;

public class WordLadder {
    private List<String> path;
    private int nodesVisited;

    public WordLadder(List<String> path, int nodesVisited) {
        this.path = path;
        this.nodesVisited = nodesVisited;
    }

    public void setPathError(String error) {
        if (this.path == null) {
            this.path = new ArrayList<>();
        }
        this.path.add(error);
    }

    public List<String> getPath() {
        return path;
    }

    public int getNodesVisited() {
        return nodesVisited;
    }
}