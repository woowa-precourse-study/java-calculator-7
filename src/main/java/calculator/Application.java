package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    private static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]"; // 기본 구분자

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 입력입니다.");
            }
            delimiter = input.substring(2, newlineIndex);
            input = input.substring(newlineIndex + 1);
        }

        // split
        String[] tokens = input.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) continue; // 빈 값 무시
            if (!token.matches("\\d+")) {
                throw new IllegalArgumentException("허용되지 않은 값이 포함되어 있습니다: " + token);
            }
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
