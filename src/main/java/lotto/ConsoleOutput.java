package lotto;

class ConsoleOutput implements Output{

    private final String text;

    public ConsoleOutput(String text) {
        this.text = text;
    }

    @Override
    public void println(String message) {

        System.out.println(text);
    }
}
