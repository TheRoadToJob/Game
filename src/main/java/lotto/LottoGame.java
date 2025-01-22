package lotto;

import java.util.Set;

class LottoGame {

    private final UserInput userInput;
    private final RandomNumberGenerator randomNumberGenerator;
    private final InputProvider inputProvider;

    private static final int QUANTITY_OF_NUMBERS = 6;
    public static final int MAX_NUM = 99;
    public static final int MIN_NUM = 1;

    public LottoGame(UserInput userInput, RandomNumberGenerator randomNumberGenerator, InputProvider inputProvider) {
        this.userInput = userInput;
        this.randomNumberGenerator = randomNumberGenerator;
        this.inputProvider = inputProvider;
    }

    public void play() {

        inputProvider.print("Wybierz 6 liczb z puli od " + MIN_NUM + " do " + MAX_NUM + ".");

        Set<Integer> userNumbers = userInput.selectNumbers(QUANTITY_OF_NUMBERS);
        inputProvider.print("Twoje liczby to: " + userNumbers);

        inputProvider.print("Teraz losujemy liczby.");
        Set<Integer> drawnNumbers = randomNumberGenerator.generateRandomNumbers(QUANTITY_OF_NUMBERS);
        inputProvider.print("Wylosowane liczby to: " + drawnNumbers);

        userNumbers.retainAll(drawnNumbers);

        inputProvider.print("Liczba trafionych liczb to: " + userNumbers.size());

        if (!userNumbers.isEmpty()) {
            inputProvider.print("Twoje trafione liczby: " + userNumbers);
        } else {
            inputProvider.print("Niestety, nie trafiłeś żadnej liczby.");
        }
    }
}
