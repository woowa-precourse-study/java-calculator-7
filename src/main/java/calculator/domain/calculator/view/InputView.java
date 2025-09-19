package calculator.domain.calculator.view;

import camp.nextstep.edu.missionutils.Console;
import calculator.global.message.MessageCode;

public class InputView {
    private InputView() {}

    public static String readInput() {
        System.out.println(MessageCode.INPUT_GUIDE.getMessage());
        return Console.readLine();
    }
}
