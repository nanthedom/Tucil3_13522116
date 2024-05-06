package CLI;

import java.io.IOException;

public class UI {
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
        String opening = """

                _|          _|    _|_|    _|_|_|    _|_|_|        _|          _|_|    _|_|_|    _|_|_|    _|_|_|_|  _|_|_|
                _|          _|  _|    _|  _|    _|  _|    _|      _|        _|    _|  _|    _|  _|    _|  _|        _|    _|
                _|    _|    _|  _|    _|  _|_|_|    _|    _|      _|        _|_|_|_|  _|    _|  _|    _|  _|_|_|    _|_|_|
                _|  _|  _|    _|    _|  _|    _|  _|    _|      _|        _|    _|  _|    _|  _|    _|  _|        _|    _|
                    _|  _|        _|_|    _|    _|  _|_|_|        _|_|_|_|  _|    _|  _|_|_|    _|_|_|    _|_|_|_|  _|    _|

                                """;
        System.out.print(opening);
    }

    public static void startingLoading() throws InterruptedException, IOException {
        clearScreen();
        System.out.print("""
                Initialization begin...
                █▒▒▒▒▒▒▒▒▒ 10%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                ██▒▒▒▒▒▒▒▒ 20%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                ███▒▒▒▒▒▒▒ 30%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                ████▒▒▒▒▒▒ 40%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                █████▒▒▒▒▒ 50%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                ██████▒▒▒▒ 60%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                ███████▒▒▒ 70%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                ████████▒▒ 80%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                █████████▒ 90%
                    """);
        Thread.sleep(200);
        clearScreen();
        System.out.print("""
                Initialization begin...
                ██████████ 100%
                    """);
        Thread.sleep(200);
        clearScreen();
    }
}
