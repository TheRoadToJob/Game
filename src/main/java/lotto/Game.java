package lotto;

import java.util.InputMismatchException;
import java.util.Scanner;

class Game {

    static final int MAX_NUMBER_OF_ATTEMPTS = 3;
    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    void chooseGame() {

        int count = 0;

        while (count < MAX_NUMBER_OF_ATTEMPTS) {

            try {
                System.out.println("Wybierz grę:");
                System.out.println("1 - Lotek");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        LottoGameStart lottoGameStart = new LottoGameStart();
                        lottoGameStart.start();
                        break;

                    default:
                        System.out.println("Błędny wybór!");
                        count++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Błędny format! Wprowadź liczbę całkowitą.");
                scanner.next();
                count++;
            }
        }
        System.out.println("Przekroczono dopuszczalną ilość prób uruchomienia gry (" + MAX_NUMBER_OF_ATTEMPTS + ").");
    }
}
