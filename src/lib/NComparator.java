package lib;

import java.util.*;

public class NComparator implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        int cost = Integer.compare(a.getCost(), b.getCost());
        if (cost != 0) {
            return cost;
        } else {
            return a.getWord().compareTo(b.getWord());
        }
    }
}
