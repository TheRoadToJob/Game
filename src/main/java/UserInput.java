import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class UserInput {

    private final Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Set<Integer> selectNumbers(int quantityOfNumbers) {

        Set<Integer> selectedNumbers = new HashSet<>();

        while (selectedNumbers.size() < quantityOfNumbers) {

            try {
                System.out.println("Podaj liczbę: ");
                int num = scanner.nextInt();

                if (num >= 1 && num <= 99) {
                    if (!selectedNumbers.add(num)) {
                        System.out.println("Ta liczba została już wybrana.");
                    }
                } else {
                    System.out.println("Podałeś liczbę spoza zakresu (1 - 99)!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Błędny format! Wprowadź liczbę całkowitą.");
                scanner.next();
            }
        }
        return selectedNumbers;
    }

}
