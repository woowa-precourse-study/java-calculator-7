package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";

    private InputView() {
    }

    public static String readInput() {
        System.out.println(INPUT_GUIDE);
        return Console.readLine();
    }
}
