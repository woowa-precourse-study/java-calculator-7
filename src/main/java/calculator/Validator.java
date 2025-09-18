package calculator;

import calculator.util.Constant;
import java.util.regex.Pattern;

public class Validator {

  public static String validate(String input) {
    if (!Pattern.matches(Constant.INPUT_STRING_REGEX, input)) {
      throw new IllegalArgumentException(Constant.INPUT_ERROR_MESSAGE);
    }
    return input;
  }
}
