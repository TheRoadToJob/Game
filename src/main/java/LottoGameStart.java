import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Set;

public class LottoGameStart {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserInput userInput = new UserInput(scanner);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        LottoGame lottoGame = new LottoGame(userInput, randomNumberGenerator);

        lottoGame.play();
    }
}
