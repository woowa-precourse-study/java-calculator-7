package calculator.domain;

import calculator.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 문자열을 정수 숫자 리스트로 바꾸는 책임을 진다.
 */
public class Number {
    private final List<Integer> numbers;

    private Number(List<Integer> numbers){
        //검증 코드 추가 예정
        this.numbers=numbers;
    }

    public static Number getIntergeListFromString(String InputString,Delimiter delimiter){
        List<Integer> parsed=new ArrayList<>();
        String[] tokens=InputString.split(delimiter.getDelimiter());
        System.out.println(InputString);
        System.out.println(tokens);
        for (String token : tokens) {

            if (token.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_STRING_NOT_FOUND);
            }

            try {
                int value=Integer.parseInt(token);

                if (value<0){
                    throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER);
                }
                parsed.add(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_SPLIT + token);
            }


        }
        return new Number(parsed);

    }


    public List<Integer> getNumbers(){
        return numbers;
    }


}
