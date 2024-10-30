import java.util.Scanner;

public class LottoGameStart {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserInput userInput = new UserInput(scanner);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Output output = new ConsoleOutput();

        LottoGame lottoGame = new LottoGame(userInput, randomNumberGenerator, output);

        lottoGame.play();
    }
}
