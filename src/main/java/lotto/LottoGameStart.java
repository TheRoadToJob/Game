package lotto;

import java.util.Scanner;

class LottoGameStart {

    public void start() {

        Scanner scanner = new Scanner(System.in);

        UserInput userInput = new UserInput(scanner);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        ConsoleOutput consoleOutput = new ConsoleOutput(userInput.toString());

        LottoGame lottoGame = new LottoGame(userInput, randomNumberGenerator, consoleOutput);
        lottoGame.play();
    }
}