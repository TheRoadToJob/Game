package lotto;

import java.util.Scanner;

public class LottoGameStart {


    public void start() {
        Scanner scanner = new Scanner(System.in);

        UserInput userInput = new UserInput(scanner);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Output output = new ConsoleOutput();

        LottoGame lottoGame = new LottoGame(userInput, randomNumberGenerator, output);

        lottoGame.play();
    }
}
