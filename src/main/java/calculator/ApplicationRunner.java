package calculator;

import calculator.controller.CalculatorController;
import calculator.view.OutputView;
import calculator.error.CalculatorException;

public class ApplicationRunner {
    private final CalculatorController controller = new CalculatorController();

    public void run() {
        try {
            controller.run();
        } catch (CalculatorException e) {
            OutputView.printError(e.getMessage());
            throw e;
        }
    }
}
