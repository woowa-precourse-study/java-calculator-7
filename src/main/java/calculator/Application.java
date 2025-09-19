package calculator;

import calculator.Controller.CalculatorController;
import calculator.Service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorService service = new CalculatorService();
        CalculatorController controller = new CalculatorController(service);
        controller.calculate();

    }
}
