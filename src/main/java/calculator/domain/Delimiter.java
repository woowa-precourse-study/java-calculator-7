package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 구분자(사용자 지정 구분자 포함)를 생성하는 책임을 진다.
 */
public class Delimiter {

    public static final String DEFAULT_DELIMITER=Pattern.quote(",")+"|"+Pattern.quote(":");
    private final String delimiter;

    private Delimiter(String delimiter) {
        // 검증 추가 예정
        this.delimiter = delimiter;
    }

    public static Delimiter buildDelimiter(String inputString) {
        if (!inputString.isEmpty()) {
            return new Delimiter(Delimiter.DEFAULT_DELIMITER+inputString);
        }
        return new Delimiter(DEFAULT_DELIMITER);
    }

    public String getDelimiter() {
        return delimiter;
    }


// 구분자에 대한 에러처리를 던지는 것
//    public String validateDelimiter(String inputString) {
//        Pattern pattern = Pattern.compile("^//(.)\n(.*)");
//    }

}
