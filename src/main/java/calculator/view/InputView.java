package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ResourceBundle;

public class InputView {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");

    private InputView() {}

    public static String readInput() {
        System.out.println(messages.getString("input.guide"));
        return Console.readLine();
    }
}
