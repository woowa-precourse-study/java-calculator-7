package calculator.domain;

import java.util.regex.Pattern;

public class Separator {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";

    private final String delimiterRegex;

    public Separator(String inputValue) {
        this.delimiterRegex = resolveDelimiter(inputValue);
    }

    public String[] split(String inputValue) {
        if (hasCustomSeparator(inputValue)) {
            String target = inputValue.substring(inputValue.indexOf(CUSTOM_SUFFIX) + 2);
            return target.split(delimiterRegex);
        }
        return inputValue.split(delimiterRegex);
    }

    private boolean hasCustomSeparator(String inputValue) {
        return inputValue.startsWith(CUSTOM_PREFIX) && inputValue.contains(CUSTOM_SUFFIX);
    }

    private String resolveDelimiter(String inputValue) {
        if (!hasCustomSeparator(inputValue)) {
            return DEFAULT_SEPARATOR;
        }
        String custom = inputValue.substring(2, inputValue.indexOf(CUSTOM_SUFFIX));
        validate(custom);
        return Pattern.quote(custom);
    }

    private void validate(String custom) {
        if (custom.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자는 한 글자여야 합니다.");
        }
        if (",:".contains(custom)) {
            throw new IllegalArgumentException("[ERROR] 기본 구분자(, :)는 커스텀 불가합니다.");
        }
        if (Character.isDigit(custom.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 숫자는 구분자로 사용할 수 없습니다.");
        }
    }
}
