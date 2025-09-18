package calculator;

import calculator.util.Constant;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현


    InputController inputController = new InputController();
    String stringInput = inputController.getString();

    // Validator 부분
    Validator.validate(stringInput);

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
    System.out.println(Constant.OUTPUT_MESSAGE+ sum);

  }
}
