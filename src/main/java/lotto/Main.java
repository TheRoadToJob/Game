package lotto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConsoleInputProvider consoleInputProvider = new ConsoleInputProvider(new Scanner(System.in));
        GameSelector gameSelector = new GameSelector(consoleInputProvider);

        boolean keepPlaying;

        do {
            Game selectedGame = gameSelector.chooseGame();
            if (selectedGame != null) {
                consoleInputProvider.print("Wybrano grę: " + selectedGame.getName());
                selectedGame.start();
            } else {
                consoleInputProvider.print("Nie wybrano poprawnie gry.");
            }
            consoleInputProvider.print("Czy chcesz zagrać ponownie? (tak/nie)");
            keepPlaying = consoleInputProvider.getString().equalsIgnoreCase("tak");

        } while (keepPlaying);

        consoleInputProvider.closeScanner();
    }
}