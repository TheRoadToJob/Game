import lotto.LottoGameStart;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {



    public static void main(String[] args) {

        final int MAX_NUMBER_OF_ATTEMPTS = 4;
        int count = 0;


        chooseGame(count, MAX_NUMBER_OF_ATTEMPTS);
    }

    private static void chooseGame(int count, int MAX_NUMBER_OF_ATTEMPTS) {
        do {
            System.out.println("Wybierz grę: ");
            System.out.println("1 - Lotek");

            Scanner scanner = new Scanner(System.in);

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        LottoGameStart lottoGameStart = new LottoGameStart();
                        lottoGameStart.start();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Błędny wybór! Wybierz liczbę.");
            }
            count++;
        } while (count <= MAX_NUMBER_OF_ATTEMPTS);
        System.out.println("Przekroczono dopuszczalną ilość prób.");
    }
}
