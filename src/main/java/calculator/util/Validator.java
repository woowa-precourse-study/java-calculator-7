package calculator.util;

import calculator.dto.ParsedResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

  public static ParsedResult validate(String input) {
    if (input == null) {
      throw new IllegalArgumentException(Constant.NORMAL_INPUT_ERROR_MESSAGE);
    }
    input = input.replace("\\n", "\n");

    //일반 문자열 검증
    if (Pattern.matches(Constant.NORMAL_INPUT_STRING_REGEX, input)) {
      return new ParsedResult(null, input);
    }

    Matcher matcher = Pattern.compile(Constant.CUSTOM_INPUT_STRING_REGEX).matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(Constant.CUSTOM_INPUT_ERROR_MESSAGE);
    }
    String customSeparator = matcher.group(1);
    String mainString = matcher.group(2);
    //디버깅 코드
//    System.out.println("this is main" + mainString);

    String allowedSeparator = "(?:,|:|" + Pattern.quote(customSeparator) + ")";
    String finalPattern = "^\\d+(?:" + allowedSeparator + "\\d+)*$";
    if (!Pattern.matches(finalPattern, mainString)) {
      throw new IllegalArgumentException(Constant.CUSTOM_INPUT_ERROR_MESSAGE);
    }
    return new ParsedResult(customSeparator, mainString);
  }

}
