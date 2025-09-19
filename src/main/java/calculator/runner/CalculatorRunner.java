package calculator.runner;

import calculator.io.InputView;
import calculator.io.OutputView;
import calculator.service.CalculatorService;
import calculator.service.impl.CalculatorServiceImpl;


public class CalculatorRunner {
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
