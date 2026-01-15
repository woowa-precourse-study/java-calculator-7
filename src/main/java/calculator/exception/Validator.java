package calculator.exception;

import java.util.regex.Matcher;

public class Validator {

    public static void validateInputFormat(Matcher matcher) {
        if (matcher.start() != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다.");
        }
    }

}


