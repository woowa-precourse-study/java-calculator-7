package calculator.view;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class OutputView {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");

    private OutputView() {}

    public static void printResult(int result) {
        String format = messages.getString("result.format");
        System.out.println(MessageFormat.format(format, result));
    }

    public static void printError(String message) {
        String format = messages.getString("error.format");
        System.out.println(MessageFormat.format(format, message));
    }
}
