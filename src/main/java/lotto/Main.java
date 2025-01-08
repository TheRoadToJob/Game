package lotto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameSelector gameSelector = new GameSelector(new Scanner(System.in));

        boolean keepPlaying;
        do {
            Game selectedGame = gameSelector.chooseGame();
            if (selectedGame != null) {
                System.out.println("Wybrano grę: " + selectedGame.getName());
                selectedGame.start();
            } else {
                System.out.println("Nie wybrano poprawnie gry.");
            }
            System.out.println("Czy chcesz zagrać ponownie? (tak/nie)");
            keepPlaying = scanner.next().equalsIgnoreCase("tak");

        } while (keepPlaying);
    }
}