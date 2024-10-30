import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator {

    private final SecureRandom secureRandom;

    public RandomNumberGenerator() {
        this.secureRandom = new SecureRandom();
    }

    public Set<Integer> generateRandomNumbers(int quantityOfNumbers) {

        Set<Integer> randomNumbers = new HashSet<>();

        for (int i = 0; i < quantityOfNumbers; i++) {

            int number = secureRandom.nextInt(99) + 1;
            randomNumbers.add(number);
        }
        return randomNumbers;
    }
}
