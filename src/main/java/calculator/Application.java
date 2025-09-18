package calculator;

import calculator.util.Parser;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    InputController inputController = new InputController();
    String stringInput = inputController.getString();

    // Validator 부분

    // Parser 부분
    int[] targetNumbers = Parser.parseStringToIntArray(stringInput);

    // Calculator 부분
    int result = Calculator.calculate(targetNumbers);

    // Output Controller 부분
    OutputController.printResult(result);
  }
}
