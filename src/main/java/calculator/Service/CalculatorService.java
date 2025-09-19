package calculator.Service;

import calculator.ErrorMessage;
import calculator.domain.Delimiter;
import calculator.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 기능 1. 사용장 지정 구분자를 인식하고, 구분자 객체 생성 매서드를 호출한다.
 * 기능 2. 입력값에서 기능 1에서 매칭한 부분을 제거한 문자열을 반환한다.
 * 기능 3. 숫자 문자열을 숫자 정수 리스트로 반환하는 메서드를 호출한다.
 * 기능 4. 숫자 리스트의 총합을 구한다.
 */
public class CalculatorService {

    // 메인 서비스 로직 (로직 총 집합)
    public Integer getCalculate(String inputString){
        System.out.println(inputString);
        String[] result= addUserDelimiter(inputString);
        Delimiter delimiter=Delimiter.buildDelimiter(result[0]);

        System.out.println("splitNumString(inputString) : "+result[1]);
        Number numbers=Number.getIntergeListFromString(result[1],delimiter);
        return getAllSum(numbers.getNumbers());
    }

    // 사용자 지정 구분자 문자열 반환
    public String[] addUserDelimiter(String inputString) {
        Pattern pattern = Pattern.compile("//(.*)\\\\n");
        Matcher matcher = pattern.matcher(inputString);

        String newDelimiter="";

        if (matcher.find()) {
            newDelimiter=matcher.group(1);
            // 예외 처리
            if (newDelimiter.length()>=2){
                throw new IllegalArgumentException(ErrorMessage.MULTI_CHAR_DELIMITER);
            }

            // 사용자 지정 문자열 추가
            newDelimiter="|"+pattern.quote(newDelimiter);

            // 치환
            inputString = matcher.replaceAll("");
        }
        return new String[] {newDelimiter, inputString};
    }


    // 숫자 리스트의 총합 구하기
    public int getAllSum(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
