package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public void run() {
        String input = InputView.readInput();
        int result = calculatorService.calculate(input);
        OutputView.printResult(result);
    }
}
