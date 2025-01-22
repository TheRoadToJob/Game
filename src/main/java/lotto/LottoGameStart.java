package lotto;

import java.util.Scanner;

class LottoGameStart implements Game {

    public void start() {
        ConsoleInputProvider consoleInputProvider = new ConsoleInputProvider(new Scanner(System.in));
        UserInput userInput = new UserInput(consoleInputProvider);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        LottoGame lottoGame = new LottoGame(userInput, randomNumberGenerator, consoleInputProvider);
        lottoGame.play();
    }

    @Override
    public String getName() {
        return "LottoGame";
    }
}