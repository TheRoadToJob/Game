package lotto;

public interface InputProvider {

    String getString();
    String getString(String message);

    int getInt();
    int getInt(String message);

    void print(String message);

    void closeScanner();
}
