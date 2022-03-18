package fr.hb.casting_agency.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleManager {
    private Scanner scan;

    private static ConsoleManager INSTANCE = null;

    private ConsoleManager() {
        scan = new Scanner(System.in);
    }

    /**
     * Get the only instance of the ConsoleManager
     * @return {@linkplain ConsoleManager}
     */
    public static ConsoleManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ConsoleManager();
        }

        return INSTANCE;
    }

    /**
     * Read user input from console as String
     *
     * @return a {@linkplain String}
     */
    public String readUserInput() {
        return scan.nextLine();
    }

    /**
     * Read user input from console as Integer
     *
     * @return an {@linkplain Integer}
     */
    public Integer readUserInputInteger() {
        Boolean answerRight = false;
        Integer answer = -1;

        do {
            try {
                answer = scan.nextInt();
                answerRight = true;
            } catch (InputMismatchException e) {
                ConsoleManager.getInstance().printToConsole("Please try again", true);
            }

            scan.nextLine();
        } while (!answerRight);

        return answer;
    }

    public Long readUserInputLong() {
        Boolean answerRight = false;
        Long answer = -1L;

        do {
            try {
                answer = scan.nextLong();
                answerRight = true;
            } catch (InputMismatchException e) {
                ConsoleManager.getInstance().printToConsole("Please try again : ", false);
            }

            scan.nextLine();
        } while (!answerRight);

        return answer;
    }

    /**
     * Print to console
     *
     * @param text      the text to print
     * @param breakLine if a line break needs to be printed after the text
     */
    public void printToConsole(String text, boolean breakLine) {
        if (breakLine) {
            System.out.println(text);
        } else {
            System.out.print(text);
        }
    }


    public void printToConsoleError(String text, boolean breakLine) {
        if (breakLine) {
            System.err.println(text);
        } else {
            System.err.print(text);
        }
    }

    /**
     * Add a line break to the console
     */
    public void consoleLineBreak() {
        System.out.println();
    }

    public void closeScanner() {
        scan.close();
    }

    public void printLine() {
        printToConsole("-----------------------", true);
    }

    public void printLineNoLineBreak() {
        printToConsole("-----------------------", false);
    }

    public void printTwoLines() {
        printToConsole("-----------------------", true);
        printToConsole("-----------------------", true);
    }
}
