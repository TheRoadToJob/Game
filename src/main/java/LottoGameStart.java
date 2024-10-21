import java.security.NoSuchAlgorithmException;
import java.util.Set;

public class LottoGameStart {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.println("Wybierz 6 liczb z puli od 1 do 99.");

        LottoGame lottoGame = new LottoGame();
        Set<Integer> numbers = lottoGame.selectNumbers();

        System.out.println("Twoje liczby to: " + numbers.toString());

        System.out.println("Teraz losujemy liczby.");

        Set<Integer> randomNumbers = lottoGame.randomNumbers();

        System.out.println("Wylosowane liczby to: " + randomNumbers.toString());

        numbers.retainAll(randomNumbers);

        System.out.println("Liczba trafionych liczb to: " + numbers.size());

        if (!numbers.isEmpty()) {
            System.out.println("Twoje trafione liczby: " + numbers.toString());
        }

    }
}
