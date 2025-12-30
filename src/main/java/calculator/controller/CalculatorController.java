package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {
    private final InputView inputView;
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {
        String input = inputView.readMessage();
        OutputView.printResult(service.calculateTotal(input));
    }


}

