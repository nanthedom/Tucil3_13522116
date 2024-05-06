package CLI;

import java.io.IOException;
import java.util.Scanner;

public class UI {
    public static String ANSI_RED = "\u001B[31m";
	public static String ANSI_YELLOW = "\u001B[33m";
	public static String ANSI_GREEN = "\u001B[32m";
	public static String ANSI_RESET = "\u001B[0m";
    public static Scanner scan = new Scanner(System.in);

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

    public static void choiceAlgorithm() {
        System.out.print("""
                >> Choose The Algoritma
                    1. Uniform Cost Search
                    2. Greedy Best First Search
                    3. A*
                    """);
        System.out.print("Enter your choice (1-3): ");
    }

    public static String colorMatchingCharacters(String text, String end) {
        int minLength = Math.min(text.length(), end.length());
        StringBuilder coloredText = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            if (text.charAt(i) == end.charAt(i)) {
                coloredText.append(ANSI_GREEN).append(text.charAt(i)).append(ANSI_RESET);
            } else {
                coloredText.append(text.charAt(i));
            }
        }

        if (text.length() > end.length()) {
            coloredText.append(text.substring(minLength));
        } else if (end.length() > text.length()) {
            coloredText.append(end.substring(minLength));
        }

        return coloredText.toString();
    }

    public static void clearScreen() throws InterruptedException, IOException {
        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder processBuilder = new ProcessBuilder();

        if (os.contains("win")) { // Untuk Windows
            processBuilder.command("cmd", "/c", "cls");
        } else { // Untuk Linux
            processBuilder.command("clear");
        }

        processBuilder.inheritIO().start().waitFor();
    }

    public static void printInputInvalid() {
        System.out.println(">> Input invalid");
    }

    public static void printOpening() {
        String opening = ANSI_YELLOW + """

                _|          _|    _|_|    _|_|_|    _|_|_|        _|          _|_|    _|_|_|    _|_|_|    _|_|_|_|  _|_|_|
                _|          _|  _|    _|  _|    _|  _|    _|      _|        _|    _|  _|    _|  _|    _|  _|        _|    _|
                _|    _|    _|  _|    _|  _|_|_|    _|    _|      _|        _|_|_|_|  _|    _|  _|    _|  _|_|_|    _|_|_|
                _|  _|  _|    _|    _|  _|    _|  _|    _|      _|        _|    _|  _|    _|  _|    _|  _|        _|    _|
                    _|  _|        _|_|    _|    _|  _|_|_|        _|_|_|_|  _|    _|  _|_|_|    _|_|_|    _|_|_|_|  _|    _|

                                """ + ANSI_RESET + ANSI_RED + "\n>> Press Ctrl + C to terminate program" + ANSI_RESET;
        System.out.print(opening);
    }

    public static void startingLoading() throws InterruptedException, IOException {
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                █▒▒▒▒▒▒▒▒▒ 10%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                ██▒▒▒▒▒▒▒▒ 20%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                ███▒▒▒▒▒▒▒ 30%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                ████▒▒▒▒▒▒ 40%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                █████▒▒▒▒▒ 50%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                ██████▒▒▒▒ 60%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                ███████▒▒▒ 70%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                ████████▒▒ 80%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_RED + """
                Initialization begin...
                █████████▒ 90%
                    """ + ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(ANSI_GREEN + """
                Initialization begin...
                ██████████ 100%
                    """ + ANSI_RESET);
        Thread.sleep(1000);
        clearScreen();
    }
}



