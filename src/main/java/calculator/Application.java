package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    //Input Controller 부분
    System.out.println("덧셈할 문자열을 입력해 주세요");
    String stringInput = Console.readLine();

    // Validator 부분
    if (!Pattern.matches("^\\d+(?:[,:]\\d+)*$", stringInput))
    {
      throw new IllegalArgumentException("문자열 형식이 올바르지 않습니다.");
    }

    // Parser 부분
    String[] targetNumbers = stringInput.split("[,:]");
    int[] targetNumbersInt = new int[targetNumbers.length];
    for (int i = 0; i < targetNumbers.length; i++) {
      targetNumbersInt[i] = Integer.parseInt(targetNumbers[i]);
    }

    // Calculator 부분
    int sum = 0;
    for (int number : targetNumbersInt) {
      sum += number;
    }

    // Output Controller 부분
    System.out.println("결과 : " + sum);

  }
}
