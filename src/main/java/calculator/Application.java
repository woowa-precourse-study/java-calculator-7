package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 기본 구분자
        String delimiter = "[,:]";

        // 커스텀 구분자 처리 ("//<구분자>\n")
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n"); // 문자열 "\n" 찾기
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 입력입니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            // 기본 구분자 + 커스텀 구분자 모두 허용
            delimiter = delimiter + "|" + Pattern.quote(customDelimiter);
            // 실제 숫자 부분만 남김
            input = input.substring(newlineIndex + 2);
        }

        String[] tokens = input.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            if (!token.matches("\\d+")) {
                throw new IllegalArgumentException("허용되지 않은 값이 포함되어 있습니다: " + token);
            }
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
