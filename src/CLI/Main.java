package CLI;

import java.io.IOException;
import java.util.*;
import wordladder.AStar;
import wordladder.GBFS;
import wordladder.UCS;
import wordladder.WordLadder;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        boolean run = true;
        UI.startingLoading();
        lib.Dictionary Load = new lib.Dictionary("dictionary.txt");
        HashSet<String> dictionary = Load.getDictionary();
        while (run) {
            UI.clearScreen();
            UI.printOpening();
            String start = UI.inputStartWord();
            while (!dictionary.contains(start)) {
                if (start.length() == 0) {
                    System.out.println(UI.ANSI_RED + "The Start Word cannot be blank!" + UI.ANSI_RESET);
                } else {
                    System.out.println(
                            UI.ANSI_RED + "The word " + start + " is not in our English dictionary!" + UI.ANSI_RESET);
                }
                start = UI.inputStartWord().toUpperCase();
            }

            String end = UI.inputEndWord();
            while (!dictionary.contains(end) || end.length() != start.length()) {
                if (end.length() == 0) {
                    System.out.println(UI.ANSI_RED + "The End Word cannot be blank!" + UI.ANSI_RESET);
                } else if (!dictionary.contains(end)) {
                    System.out.println(
                            UI.ANSI_RED + "The word " + end + " is not in our English dictionary!" + UI.ANSI_RESET);
                } else {
                    System.out.println(
                            UI.ANSI_RED + "The length of the start and end word doesn't match!" + UI.ANSI_RESET);
                }
                end = UI.inputEndWord().toUpperCase();
            }
            System.out.println("\nStart from " + UI.ANSI_RED + start + UI.ANSI_RESET + " To " + UI.ANSI_GREEN + end
                    + UI.ANSI_RESET + "\n");

            int choice = 0;
            boolean isValidInput = false;
            while (!isValidInput) {
                UI.choiceAlgorithm();
                if (UI.scan.hasNextInt()) {
                    choice = UI.scan.nextInt();
                    if (choice >= 1 && choice <= 3) {
                        isValidInput = true;
                    } else {
                        System.out.println(UI.ANSI_RED + "\nInvalid input!\nPlease enter a number between 1 and 3!\n"
                                + UI.ANSI_RESET);
                    }
                } else {
                    System.out
                            .println(UI.ANSI_RED + "\nInvalid input!\nPlease enter a valid integer!\n" + UI.ANSI_RESET);
                    UI.scan.next();
                }
            }

            UI.clearScreen();
            System.out.println("\nStart from " + UI.ANSI_RED + start + UI.ANSI_RESET + " To " + UI.ANSI_GREEN + end
                    + UI.ANSI_RESET + "\n");
            System.out.print(UI.ANSI_YELLOW + "Using ");

            WordLadder result = new WordLadder(null, 0);
            long startTime = System.nanoTime();
            switch (choice) {
                case 1:
                    System.out.println("Uniform Cost Search\n" + UI.ANSI_RESET);
                    UCS ucsSolver = new UCS();
                    result = ucsSolver.solver(start, end, dictionary);
                    break;

                case 2:
                    System.out.println("Greedy Best First Search\n" + UI.ANSI_RESET);
                    GBFS gbfsSolver = new GBFS();
                    result = gbfsSolver.solver(start, end, dictionary);
                    break;

                case 3:
                    System.out.println("A*\n" + UI.ANSI_RESET);
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
                System.out.println(UI.ANSI_RED + "\nPath Not Found!" + UI.ANSI_RESET);
                System.out.println("\nNumber of step: 0");
            } else {
                for (int i = 0; i < result.getPath().size(); i++) {
                    String str = UI.colorMatchingCharacters(result.getPath().get(i), end);
                    System.out.println((i + 1) + ". " + str);
                }
                System.out.println("\nNumber of step: " + (result.getPath().size() - 1));
            }
            System.out.println("Number of nodes visited: " + result.getNodesVisited());
            System.out.println("Time Execution: " + totalTime + " ms");
            System.out.print(UI.ANSI_YELLOW + "\n>> Press Enter key to continue..." + UI.ANSI_RESET);
            UI.scan.nextLine();
            UI.scan.nextLine();
        }
    }
}



