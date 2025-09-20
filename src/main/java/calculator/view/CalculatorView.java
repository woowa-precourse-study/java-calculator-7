package calculator.view;

import calculator.util.Constant;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
  public String readInput() {
    System.out.println(Constant.REQUIRE_INPUT_MESSAGE);
    return Console.readLine();
  }
  public static void printResult(int result){
    System.out.println(Constant.OUTPUT_MESSAGE + result);
  }
}
