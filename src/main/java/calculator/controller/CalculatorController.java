package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.math.BigInteger;

public class CalculatorController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String inputString = inputView.readInput();

        if (inputString.isBlank()) {
            outputView.printOutput(BigInteger.ZERO);
            return;
        }

        Calculator calculator = new Calculator(inputString);
        BigInteger sum = calculator.sum();
        outputView.printOutput(sum);
    }
}
