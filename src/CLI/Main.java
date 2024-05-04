package CLI;

import java.io.IOException;
import java.util.*;
// import lib.*;
// import wordladder.*;

import wordladder.AStar;
import wordladder.GBFS;
import wordladder.UCS;
import wordladder.WordLadder;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static String inputStartWord() {
        System.out.println("\nEnter The Start Word!");
        System.out.print("Start Word: ");
        String input = scan.nextLine();
        return input.toUpperCase();
    }

    public static String inputEndWord() {
        System.out.println("\nEnter The End Word!");
        System.out.print("End Word: ");
        String input = scan.nextLine();
        return input.toUpperCase();
    }

    public static int choiceAlgorithm() {
        System.out.print("""
                >> Choose The Algoritma
                    1. Uniform Cost Search
                    2. Greedy Best First Search
                    3. A*
                    """);
        System.out.print("Enter choice (integer): ");
        int choice = scan.nextInt();
        return choice;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        boolean run = true;
        UI.startingLoading();
        lib.Dictionary Load = new lib.Dictionary("dictionary.txt");
        HashSet<String> dictionary = Load.getDictionary();
        while (run) {
            UI.clearScreen();
            UI.printOpening();
            String start = inputStartWord();
            while (!dictionary.contains(start)) {
                System.out.println("The word " + start + " is not in English dictionary!");
                start = inputStartWord().toUpperCase();
            }

            String end = inputEndWord();
            while (!dictionary.contains(end) || end.length() != start.length()) {
                if (!dictionary.contains(end)) {
                    System.out.println("The word " + end + " is not in English dictionary!");
                } else {
                    System.out.println("The length of the start and end word doesn't match!");
                }
                end = inputEndWord().toUpperCase();
            }
            System.out.println("\nStart from " + start + " To " + end + "\n");

            int choice = choiceAlgorithm();
            while (choice < 1 || choice > 3) {
                System.out.println("\nInvalid input!\n");
                choice = choiceAlgorithm();
            }
            UI.clearScreen();
            System.out.println("\nStart from " + start + " To " + end + "\n");
            System.out.print("Using ");

            WordLadder result = new WordLadder(null, 0);
            long startTime = System.nanoTime();
            switch (choice) {
                case 1:
                    System.out.println("Uniform Cost Search\n");
                    UCS ucsSolver = new UCS();
                    result = ucsSolver.solver(start, end, dictionary);
                    break;

                case 2:
                    System.out.println("Greedy Best First Search\n");
                    GBFS gbfsSolver = new GBFS();
                    result = gbfsSolver.solver(start, end, dictionary);
                    break;

                case 3:
                    System.out.println("A*\n");
                    AStar aStarSolver = new AStar();
                    result = aStarSolver.solver(start, end, dictionary);
                    break;

                default:
                    break;
            }
            long endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / 1e6;

            System.out.println("Path: ");
            if (result.getPath() == null) {
                System.out.println("\nPath Not Found!");
                System.out.println("\nNumber of step: 0");
            } else {
                for (int i = 0; i < result.getPath().size(); i++) {
                    System.out.println((i + 1) + ". " + result.getPath().get(i));
                }
                System.out.println("\nNumber of step: " + (result.getPath().size() - 1));
            }
            System.out.println("Number of nodes visited: " + result.getNodesVisited());
            System.out.println("Time Execution: " + totalTime + " ms");
            System.out.print("\n>> Press Enter key to continue...");
            scan.nextLine();
            scan.nextLine();
        }
    }
}