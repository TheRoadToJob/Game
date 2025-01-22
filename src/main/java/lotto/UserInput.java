package lotto;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

class UserInput {

    private final ConsoleInputProvider consoleInputProvider;

    public UserInput(ConsoleInputProvider consoleInputProvider) {
        this.consoleInputProvider = consoleInputProvider;
    }

    public Set<Integer> selectNumbers(int quantityOfNumbers) {

        Set<Integer> selectedNumbers = new HashSet<>();

        while (selectedNumbers.size() < quantityOfNumbers) {

            try {
                consoleInputProvider.print("Podaj liczbę: ");
                int num = consoleInputProvider.getInt();

                if (num >= LottoGame.MIN_NUM && num <= LottoGame.MAX_NUM) {
                    if (!selectedNumbers.add(num)) {
                        consoleInputProvider.print("Ta liczba została już wybrana.");
                    }
                } else {
                    consoleInputProvider.print("Podałeś liczbę spoza zakresu (" + LottoGame.MIN_NUM +
                            " - " + LottoGame.MAX_NUM + ")!");
                }

            } catch (InputMismatchException e) {
                consoleInputProvider.print("Błędny format! Wprowadź liczbę całkowitą.");
                consoleInputProvider.getInt();
            }
        }
        return  selectedNumbers;
    }
}
