package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;
        String inputString;
        List<String> delimiter = new ArrayList<>(List.of("\\n", ","));
        List<Integer> numbers = new ArrayList<>();
        Pattern patternString = Pattern.compile("^//(.)\n(.*)");
        Pattern patternInteger = Pattern.compile("[\\d+]");
        String userDelimiter;

        System.out.println("덧셈할 문자열을 입력해주세요");
        inputString = Console.readLine();

        //빈 문자열이면 0 출력
        if (inputString.length() == 0) {
            System.out.println("결과 : " + 0);
        } else {

            // 사용자 지정 구분자를 추출해서 리스트에 추가
            Matcher matcherString = patternString.matcher(inputString);
            if (matcherString.find()) {
                userDelimiter = matcherString.group(1);
                delimiter.add(userDelimiter);
            }

            // 구분자로 분리하여, 숫자 추출
            Matcher matcherInteger = patternInteger.matcher(inputString);
            while (matcherInteger.find()) {
                numbers.add(Integer.valueOf(matcherInteger.group()));
            }

            // 숫자를 모두 더한다.
            result = numbers.stream().mapToInt(Integer::intValue).sum();
            System.out.println("결과 : " + result);
            }
        }
}
