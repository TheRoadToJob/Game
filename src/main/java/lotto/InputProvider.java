package lotto;

interface InputProvider {

    String getString();

    String getString(String message);

    int getInt();

    int getInt(String message);
}
