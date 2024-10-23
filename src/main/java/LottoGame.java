import java.security.SecureRandom;
import java.util.*;

public class LottoGame {

    private final UserInput userInput;
    private final RandomNumberGenerator randomNumberGenerator;

    private static final int QUANTITY_OF_NUMBERS = 6;

    public LottoGame(UserInput userInput, RandomNumberGenerator randomNumberGenerator) {
        this.userInput = userInput;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play() {

        System.out.println("Wybierz 6 liczb z puli od 1 do 99.");

        Set<Integer> userNumbers = userInput.selectNumbers(QUANTITY_OF_NUMBERS);
        System.out.println("Twoje liczby to: " + userNumbers);

        System.out.println("Teraz losujemy liczby.");
        Set<Integer> drawnNumbers = randomNumberGenerator.generateRandomNumbers(QUANTITY_OF_NUMBERS);
        System.out.println("Wylosowane liczby to: " + drawnNumbers);

        userNumbers.retainAll(drawnNumbers);

        System.out.println("Liczba trafionych liczb to: " + userNumbers.size());

        if (!userNumbers.isEmpty()) {
            System.out.println("Twoje trafione liczby: " + userNumbers);
        } else {
            System.out.println("Niestety, nie trafiłeś żadnej liczby.");
        }
    }
}
