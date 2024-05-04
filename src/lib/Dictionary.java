package lib;

import java.io.*;
import java.util.*;

public class Dictionary {
    private HashSet<String> dictionary = new HashSet<>();

    public Dictionary(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                dictionary.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error filename: " + e.getMessage());
            System.exit(1);
        }
    }

    public HashSet<String> getDictionary() {
        return dictionary;
    }
}