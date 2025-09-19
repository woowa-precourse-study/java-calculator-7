package calculator.controller;

import calculator.service.CalculatorService;
import calculator.util.Parser;
import calculator.view.CalculatorView;

public class CalculatorController {

  private final CalculatorView calculatorView;

  public CalculatorController(CalculatorView calculatorView) {
    this.calculatorView = calculatorView;
  }

  public void run() {
    try {
      String input = calculatorView.readInput();
      int[] targetNumbers = Parser.parseStringToIntArray(input);
      int result = CalculatorService.calculate(targetNumbers);
      calculatorView.printResult(result);
    } catch (IllegalAccessError e) {
      e.printStackTrace();
    }
  }
}
