package calculator;

import calculator.util.Constant;
import calculator.util.Parser;


public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    InputController inputController = new InputController();
    String stringInput = inputController.getString();

    // Validator 부분
    String validatedString = Validator.validate(stringInput);

    // Parser 부분
    int[] targetNumbers = Parser.parseStringToIntArray(validatedString);
    // Calculator 부분
    int sum = 0;
    for (int number : targetNumbers) {
      sum += number;
    }

    // Output Controller 부분
    System.out.println(Constant.OUTPUT_MESSAGE + sum);

  }
}
