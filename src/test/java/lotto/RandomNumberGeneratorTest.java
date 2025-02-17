package lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    void should_generate_correct_number_of_unique_numbers() {

        //given
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int exceptedSize = 6;

        //when
        Set<Integer> randomNumbers = generator.generateRandomNumbers(exceptedSize);

        //then
        assertEquals(exceptedSize, randomNumbers.size());
    }

    @Test
    void should_generate_numbers_within_range() {

        //given

        RandomNumberGenerator generator = new RandomNumberGenerator();
        int quantity = 10;

        //when
        Set<Integer> randomNumbers = generator.generateRandomNumbers(quantity);

        //then
        assertTrue(randomNumbers.stream()
                .allMatch(num -> num >= LottoGame.MIN_NUM && num <= LottoGame.MAX_NUM));
    }

    @Test
    void should_generate_unique_numbers() {

        //given
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int quantity = 10;

        //when
        Set<Integer> randomNumbers = generator.generateRandomNumbers(quantity);

        //then
        assertEquals(quantity, randomNumbers.size());
    }
}