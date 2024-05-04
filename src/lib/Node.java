package lib;

import java.util.*;

public class Node {
    private int     depth;
    private int     cost;
    private String  word;
    private Node    prev;

    public Node(int depth, int cost, String word, Node prev) {
        setDepth(depth);
        setCost(cost);
        setWord(word);
        setPrev(prev);
    }

    // getter
    public int getDepth()   {return depth;}
    public int getCost()    {return cost;}
    public String getWord() {return word;}
    public Node getPrev()   {return prev;}

    // setter
    public void setDepth(int depth)     {this.depth = depth;}
    public void setCost(int cost)       {this.cost  = cost;}
    public void setWord(String word)    {this.word  = word;}
    public void setPrev(Node Prev)      {this.prev  = Prev;}

    public boolean equalWord(String word) {
        return getWord().equals(word);
    }

    public List<String> buildPath() {
        List<String> path = new ArrayList<>();
        Node currentNode = this;
        while (currentNode != null) {
            path.add(0, currentNode.getWord());
            currentNode = currentNode.getPrev();
        }
        return path;
    }
}