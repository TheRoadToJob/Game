import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class LottoGame {

    private static final int QUANTITY_OF_NUMBERS = 6;

    public LottoGame() throws NoSuchAlgorithmException {
    }


    public Set<Integer> selectNumbers() {

        Set<Integer> selectedNumbers = new HashSet<>();


        while (selectedNumbers.size() != QUANTITY_OF_NUMBERS) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Podaj liczbę: ");
                int num = scanner.nextInt();

                if (num > 0 && num < 100) {
                    selectedNumbers.add(num);
                } else {
                    System.out.println("Podałeś liczbę spoza zakresu!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Błąd! Wprowadź liczbę całkowitą.");
            }
        }
        return selectedNumbers;
    }

    public Set<Integer> randomNumbers() {

        Set<Integer> randomNumbers = new HashSet<>();

        SecureRandom secureRandomGenerator = new SecureRandom();

        for (int i = 0; i < QUANTITY_OF_NUMBERS; i++) {
            int min = 1;
            int max = 99;

            int nextInt = secureRandomGenerator.nextInt(max - min +1) + min;
            randomNumbers.add(nextInt);
        }
        return randomNumbers;
    }


}
