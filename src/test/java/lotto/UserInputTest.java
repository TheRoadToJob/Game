package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserInputTest {

    ConsoleInputProvider consoleInputProviderMock;
    UserInput userInput;

    @BeforeEach
    void init() {
        consoleInputProviderMock = mock(ConsoleInputProvider.class);
        userInput = new UserInput(consoleInputProviderMock);
    }

    @Test
    void should_return_correct_numbers_of_unique_numbers() {
        //given
        when(consoleInputProviderMock.getInt())
                .thenReturn(10,20, 30, 40, 50, 60);

        //when
        Set<Integer> result = userInput.selectNumbers(6);

        //then
        assertEquals(6, result.size());
        assertTrue(result.containsAll(Set.of(10, 20, 30, 40, 50, 60)));
    }

    @Test
    void should_reject_numbers_out_of_range() {
        //given
        when(consoleInputProviderMock.getInt())
                .thenReturn(-10, 150, 10, 20, 30, 40, 50, 60);

        //when
        Set<Integer> result = userInput.selectNumbers(6);

        //then
        assertEquals(6, result.size());
        assertFalse(result.contains(150));
        assertFalse(result.contains(-10));
    }

    @Test
    void should_reject_duplicate_numbers() {
        //given
        when(consoleInputProviderMock.getInt())
                .thenReturn(10,20, 20, 30, 40, 40, 50, 60);

        //when
        Set<Integer> result = userInput.selectNumbers(6);

        //then
        assertEquals(6, result.size());
        assertEquals(Set.of(10, 20, 30, 40, 50, 60), result);
    }
}