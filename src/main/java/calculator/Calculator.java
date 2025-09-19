package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private Delimiter delimiter;
    private String[] numbers;
    private int result;

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        CustomController customController = new CustomController();
        input = customController.getNewInputIfCustom(input);

        if (delimiter == null) {
            delimiter = new Delimiter();
        }

        numbers = delimiter.split(input);
        calculateResult();

        return result;
    }

    private void calculateResult() {
        for (String number : numbers) {
            // 만약 s가 숫자(양수)가 아니면 IllegalArgumentException 예외 발생
            // 오버플로우 발생 시 예외 발생
            try {
                result = safeAdd(result, Integer.parseUnsignedInt(number));
            } catch (RuntimeException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private int safeAdd(int result, int number) {
        if (result > Integer.MAX_VALUE - number) {
            throw new ArithmeticException("Overflow");
        }
        return result + number;
    }

    private class CustomController {
        private static final String CUSTOM_DELIMITER_PATTERN = "^//(.*)\\\\n(.*)";
        private static final int CUSTOM_DELIMITER_GROUP = 1;
        private static final int CUSTOM_PURE_INPUT_GROUP = 2;

        private String getNewInputIfCustom(String input) {
            Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                String customDelimiter = extractCustomDelimiter(matcher);
                delimiter = new Delimiter(customDelimiter);
                input = extractPureInput(matcher);
            }
            return input;
        }

        private String extractCustomDelimiter(Matcher matcher) {
            return matcher.group(CUSTOM_DELIMITER_GROUP);
        }

        private String extractPureInput(Matcher matcher) {
            return matcher.group(CUSTOM_PURE_INPUT_GROUP);
        }
    }
}