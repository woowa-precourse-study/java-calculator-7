package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.service.CalculatorService;
import calculator.service.impl.CalculatorServiceImpl;


public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public void run() {
        String input = InputView.readInput();
        try {
            int result = calculatorService.calculate(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
