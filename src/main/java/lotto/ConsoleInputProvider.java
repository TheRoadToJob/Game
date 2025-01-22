package lotto;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {

    private final Scanner scanner;

    public ConsoleInputProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }
    
    @Override
    public String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        while(true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Błędny format! Wprowadź liczbę całkowitą.");
            }
        }
    }

    @Override
    public int getInt(String message) {
        while(true) {
            try {
                System.out.println(message);
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Błędny format! Wprowadź liczbę całkowitą.");
            }
        }
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }
}
