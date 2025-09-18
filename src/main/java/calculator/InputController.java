package calculator;

import calculator.util.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputController {
  public String getString(){
    System.out.println(Constant.INPUT_ERROR_MESSAGE);
    String stringInput = Console.readLine();
    return stringInput;
  }
}
