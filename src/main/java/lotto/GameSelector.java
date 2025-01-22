package lotto;

import java.util.InputMismatchException;

class GameSelector {

    static final int MAX_NUMBER_OF_ATTEMPTS = 3;
    private final ConsoleInputProvider consoleInputProvider;

    public GameSelector(ConsoleInputProvider consoleInputProvider) {
        this.consoleInputProvider = consoleInputProvider;
    }

    Game chooseGame() {

        int count = 0;

        while (count < MAX_NUMBER_OF_ATTEMPTS) {

            try {
                consoleInputProvider.print("Wybierz grę:");
                consoleInputProvider.print("1 - Lotek");
                consoleInputProvider.print("==========");
                consoleInputProvider.print("0 - przerwanie wyboru gry i zamknięcie programu.");
                int choice = consoleInputProvider.getInt();

                switch (choice) {
                    case 1:
                        return new LottoGameStart();
                    case 0:
                        System.exit(0);
                    default:
                        consoleInputProvider.print("Błędny wybór!");
                        count++;
                }
            } catch (InputMismatchException e) {
                consoleInputProvider.print("Błędny format! Wprowadź liczbę całkowitą.");
                consoleInputProvider.getInt();
                count++;
            }
        }
        consoleInputProvider.print("Przekroczono dopuszczalną ilość prób uruchomienia gry (" + MAX_NUMBER_OF_ATTEMPTS + ").");
        return null;
    }
}
