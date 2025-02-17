package lotto;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

class RandomNumberGenerator {

    private final SecureRandom secureRandom;

    public RandomNumberGenerator() {
        this.secureRandom = new SecureRandom();
    }

    public Set<Integer> generateRandomNumbers(int quantityOfNumbers) {

        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < quantityOfNumbers) {

            int number = secureRandom.nextInt(LottoGame.MAX_NUM) + LottoGame.MIN_NUM;
            randomNumbers.add(number);
        }
        return randomNumbers;

    }
}
