package calculator.controller;

import calculator.service.CalculatorService;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorController {
    private final InputView inputView;
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {
        String names = inputView.readMessage();
        String delimeters= String.join("|",List.of(Pattern.quote(","),Pattern.quote(":")));
        int[] numbers = Arrays.stream(names.split(delimeters))
                .mapToInt(Integer::parseInt).toArray();
        OutputView.printResult(Arrays.stream(numbers).sum());

    }


}

