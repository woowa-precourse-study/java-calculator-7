package calculator;

public class ErrorMessage {
    private ErrorMessage() {}

    public static final String EMPTY_INPUT = "문자열이 입력되지 않았습니다.";
    public static final String MULTI_CHAR_DELIMITER = "사용자 지정 구분자는 한 글자이어야 합니다.";
    public static final String NUMBER_STRING_NOT_FOUND = "숫자열을 찾을 수 없습니다.";
    public static final String INVALID_SPLIT = "구분자로 분리할 수 없습니다. : ";
    public static final String NEGATIVE_NUMBER = "음수를 입력할 수 없습니다.";

}
