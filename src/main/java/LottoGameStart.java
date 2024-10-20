import java.util.Set;

public class LottoGameStart {

    public static void main(String[] args) {

        System.out.println("Wybierz 6 liczb z puli od 1 do 99.");

        LottoGame lottoGame = new LottoGame();
        Set<Integer> numbers = lottoGame.selectNumbers();

        System.out.println("Twoje liczby to: " + numbers.toString());

    }
}
