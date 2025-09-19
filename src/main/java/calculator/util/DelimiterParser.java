package calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_PATTERN = "//(.*?)\\\\n"; // //...\n 패턴
    private static final String ERROR_INVALID_CUSTOM = "잘못된 커스텀 구분자 입력입니다.";

    private DelimiterParser() {
    }

    public static DelimiterResult parse(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(DEFAULT_DELIMITER);

        Pattern pattern = Pattern.compile(CUSTOM_PATTERN);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            String customDelimiter = matcher.group(1);
            if (customDelimiter == null || customDelimiter.isEmpty()) {
                throw new IllegalArgumentException(ERROR_INVALID_CUSTOM);
            }
            delimiters.add(Pattern.quote(customDelimiter));
            found = true;
        }

        // 선언부 제거 → 구분자 자리에 쉼표로 대체
        String numbers = input.replaceAll(CUSTOM_PATTERN, ",");

        // 최종 delimiter 조합
        String delimiterRegex = String.join("|", delimiters);

        return new DelimiterResult(delimiterRegex, numbers);
    }

    public static class DelimiterResult {
        private final String delimiter;
        private final String numbers;

        public DelimiterResult(String delimiter, String numbers) {
            this.delimiter = delimiter;
            this.numbers = numbers;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public String getNumbers() {
            return numbers;
        }
    }
}
