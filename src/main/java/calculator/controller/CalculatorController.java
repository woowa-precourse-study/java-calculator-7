package calculator.controller;

import calculator.service.CalculatorService;

import java.util.NoSuchElementException;

public class CalculatorController {
    private final InputView inputView;
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {
        try {
            String input = inputView.readMessage();
            OutputView.printResult(service.calculateTotal(input));
        } catch (NoSuchElementException e){
            OutputView.printResult(0);
        }

    }

}

