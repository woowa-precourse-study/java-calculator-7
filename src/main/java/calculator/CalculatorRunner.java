package calculator;

import calculator.Controller.CalculatorController;
import calculator.Service.CalculatorService;

public class CalculatorRunner {
    private final CalculatorController calculatorController;


    public CalculatorRunner(){
        CalculatorService calculatorService=new CalculatorService();
        this.calculatorController=new CalculatorController(calculatorService);
    }

    public void run(){
        calculatorController.calculate();
    }
}
