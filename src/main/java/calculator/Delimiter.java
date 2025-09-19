package calculator;

public class Delimiter {
    private final String delimiter;

    public Delimiter() {
        delimiter = ",;";
    }

    public Delimiter(String customDelimiter) {
        this.delimiter = ",:" + customDelimiter;
    }

    public String[] split(String input) {
        return input.split("[" + delimiter + "]");
    }
}