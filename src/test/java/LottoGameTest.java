import lotto.LottoGame;
import lotto.Output;
import lotto.RandomNumberGenerator;
import lotto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

class LottoGameTest {

    private UserInput mockUserInput;
    private RandomNumberGenerator mockRandomNumberGenerator;
    private Output mockOutput;

    private LottoGame lottoGame;

    @BeforeEach
    public void init() {
        mockUserInput = mock(UserInput.class);
        mockRandomNumberGenerator = mock(RandomNumberGenerator.class);
        mockOutput = mock(Output.class);

        lottoGame = new LottoGame(mockUserInput, mockRandomNumberGenerator, mockOutput);
    }

    public String formatSet(Set<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList()
                .toString();
    }

    @Test
    void should_return_() {
        //given
        HashSet<Integer> userNumbers = new HashSet<>(Set.of(1, 10, 11, 50, 80, 99));
        HashSet<Integer> drawNumbers = new HashSet<>(Set.of(1, 10, 11, 60, 70, 90));
        when(mockUserInput.selectNumbers(6)).thenReturn(userNumbers);
        when(mockRandomNumberGenerator.generateRandomNumbers(6)).thenReturn(drawNumbers);

        //when
        lottoGame.play();

        //then
        //verify(mockOutput).println("Wybierz 6 liczb z puli od 1 do 99.");
        verify(mockOutput).println("Twoje liczby to: " + formatSet(userNumbers));
        //verify(mockOutput).println("Teraz losujemy liczby.");
        verify(mockOutput).println("Wylosowane liczby to: " + formatSet(drawNumbers));
        //verify(mockOutput).println("Liczba trafionych liczb to: 3");
        verify(mockOutput).println("Twoje trafione liczby: " + formatSet(Set.of(1, 10, 11)));

    }
}