package calculator.Controller;

import calculator.ErrorMessage;
import calculator.Service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자 입출력에 대한 책임을 진다.
 */
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // 메인 controller 함수
    public void calculate() {
        String inputString=inputHandler();
        int outputInteger=calculatorService.getCalculate(inputString);
        outputHandler(outputInteger);
    }

    // 입력값 처리
    public String inputHandler() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        String inputString=Console.readLine();
        if (inputString == null || inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        return inputString;
    }

    // 출력값 처리
    public void outputHandler(int outputInteger) {
        System.out.println("결과 : " + outputInteger);
    }

}
