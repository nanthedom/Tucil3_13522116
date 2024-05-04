package wordladder;

import java.util.*;

public interface IWordLadder {
    WordLadder solver(String start, String end, HashSet<String> dictionary);
}