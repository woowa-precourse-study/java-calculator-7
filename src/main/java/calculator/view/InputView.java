package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MSG = "덧셈할 문자열을 입력해주세요.";

    public String readInput() {
        System.out.println(INPUT_MSG);
        return Console.readLine().trim();
    }
}
