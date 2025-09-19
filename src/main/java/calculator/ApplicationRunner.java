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
            // 예외 메시지 출력 책임은 여기서만
            OutputView.printError(e.getMessage());
        }
    }
}
