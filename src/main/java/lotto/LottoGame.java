package lotto;

import java.util.Set;

class LottoGame {

    private final UserInput userInput;
    private final RandomNumberGenerator randomNumberGenerator;

    private static final int QUANTITY_OF_NUMBERS = 6;
    public static final int MAX_NUM = 99;
    public static final int MIN_NUM = 1;

    public LottoGame(UserInput userInput, RandomNumberGenerator randomNumberGenerator) {
        this.userInput = userInput;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String play() {
        StringBuilder result = new StringBuilder();

        result.append("Wybierz ")
                .append(QUANTITY_OF_NUMBERS)
                .append(" liczb z puli od ")
                .append(MIN_NUM)
                .append(" do ")
                .append(MAX_NUM).append(".")
                .append("\n");

        Set<Integer> userNumbers = userInput.selectNumbers(QUANTITY_OF_NUMBERS);
        result.append("Twoje liczby to: ")
                .append(userNumbers)
                .append("\n");

        result.append("Teraz losujemy liczby.")
                .append("\n");
        Set<Integer> drawnNumbers = randomNumberGenerator.generateRandomNumbers(QUANTITY_OF_NUMBERS);
        result.append("Wylosowane liczby to: ")
                .append(drawnNumbers)
                .append("\n");

        userNumbers.retainAll(drawnNumbers);

        result.append("Ilość trafionych liczb to: ")
                .append(userNumbers.size())
                .append("\n");

        if (!userNumbers.isEmpty()) {
            result.append("Twoje trafione liczby: ")
                    .append(userNumbers)
                    .append("\n");
        } else {
            result.append("Niestety, nie trafiłeś żadnej liczby.")
                    .append("\n");
        }
        return result.toString();
    }
}
