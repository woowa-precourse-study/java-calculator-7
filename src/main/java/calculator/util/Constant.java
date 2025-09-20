package calculator.util;

public class Constant {
  public static final String REQUIRE_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요";
  public static final String NORMAL_INPUT_ERROR_MESSAGE = "문자열 형식이 올바르지 않습니다.";
  public static final String CUSTOM_INPUT_ERROR_MESSAGE = "커스텀 문자열 형식이 올바르지 않습니다.";
  public static final String NORMAL_INPUT_STRING_REGEX = "^\\d+(?:[,:]\\d+)*$";
  public static final String CUSTOM_INPUT_STRING_REGEX ="^//(.+?)\\r?\\n([0-9]+(?:[^0-9\\r\\n]+[0-9]+)*)$";
  public static final String OUTPUT_MESSAGE = "결과 : ";

}
