package calculator.service.impl;

import calculator.service.CalculatorService;
import calculator.util.DelimiterParser;

public class CalculatorServiceImpl implements CalculatorService {
    private static final String NUMBER_REGEX = "\\d+";
    private static final String ERROR_INVALID_NUMBER = "허용되지 않은 값이 포함되어 있습니다: ";

    @Override
    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        DelimiterParser.DelimiterResult delimiterResult = DelimiterParser.parse(input);
        String[] tokens = delimiterResult.getNumbers().split(delimiterResult.getDelimiter());

        return sumTokens(tokens);
    }

    private int sumTokens(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            if (!token.matches(NUMBER_REGEX)) {
                throw new IllegalArgumentException(ERROR_INVALID_NUMBER + token);
            }
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
