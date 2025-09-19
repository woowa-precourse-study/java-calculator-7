package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    public static final String DEFAULT_DELIMITER=",|/n";
    private final String delimiter;

    private Delimiter(String delimiter) {
        // 검증 추가 예정
        this.delimiter = delimiter;
    }

    public static Delimiter buildDelimiter(String inputString) {
        if (inputString!=null){
            return new Delimiter(Delimiter.DEFAULT_DELIMITER+"|"+Pattern.quote(inputString));
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
