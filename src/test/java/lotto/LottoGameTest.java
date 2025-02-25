package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoGameTest {

    UserInput userInputMock;
    RandomNumberGenerator randomNumberGeneratorMock;

    LottoGame lottoGame;

    @BeforeEach
    void init() {
        userInputMock = mock(UserInput.class);
        randomNumberGeneratorMock = mock(RandomNumberGenerator.class);
        lottoGame = new LottoGame(userInputMock, randomNumberGeneratorMock);
    }

    @Test
    void should_return_win_six_numbers() {
        //given
        Set<Integer> userNumbers = new HashSet<>(Set.of(10, 22, 34, 45, 56, 69));
        when(userInputMock.selectNumbers(6)).
                thenReturn(userNumbers);
        Set<Integer> drawnNumbers = new HashSet<>(Set.of(10, 22, 34, 45, 56, 69));
        when(randomNumberGeneratorMock.generateRandomNumbers(6))
                .thenReturn(drawnNumbers);

        //when
        String result = lottoGame.play();

        //then
        assertTrue(result.contains("Ilość trafionych liczb to: 6"));
        assertTrue(result.contains("Twoje trafione liczby: "));
        assertTrue(result.contains("10"));
        assertTrue(result.contains("22"));
        assertTrue(result.contains("34"));
        assertTrue(result.contains("45"));
        assertTrue(result.contains("56"));
        assertTrue(result.contains("69"));
    }

    @Test
    void should_return_win_three_numbers() {
        //given
        Set<Integer> userNumbers = new HashSet<>(Set.of(10, 22, 34, 45, 56, 69));
        when(userInputMock.selectNumbers(6)).
                thenReturn(userNumbers);
        Set<Integer> drawnNumbers = new HashSet<>(Set.of(11, 22, 34, 45, 53, 64));
        when(randomNumberGeneratorMock.generateRandomNumbers(6))
                .thenReturn(drawnNumbers);

        //when
        String result = lottoGame.play();

        //then
        assertTrue(result.contains("Ilość trafionych liczb to: 3"));
    }

    @Test
    void should_return_win_zero_numbers() {
        //given
        Set<Integer> userNumbers = new HashSet<>(Set.of(10, 22, 34, 45, 56, 69));
        when(userInputMock.selectNumbers(6)).
                thenReturn(userNumbers);
        Set<Integer> drawnNumbers = new HashSet<>(Set.of(11, 20, 30, 46, 53, 64));
        when(randomNumberGeneratorMock.generateRandomNumbers(6))
                .thenReturn(drawnNumbers);

        //when
        String result = lottoGame.play();

        //then
        assertTrue(result.contains("Ilość trafionych liczb to: 0"));
        assertTrue(result.contains("Niestety, nie trafiłeś żadnej liczby."));
    }
}