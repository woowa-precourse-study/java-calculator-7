package calculator.controller;

import calculator.util.Constant;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
  public String getString() {
    System.out.println(Constant.REQUIRE_INPUT_MESSAGE);
    String stringInput = Console.readLine();
    return stringInput;
  }
  public static void printResult(int result){
    System.out.println(Constant.OUTPUT_MESSAGE + result);
  }
}
