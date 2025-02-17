package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LottoGameTest {

    UserInput userInputMock;
    RandomNumberGenerator randomNumberGeneratorMock;
    InputProvider inputProviderMock;
    LottoGame lottoGame;

    @BeforeEach
    void init() {
        userInputMock = mock(UserInput.class);
        randomNumberGeneratorMock = mock(RandomNumberGenerator.class);
        inputProviderMock = mock(InputProvider.class);
        lottoGame = new LottoGame(userInputMock, randomNumberGeneratorMock, inputProviderMock);
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
        lottoGame.play();

        //then
        verify(inputProviderMock).print("Liczba trafionych liczb to: 6");
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
        lottoGame.play();

        //then
        verify(inputProviderMock).print("Liczba trafionych liczb to: 3");
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
        lottoGame.play();

        //then
        verify(inputProviderMock).print("Liczba trafionych liczb to: 0");
    }
}