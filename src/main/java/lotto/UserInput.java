package lotto;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

class UserInput {

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

                if (num >= LottoGame.MIN_NUM && num <= LottoGame.MAX_NUM) {
                    if (!selectedNumbers.add(num)) {
                        System.out.println("Ta liczba została już wybrana.");
                    }
                } else {
                    System.out.println("Podałeś liczbę spoza zakresu (" + LottoGame.MIN_NUM +
                            " - " + LottoGame.MAX_NUM + ")!");
                }

            } catch (InputMismatchException e) {
                //return new ConsoleOutput("Błędny format! Wprowadź liczbę całkowitą.");
                System.out.println("Błędny format! Wprowadź liczbę całkowitą.");
                scanner.next();
            }
        }
        return  selectedNumbers;
    }
}
