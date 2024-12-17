package lotto;

import java.util.Set;

class LottoGame {

    private final UserInput userInput;
    private final RandomNumberGenerator randomNumberGenerator;
    private final ConsoleOutput consoleOutput;

    private static final int QUANTITY_OF_NUMBERS = 6;
    public static final int MAX_NUM = 99;
    public static final int MIN_NUM = 1;

    public LottoGame(UserInput userInput, RandomNumberGenerator randomNumberGenerator, ConsoleOutput consoleOutput) {
        this.userInput = userInput;
        this.randomNumberGenerator = randomNumberGenerator;
        this.consoleOutput = consoleOutput;
    }


    public void play() {

        consoleOutput.println("Wybierz 6 liczb z puli od " + MIN_NUM + " do " + MAX_NUM + ".");

        Set<Integer> userNumbers = userInput.selectNumbers(QUANTITY_OF_NUMBERS);
        consoleOutput.println("Twoje liczby to: " + userNumbers);

        consoleOutput.println("Teraz losujemy liczby.");
        Set<Integer> drawnNumbers = randomNumberGenerator.generateRandomNumbers(QUANTITY_OF_NUMBERS);
        consoleOutput.println("Wylosowane liczby to: " + drawnNumbers);

        userNumbers.retainAll(drawnNumbers);

        consoleOutput.println("Liczba trafionych liczb to: " + userNumbers.size());

        if (!userNumbers.isEmpty()) {
            consoleOutput.println("Twoje trafione liczby: " + userNumbers);
        } else {
            consoleOutput.println("Niestety, nie trafiłeś żadnej liczby.");
        }
    }
}
