package CLI;

import java.io.IOException;

import lib.Util;

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
        String opening = Util.ANSI_YELLOW + """

                _|          _|    _|_|    _|_|_|    _|_|_|        _|          _|_|    _|_|_|    _|_|_|    _|_|_|_|  _|_|_|
                _|          _|  _|    _|  _|    _|  _|    _|      _|        _|    _|  _|    _|  _|    _|  _|        _|    _|
                _|    _|    _|  _|    _|  _|_|_|    _|    _|      _|        _|_|_|_|  _|    _|  _|    _|  _|_|_|    _|_|_|
                _|  _|  _|    _|    _|  _|    _|  _|    _|      _|        _|    _|  _|    _|  _|    _|  _|        _|    _|
                    _|  _|        _|_|    _|    _|  _|_|_|        _|_|_|_|  _|    _|  _|_|_|    _|_|_|    _|_|_|_|  _|    _|

                                """ + Util.ANSI_RESET;
        System.out.print(opening);
    }

    public static void startingLoading() throws InterruptedException, IOException {
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                █▒▒▒▒▒▒▒▒▒ 10%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                ██▒▒▒▒▒▒▒▒ 20%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                ███▒▒▒▒▒▒▒ 30%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                ████▒▒▒▒▒▒ 40%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                █████▒▒▒▒▒ 50%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                ██████▒▒▒▒ 60%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                ███████▒▒▒ 70%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                ████████▒▒ 80%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_RED + """
                Initialization begin...
                █████████▒ 90%
                    """ + Util.ANSI_RESET);
        Thread.sleep(200);
        clearScreen();
        System.out.print(Util.ANSI_GREEN + """
                Initialization begin...
                ██████████ 100%
                    """ + Util.ANSI_RESET);
        Thread.sleep(1000);
        clearScreen();
    }
}
